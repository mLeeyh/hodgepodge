package com.lyh.hodgepodge.presenter;

import android.content.Context;

import com.lyh.hodgepodge.ui.view.IReadView;

/**
 * Created by lyh on 2017/1/18.
 */

public class ReadDetailsPresenter extends BasePresenter<IReadView> {
    public ReadDetailsPresenter(Context context, IReadView iView) {
        super(context, iView);
    }

    @Override
    public void release() {
        subscription.unsubscribe();
        subscription = null;
    }



}
