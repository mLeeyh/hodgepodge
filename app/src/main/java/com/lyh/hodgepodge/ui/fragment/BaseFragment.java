package com.lyh.hodgepodge.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyh.hodgepodge.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * Created by lyh on 2016/12/23.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    protected T presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, view);
        initPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract int getLayoutResId();

    protected abstract void initPresenter();

}
