package com.lyh.hodgepodge.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.adapter.BaisiAdapter;
import com.lyh.hodgepodge.model.entity.Baisi;
import com.lyh.hodgepodge.presenter.BaisiBaseFramgentPresenter;
import com.lyh.hodgepodge.ui.view.BaisiView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyh on 2016/12/23.
 */

public class BaisiFramgent extends BaseFramgent<BaisiBaseFramgentPresenter> implements BaisiView {

    private String type;
    private BaisiAdapter adapter;
    private List<Baisi> baisiList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static BaisiFramgent getInstance(Bundle tab) {
        BaisiFramgent baisiFramgent = new BaisiFramgent();
        baisiFramgent.setArguments(tab);
        return baisiFramgent;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baisi_base, container, false);
        initData();
        TextView textView = new TextView(getActivity());
        textView.setText("BaisiBaseFramgent " + type);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private void initData() {
        type = getArguments().getString("type");
        presenter = new BaisiBaseFramgentPresenter(getContext(), this);
        presenter.init();
        presenter.fetchBaisiData();
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
        baisiList = new ArrayList<>();
        adapter = new BaisiAdapter();
    }
}
