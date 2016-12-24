package com.lyh.hodgepodge.ui.activity;

import android.os.Bundle;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.ui.view.BaisiView;

public class BaisiActivity extends BaseActivity implements BaisiView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }



    @Override
    public void initView() {}


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
}
