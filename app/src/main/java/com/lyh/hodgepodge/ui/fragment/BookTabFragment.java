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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyh.hodgepodge.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lyh on 2016/12/27.
 */

public class BookTabFragment extends Fragment {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_book)
    ViewPager vpBook;
    private String[] mTitles = new String[]{"知乎日报", "果壳精选", "豆瓣一刻"};
    private List<BookFragment> mFragmentList;
    private BookTabAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_tab, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.clear();
        for(int i = 0;i<mTitles.length;i++){
            Bundle bundle = new Bundle();
            bundle.putInt("tab",i);
            mFragmentList.add(BookFragment.getInstance(bundle));
        }
        mAdapter = new BookTabAdapter(getChildFragmentManager());
        vpBook.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(vpBook);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private class BookTabAdapter extends FragmentStatePagerAdapter{

        public BookTabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
