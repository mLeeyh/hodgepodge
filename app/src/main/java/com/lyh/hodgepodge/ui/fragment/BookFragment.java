package com.lyh.hodgepodge.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lyh on 2016/12/27.
 */

public class BookFragment extends BaseFragment{

    public static BookFragment getInstance(Bundle tab){
        BookFragment fragment = new BookFragment();
        fragment.setArguments(tab);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView view = new TextView(getActivity());
        int tab = getArguments().getInt("tab");
        view.setText("BookFragment " + tab);
        view.setTextSize(30);
        view.setGravity(Gravity.CENTER);
        return view;
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void initPresenter() {

    }
}
