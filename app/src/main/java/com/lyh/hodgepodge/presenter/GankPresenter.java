package com.lyh.hodgepodge.presenter;

import android.content.Context;
import android.util.Log;


import com.lyh.hodgepodge.http.HttpClient;
import com.lyh.hodgepodge.model.GankData;
import com.lyh.hodgepodge.model.entity.Gank;
import com.lyh.hodgepodge.ui.view.IGankView;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by xybcoder on 2016/3/1.
 */
public class GankPresenter extends BasePresenter<IGankView> {

    public GankPresenter(Context context, IGankView iView) {
        super(context, iView);
    }

    @Override
    public void release() {
        subscription.unsubscribe();
        subscription = null;
    }

    public void fetchGankData(int year, int month, int day) {
        iView.showProgressBar();
        subscription = HttpClient.getHttpRetrofitInstance().getDailyData(year, month, day)
                .map(new Func1<GankData, List<Gank>>() {
                    @Override
                    public List<Gank> call(GankData gankData) {
                        Log.d("1111","addAllResults = " + addAllResults(gankData.results));
                        return addAllResults(gankData.results);
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Gank>>() {
                    @Override
                    public void call(List<Gank> gankList) {
                        Log.d("1111","gankList");
                        iView.showGankList(gankList);
                        iView.hideProgressBar();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d("1111","throwable");
                        iView.hideProgressBar();
                        iView.showErrorView();
                    }
                });
    }

    private List<Gank> addAllResults(GankData.Result results) {
        List<Gank> mGankList = new ArrayList<>();
        if (results.androidList != null) mGankList.addAll(results.androidList);
        if (results.iOSList != null) mGankList.addAll(results.iOSList);
        if (results.前端List != null) mGankList.addAll(results.前端List);
        if (results.appList != null) mGankList.addAll(results.appList);
        if (results.拓展资源List != null) mGankList.addAll(results.拓展资源List);
        if (results.瞎推荐List != null) mGankList.addAll(results.瞎推荐List);
        if (results.休息视频List != null) mGankList.addAll(0, results.休息视频List);
        return mGankList;
    }



}
