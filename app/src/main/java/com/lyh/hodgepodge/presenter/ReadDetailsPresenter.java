package com.lyh.hodgepodge.presenter;

import android.content.Context;
import android.util.Log;

import com.lyh.hodgepodge.http.HttpClient;
import com.lyh.hodgepodge.http.HttpRetrofit;
import com.lyh.hodgepodge.model.entity.ReadDetails;
import com.lyh.hodgepodge.ui.view.IReadDetailsView;
import com.lyh.hodgepodge.ui.view.IReadView;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lyh on 2017/1/18.
 */

public class ReadDetailsPresenter extends BasePresenter<IReadDetailsView> {
    public ReadDetailsPresenter(Context context, IReadDetailsView iView) {
        super(context, iView);
    }

    @Override
    public void release() {
        subscription.unsubscribe();
        subscription = null;
    }

    public void fetchReadDetailsData(String url) {
        iView.showProgressBar();
        subscription = HttpClient.getHttpRetrofitInstance()
                .getReadDetails("29268", "", url, "2bc6af3dbede4893b5e00ff7f006e7dc")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<ReadDetails, String>() {

                    @Override
                    public String call(ReadDetails readDetails) {
                        return readDetails.getShowapi_res_body().toString();
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String content) {
                        iView.hideProgressBar();
                        if (content.isEmpty()) {
                            Log.i("1111", "content isEmpty");
                            iView.showNoMoreData();
                        } else {
                            Log.i("1111", "content = " + content.toString());
                            iView.showReadDetails(content);
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
