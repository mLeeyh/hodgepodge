package com.lyh.hodgepodge.ui.activity;

import android.os.Bundle;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.model.entity.Baisi;
import com.lyh.hodgepodge.ui.view.BaisiView;

import java.util.List;

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

    @Override
    public void showListView(List<Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean> baisiList) {

    }
}
