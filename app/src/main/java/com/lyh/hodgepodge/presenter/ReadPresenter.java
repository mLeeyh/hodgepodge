package com.lyh.hodgepodge.presenter;

import android.content.Context;
import android.util.Log;

import com.lyh.hodgepodge.http.HttpClient;
import com.lyh.hodgepodge.http.HttpRetrofit;
import com.lyh.hodgepodge.model.entity.ReadType;
import com.lyh.hodgepodge.model.entity.ReadType.ShowapiResBodyBean.TypeListBean;
import com.lyh.hodgepodge.ui.view.IBaseView;
import com.lyh.hodgepodge.ui.view.ReadTypeView;

import java.util.List;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lyh on 2017/1/9.
 */

public class ReadPresenter extends BasePresenter<ReadTypeView>{


    public ReadPresenter(Context context, ReadTypeView iView) {
        super(context, iView);
    }

    @Override
    public void release() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void fetchReadType(){
        subscription = HttpClient.getHttpRetrofitInstance().getReadType("29268","","E947C5159E9C674AAFAF9E77F654E7C7")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<ReadType, List<TypeListBean>>() {

                    @Override
                    public List<TypeListBean> call(ReadType readType) {
                        return readType.getShowapi_res_body().getTypeList();
                    }
                })
                .subscribe(new Action1<List<TypeListBean>>() {
                    @Override
                    public void call(List<TypeListBean> typeListBeen) {
                        iView.hideProgressBar();
                        if (typeListBeen.size() == 0) {
                            Log.i("1111", "list = 0 ");
                            //iView.showNoMoreData();
                        } else {
                            Log.i("1111", "list1 = " + typeListBeen.toString());
                            iView.showListView(typeListBeen);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                    }
                });
    }
}
