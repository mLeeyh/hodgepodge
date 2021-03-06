package com.lyh.hodgepodge.presenter;

import android.content.Context;

import com.lyh.hodgepodge.ui.view.IBaseView;

import rx.Subscription;


/**
 * Created by lyh on 2016/12/21.
 */

public abstract class BasePresenter<T extends IBaseView> {
    protected Subscription subscription;
    protected Context context;
    protected T iView;

    public BasePresenter(Context context, T iView) {
        this.context = context;
        this.iView = iView;
    }

    public void init(){
        iView.initView();
    }

    public abstract void release();
}
