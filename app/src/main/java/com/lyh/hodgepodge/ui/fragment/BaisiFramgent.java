package com.lyh.hodgepodge.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.adapter.BaisiAdapter;
import com.lyh.hodgepodge.model.entity.Baisi;
import com.lyh.hodgepodge.model.entity.Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.lyh.hodgepodge.presenter.BaisiBaseFramgentPresenter;
import com.lyh.hodgepodge.ui.view.BaisiView;
import com.lyh.hodgepodge.ui.widget.LMRecyclerView;
import com.lyh.hodgepodge.utils.TipUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lyh on 2016/12/23.
 */

public class BaisiFramgent extends BaseFragment<BaisiBaseFramgentPresenter> implements BaisiView,
        LMRecyclerView.LoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recycler_view)
    LMRecyclerView recyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private int page = 1;
    private String type;
    private BaisiAdapter adapter;
    private List<ContentlistBean> mList;

    private boolean isRefresh = true;
    private boolean canLoading = true;

    public static BaisiFramgent getInstance(Bundle tab) {
        BaisiFramgent baisiFramgent = new BaisiFramgent();
        baisiFramgent.setArguments(tab);
        return baisiFramgent;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baisi, container, false);
        ButterKnife.bind(this, view);
        initData();
        int tab = getArguments().getInt("tab");
        switch (tab) {
            case 0:
                type = "";
                return view;
            case 2:
                type = "10";
                return view;
            case 3:
                type = "29";
                return view;
            case 1:
            case 4:
            case 5:
            case 6:
                TextView textView = new TextView(getActivity());
                textView.setText("BaisiBaseFramgent " + tab);
                textView.setTextSize(30);
                textView.setGravity(Gravity.CENTER);
                return textView;
            default:
                return null;
        }
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void initPresenter() {

    }

    private void initData() {
        presenter = new BaisiBaseFramgentPresenter(getContext(), this);
        presenter.init();
        mList = new ArrayList<>();
        adapter = new BaisiAdapter(mList, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLoadMoreLister(this);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.grey);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                presenter.fetchBaisiData(page, type);
            }
        });
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
        canLoading = true;
        TipUtil.showTipWithAction(recyclerView, getString(R.string.load_failed), getString(R.string.retry), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.fetchBaisiData(page, type);
            }
        });
    }

    @Override
    public void showNoMoreData() {
        canLoading = false;
        TipUtil.showSnackTip(recyclerView, getString(R.string.no_more_data));
    }

    @Override
    public void showListView(List<ContentlistBean> baisiList) {
        canLoading = true;
        page++;
        if (isRefresh) {
            this.mList.clear();
            this.mList.addAll(baisiList);
            adapter.notifyDataSetChanged();
            isRefresh = false;
        } else {
            this.mList.addAll(baisiList);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void initView() {
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        page = 1;
        presenter.fetchBaisiData(page, type);
    }

    @Override
    public void loadMore() {
        if (canLoading) {
            presenter.fetchBaisiData(page, type);
            canLoading = false;
        }
    }
}
