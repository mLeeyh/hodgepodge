package com.lyh.hodgepodge.ui.fragment;

import android.support.v4.app.Fragment;

import com.lyh.hodgepodge.presenter.BasePresenter;

/**
 * Created by lyh on 2016/12/23.
 */

public abstract class BaseFramgent<T extends BasePresenter>  extends Fragment{

    protected T presenter;

}
