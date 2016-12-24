package com.lyh.hodgepodge.presenter;

import android.content.Context;
import android.util.Log;

import com.lyh.hodgepodge.http.HttpClient;
import com.lyh.hodgepodge.model.entity.Baisi;
import com.lyh.hodgepodge.ui.view.BaisiView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
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

    public void fetchBaisiData() {
        subscription = HttpClient.getHttpRetrofitInstance()
                .getBaisiData("","29268","","","","2bc6af3dbede4893b5e00ff7f006e7dc")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Baisi, List<Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean>>() {
                    @Override
                    public List<Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean> call(Baisi baisi) {
                        return baisi.getShowapi_res_body().getPagebean().getContentlist();
                    }
                })
                .subscribe(new Subscriber<List<Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("1111","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("1111","onError" + e);
                    }

                    @Override
                    public void onNext(List<Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlistBeen) {
                        Log.d("1111","onNext" + contentlistBeen.toString());
                    }
                });
    }
}
