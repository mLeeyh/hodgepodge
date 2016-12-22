package com.lyh.hodgepodge.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.model.entity.Gank;
import com.lyh.hodgepodge.model.entity.Meizi;
import com.lyh.hodgepodge.presenter.GankPresenter;
import com.lyh.hodgepodge.ui.view.IGankView;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends BaseActivity<GankPresenter> implements IGankView {

    private Meizi meizi;
    private List<Gank> list;
    private Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("1111","onCreate");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        presenter = new GankPresenter(this, this);
        presenter.init();
    }

    @Override
    public void showGankList(List<Gank> gankList) {

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
    public void initView() {
        meizi = (Meizi) getIntent().getSerializableExtra("meizi");
        calendar = Calendar.getInstance();
        presenter.fetchGankData(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
    }
}
