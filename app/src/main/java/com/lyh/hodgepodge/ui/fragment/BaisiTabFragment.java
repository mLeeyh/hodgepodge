package com.lyh.hodgepodge.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyh.hodgepodge.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lyh on 2016/12/23.
 */
public class BaisiTabFragment extends Fragment {

    @BindView(R.id.tab_layout)
    TabLayout tabSelector;
    @BindView(R.id.vp_baisi)
    ViewPager mViewPager;
    private String[] mTitles = new String[]{"推荐", "视频", "图片", "段子","动态图","笑话","图片笑话"};
    private String[] type = new String[]{"all", "video", "picture", "duanzi","gif","joke","picture"};
    private List<BaisiFramgent> mFragmentList;
    private BaisiPagerAdapter mAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("1111", "BaisiFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baisi_tab, null);
        ButterKnife.bind(this,view);
        initData();
        initView();
        return view;
    }

    private void initData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.clear();
        for(int i = 0;i<mTitles.length;i++){
            Bundle bundle = new Bundle();
            bundle.putString("type",type[i]);
            mFragmentList.add(BaisiFramgent.getInstance(bundle));
        }
    }

    private void initView() {
        mAdapter = new BaisiPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        tabSelector.setupWithViewPager(mViewPager);
        tabSelector.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private class BaisiPagerAdapter extends FragmentStatePagerAdapter {

        public BaisiPagerAdapter(FragmentManager fm) {
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
