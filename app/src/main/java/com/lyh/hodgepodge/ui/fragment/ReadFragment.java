package com.lyh.hodgepodge.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.adapter.ReadAdapter;
import com.lyh.hodgepodge.model.entity.Read.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.lyh.hodgepodge.presenter.ReadPresenter;
import com.lyh.hodgepodge.ui.view.IReadView;
import com.lyh.hodgepodge.ui.widget.LMRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lyh on 2017/1/9.
 */

public class ReadFragment extends BaseFragment<ReadPresenter> implements IReadView,
        LMRecyclerView.LoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    private static final String TYPE = "type";
    private String id;
    private int page = 1;
    private boolean isRefresh = true;
    private boolean canLoading = true;

    private List<ContentlistBean> readList;
    private ReadAdapter adapter;
    @BindView(R.id.recycler_view)
    LMRecyclerView recyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    public static ReadFragment getInstance(Bundle id) {
        ReadFragment fragment = new ReadFragment();
        fragment.setArguments(id);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString("id");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read,container,false);
        ButterKnife.bind(this, view);
        initData();
        id = getArguments().getString("id");
        switch (id){
            case "0":
                break;
            default:
                break;
        }
        TextView textview = new TextView(getActivity());
        textview.setText(" ReadFragment " + id);
        textview.setTextSize(30);
        textview.setGravity(Gravity.CENTER);
        return view;
    }

    private void initData() {
        presenter = new ReadPresenter(getContext(), this);
        presenter.init();
        readList = new ArrayList<>();
        adapter = new ReadAdapter(readList, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setLoadMoreLister(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.grey);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                Log.i("1111","id = " + id);
                presenter.fetchReadData(id, page);
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_read;
    }

    @Override
    protected void initPresenter() {
//        presenter = new ReadPresenter(getContext(), this);
//        presenter.init();
//        readList = new ArrayList<>();
//        adapter = new ReadAdapter(readList, getContext());
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLoadMoreLister(this);
//        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.grey);
//        swipeRefreshLayout.setOnRefreshListener(this);
//        swipeRefreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                swipeRefreshLayout.setRefreshing(true);
//                presenter.fetchReadData(id, page);
//            }
//        });
    }

    @Override
    public void showProgressBar() {
        if (!swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void hideProgressBar() {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    public void showListView(List<ContentlistBean> list) {
        canLoading = true;
        page++;
        if (isRefresh) {
            this.readList.clear();
            this.readList.addAll(list);
            adapter.notifyDataSetChanged();
            isRefresh = false;
        } else {
            this.readList.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void initView() {
//        readList = new ArrayList<>();
//        adapter = new ReadAdapter(readList, getContext());
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLoadMoreLister(this);
//        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.grey);
//        swipeRefreshLayout.setOnRefreshListener(this);
//        swipeRefreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                swipeRefreshLayout.setRefreshing(true);
//                presenter.fetchReadData(id, page);
//            }
//        });
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        page = 1;
        presenter.fetchReadData(id, page);
    }

    @Override
    public void loadMore() {
        if (canLoading) {
            presenter.fetchReadData(id, page);
            canLoading = false;
        }
    }
}
