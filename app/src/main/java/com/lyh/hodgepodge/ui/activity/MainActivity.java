package com.lyh.hodgepodge.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lyh.hodgepodge.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void initPresenter() {

    }
}
