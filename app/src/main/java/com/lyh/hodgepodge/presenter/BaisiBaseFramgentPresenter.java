package com.lyh.hodgepodge.presenter;

import android.content.Context;
import android.util.Log;

import com.lyh.hodgepodge.http.HttpClient;
import com.lyh.hodgepodge.model.entity.Baisi;
import com.lyh.hodgepodge.ui.view.BaisiView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lyh on 2016/12/21.
 */

public class BaisiBaseFramgentPresenter extends BasePresenter<BaisiView> {

    public BaisiBaseFramgentPresenter(Context context, BaisiView iView) {
        super(context, iView);
    }

    @Override
    public void release() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void fetchBaisiData(int page, String type) {
        iView.showProgressBar();
        subscription = HttpClient.getHttpRetrofitInstance()
                .getBaisiData(page, "29268", "", "", type, "2bc6af3dbede4893b5e00ff7f006e7dc")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Baisi, List<Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean>>() {
                    @Override
                    public List<Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean> call(Baisi baisi) {
                        return baisi.getShowapi_res_body().getPagebean().getContentlist();
                    }
                })
                .subscribe(new Action1<List<Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean>>() {
                    @Override
                    public void call(List<Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list) {
                        iView.hideProgressBar();
                        if (list.size() == 0) {
                            iView.showNoMoreData();
                        } else {
                            Log.i("1111","list = " + list.toString());
                            iView.showListView(list);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        iView.hideProgressBar();
                        iView.showErrorView();
                    }
                });
    }
}
