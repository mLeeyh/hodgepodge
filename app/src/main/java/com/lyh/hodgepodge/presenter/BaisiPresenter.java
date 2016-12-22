package com.lyh.hodgepodge.presenter;

import android.content.Context;
import android.util.Log;

import com.lyh.hodgepodge.http.HttpClient;
import com.lyh.hodgepodge.model.BaisiData;
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

public class BaisiPresenter extends BasePresenter<BaisiView> {


    public BaisiPresenter(Context context, BaisiView iView) {
        super(context, iView);
    }

    @Override
    public void release() {
        subscription.unsubscribe();
        subscription = null;
    }

    public void fetchBaisiData(String appid, String type, String title, String page, String sign) {
        subscription = HttpClient.getHttpRetrofitInstance()
                .getBaisiData(appid, type, title, page, sign)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaisiData>() {
                    @Override
                    public void call(BaisiData baisiData) {
//                        if (baisiData.results.toString() == null){
                        Log.d("1111","baisiData.results.size() == 0");
//                        }else {
                        Log.d("1111","baisiData = " + baisiData.toString());
                       // }
                    }
                });





    }
}
