package com.lyh.hodgepodge.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.adapter.ReadAdapter;
import com.lyh.hodgepodge.model.entity.Read.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.lyh.hodgepodge.presenter.ReadPresenter;
import com.lyh.hodgepodge.ui.view.IReadView;
import com.lyh.hodgepodge.ui.widget.LMRecyclerView;
import com.lyh.hodgepodge.utils.TipUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by lyh on 2017/1/9.
 */

public class ReadFragment extends BaseFragment<ReadPresenter> implements IReadView,
        LMRecyclerView.LoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

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

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_read;
    }

    @Override
    protected void initPresenter() {
        presenter = new ReadPresenter(getContext(), this);
        presenter.init();
    }

    @Override
    public void initView() {
        readList = new ArrayList<>();
        adapter = new ReadAdapter(readList, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLoadMoreLister(this);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.grey);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                presenter.fetchReadData(id, page);
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
                presenter.fetchReadData(id, page);
            }
        });
    }

    @Override
    public void showNoMoreData() {
        canLoading = false;
        TipUtil.showSnackTip(recyclerView, getString(R.string.no_more_data));
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
