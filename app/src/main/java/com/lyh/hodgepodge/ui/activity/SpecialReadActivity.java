package com.lyh.hodgepodge.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lyh.hodgepodge.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lyh on 2017/1/18.
 */

public class SpecialReadActivity extends AppCompatActivity {
    @BindView(R.id.body)
    TextView body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_read);
        ButterKnife.bind(this);
//        body.setText("");
    }
}
