package com.lyh.hodgepodge.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lyh on 2017/1/9.
 */

public class ReadFragment extends Fragment{

    public static ReadFragment getInstance(Bundle tab){
        ReadFragment fragment = new ReadFragment();
        fragment.setArguments(tab);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView view = new TextView(getActivity());
        //int tab = getArguments().getInt("tab");
        view.setText("ReadFragment");
        view.setTextSize(30);
        view.setGravity(Gravity.CENTER);
        return view;
    }
}
