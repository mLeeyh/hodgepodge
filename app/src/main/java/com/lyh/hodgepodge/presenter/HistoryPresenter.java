package com.lyh.hodgepodge.presenter;

import android.content.Context;
import android.util.Log;

import com.lyh.hodgepodge.http.HttpClient;
import com.lyh.hodgepodge.model.entity.History;
import com.lyh.hodgepodge.ui.view.IHistoryView;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lyh on 2017/1/22.
 */

public class HistoryPresenter extends BasePresenter<IHistoryView> {

    public HistoryPresenter(Context context, IHistoryView iView) {
        super(context, iView);
    }

    @Override
    public void release() {
        subscription.unsubscribe();
        subscription = null;
    }

    public void fetchHistoryData(String date) {
        iView.showProgressBar();
        subscription = HttpClient.getHttpRetrofitInstance()
                .getHistoryData(date, "29268", "", "2bc6af3dbede4893b5e00ff7f006e7dc")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<History, List<History.ShowapiResBodyBean.ListBean>>() {
                    @Override
                    public List<History.ShowapiResBodyBean.ListBean> call(History history) {
                        return history.getShowapi_res_body().getList();
                    }
                })
                .subscribe(new Action1<List<History.ShowapiResBodyBean.ListBean>>() {
                    @Override
                    public void call(List<History.ShowapiResBodyBean.ListBean> listBeen) {
                        iView.hideProgressBar();
                        if (listBeen.isEmpty()) {
                            Log.i("1111", "history isEmpty");
                            iView.showNoMoreData();
                        } else {
                            Log.i("1111", "history = " + listBeen.toString());
                            iView.showListView(listBeen);
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
