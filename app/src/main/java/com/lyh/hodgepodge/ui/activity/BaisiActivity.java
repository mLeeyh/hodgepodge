package com.lyh.hodgepodge.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.presenter.BaisiPresenter;
import com.lyh.hodgepodge.ui.view.BaisiView;

public class BaisiActivity extends BaseActivity<BaisiPresenter> implements BaisiView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        presenter = new BaisiPresenter(this,this);
        presenter.init();
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
        getIntentData();
    }

    private void getIntentData() {
        Log.d("1111","getIntentData()");
        presenter.fetchBaisiData("29268",null,null,null,"2bc6af3dbede4893b5e00ff7f006e7dc");
    }
}
