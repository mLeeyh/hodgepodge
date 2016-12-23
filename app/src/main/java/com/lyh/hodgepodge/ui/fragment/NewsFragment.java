package com.lyh.hodgepodge.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lyh on 2016/12/23.
 */
public class NewsFragment extends BaseFramgent {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("NewsFragment");
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);

        return textView;
    }

    @Override
    protected void lazyLoad() {

    }
}