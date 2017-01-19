package com.lyh.hodgepodge.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.ui.fragment.BaisiTabFragment;
import com.lyh.hodgepodge.ui.fragment.BookTabFragment;
import com.lyh.hodgepodge.ui.fragment.FourFragment;
import com.lyh.hodgepodge.ui.fragment.ReadTabFragment;
import com.lyh.hodgepodge.ui.view.IBaseView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements IBaseView {

    @BindView(R.id.id_content)
    FrameLayout idContent;
    @BindView(R.id.tab_book)
    RadioButton tabBook;
    @BindView(R.id.tab_joyful)
    RadioButton tabJoyful;
    @BindView(R.id.tab_found)
    RadioButton tabFound;
    @BindView(R.id.tab_about)
    RadioButton tabAbout;

    @BindViews({R.id.tab_book, R.id.tab_joyful, R.id.tab_found, R.id.tab_about})
    List<RadioButton> mTabs;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setSelect(1);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void initView() {
        setSelect(0);
    }

    @OnClick({R.id.tab_book, R.id.tab_joyful, R.id.tab_found, R.id.tab_about})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_book:
                setSelect(0);
                break;
            case R.id.tab_joyful:
                setSelect(1);
                break;
            case R.id.tab_found:
                setSelect(2);
                break;
            case R.id.tab_about:
                setSelect(3);
                break;
        }
    }

    public void setSelect(int select) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        resetImgs();
        switch (select) {
            case 0:
                if (mTab01 == null) {
                    mTab01 = new BookTabFragment();
                    transaction.add(R.id.id_content, mTab01);
                } else {
                    transaction.show(mTab01);
                }
                mTabs.get(0).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_comprehensive_pressed_icon, 0, 0);
                break;
            case 1:
                if (mTab02 == null) {
                    mTab02 = new BaisiTabFragment();
                    transaction.add(R.id.id_content, mTab02);
                } else {
                    transaction.show(mTab02);

                }
                mTabs.get(1).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_move_pressed_icon, 0, 0);
                break;
            case 2:
                if (mTab03 == null) {
                    mTab03 = new ReadTabFragment();
                    transaction.add(R.id.id_content, mTab03);
                } else {
                    transaction.show(mTab03);
                }
                mTabs.get(2).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_found_pressed_icon, 0, 0);
                break;
            case 3:
                if (mTab04 == null) {
                    mTab04 = new FourFragment();
                    transaction.add(R.id.id_content, mTab04);
                } else {
                    transaction.show(mTab04);
                }
                mTabs.get(3).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_me_pressed_icon, 0, 0);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mTab01 != null) {
            transaction.hide(mTab01);
        }
        if (mTab02 != null) {
            transaction.hide(mTab02);
        }
        if (mTab03 != null) {
            transaction.hide(mTab03);
        }
        if (mTab04 != null) {
            transaction.hide(mTab04);
        }
    }

    /**
     * 切换图片至暗色
     */
    private void resetImgs() {
        mTabs.get(0).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_comprehensive_icon, 0, 0);
        mTabs.get(1).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_move_icon, 0, 0);
        mTabs.get(2).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_found_icon, 0, 0);
        mTabs.get(3).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_me_icon, 0, 0);
    }
}
