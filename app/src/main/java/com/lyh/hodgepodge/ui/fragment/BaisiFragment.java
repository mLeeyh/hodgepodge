package com.lyh.hodgepodge.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyh.hodgepodge.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lyh on 2016/12/23.
 */
public class BaisiFragment extends Fragment {

    @BindView(R.id.tab_selector)
    TabLayout tabSelector;
    @BindView(R.id.vp_baisi)
    ViewPager mViewPager;
    private String[] mTitles = new String[]{"推荐", "视频", "图片", "段子"};
    private List<BaisiBaseFramgent> mFragmentList;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("1111", "BaisiFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baisi, null);
        ButterKnife.bind(view);
        initData();
        initView();

        TextView textView = new TextView(getActivity());
        textView.setText("BaisiFragment");
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        Log.d("1111", "BaisiFragment onCreateView");
        return textView;
    }

    private void initData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.clear();
        for(int i = 0;i<mTitles.length;i++){
            Bundle bundle = new Bundle();
            bundle.putInt("type",i);
        }
    }

    private void initView() {
    }
}
