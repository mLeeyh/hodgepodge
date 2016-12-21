package com.lyh.hodgepodge.ui.activity;

import android.os.Bundle;

import com.lyh.hodgepodge.presenter.BaisiPresenter;
import com.lyh.hodgepodge.ui.view.BaisiView;

public class BaisiActivity extends BaseActivity<BaisiPresenter> implements BaisiView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    public void initView() {

    }
}
