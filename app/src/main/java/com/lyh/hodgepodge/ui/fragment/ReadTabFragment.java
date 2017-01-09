package com.lyh.hodgepodge.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.model.entity.ReadType.ShowapiResBodyBean.TypeListBean;
import com.lyh.hodgepodge.presenter.ReadPresenter;
import com.lyh.hodgepodge.ui.view.ReadTypeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lyh on 2017/1/9.
 */

public class ReadTabFragment extends BaseFragment<ReadPresenter> implements ReadTypeView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.vp_baisi)
    ViewPager viewPager;

    private List<ReadFragment> mFragmentList;
    private List<TypeListBean> mList;
    private ReadTabAdapter mAdapter;
    private String[] mTitles;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baisi_tab, container, false);
        ButterKnife.bind(this, view);

        initData();


        return view;
    }

    private void initData() {

        presenter = new ReadPresenter(getContext(), this);
        presenter.init();
        mList = new ArrayList<>();
        presenter.fetchReadType();
        mFragmentList = new ArrayList<>();
        mFragmentList.clear();
        Log.d("1111", "mList.size()  = " + mList.size());
        for (int i = 0; i < mList.size(); i++) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab", i);
            mFragmentList.add(ReadFragment.getInstance(bundle));
        }
        mAdapter = new ReadTabAdapter(getChildFragmentManager());
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
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
    public void showListView(List<TypeListBean> readTypes) {
        mTitles = new String[readTypes.size()];
        List<String> title = new ArrayList<>();
        mList = readTypes;
//        readTypes.
        Log.d("1111", "readTypes = " + mList.toString());
    }

    @Override
    public void initView() {

    }

    public class ReadTabAdapter extends FragmentStatePagerAdapter {
        List<String> mTitle;

        public ReadTabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            for (TypeListBean list : mList) {
                String name = list.getName();
                mTitle.add(name);
            }
            return mTitle.get(position);
        }
    }
}
