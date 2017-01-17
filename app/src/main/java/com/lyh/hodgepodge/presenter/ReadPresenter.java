package com.lyh.hodgepodge.presenter;

import android.content.Context;
import android.util.Log;

import com.lyh.hodgepodge.http.HttpClient;
import com.lyh.hodgepodge.model.entity.Read;
import com.lyh.hodgepodge.model.entity.Read.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.lyh.hodgepodge.ui.view.IReadView;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lyh on 2017/1/9.
 */

public class ReadPresenter extends BasePresenter<IReadView>{


    public ReadPresenter(Context context, IReadView iView) {
        super(context, iView);
    }

    @Override
    public void release() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void fetchReadData(String id,int page){
        https://route.showapi.com/990-2?id=1&page=1&showapi_appid=29268&showapi_timestamp=&showapi_sign=2bc6af3dbede4893b5e00ff7f006e7dc
        subscription = HttpClient.getHttpRetrofitInstance().getReadData(id,page,"29268","","2bc6af3dbede4893b5e00ff7f006e7dc")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Read, List<ContentlistBean>>() {

                    @Override
                    public List<ContentlistBean> call(Read read) {
                        return read.getShowapi_res_body().getPagebean().getContentlist();
                    }
                })
                .subscribe(new Action1<List<ContentlistBean>>() {
                    @Override
                    public void call(List<ContentlistBean> contentlistBean) {
                        Log.i("1111", "read = " + contentlistBean.toString());
                        iView.hideProgressBar();
                        if (contentlistBean.size() == 0) {
                            Log.i("1111", "list = 0 ");
                            //iView.showNoMoreData();
                        } else {
                            Log.i("1111", "list1 = " + contentlistBean.toString());
                            iView.showListView(contentlistBean);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                    }
                });
    }
}
