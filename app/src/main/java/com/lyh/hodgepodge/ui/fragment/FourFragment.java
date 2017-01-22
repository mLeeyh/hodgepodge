package com.lyh.hodgepodge.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.adapter.HistoryAdapter;
import com.lyh.hodgepodge.model.entity.History;
import com.lyh.hodgepodge.model.entity.History.ShowapiResBodyBean.ListBean;
import com.lyh.hodgepodge.presenter.HistoryPresenter;
import com.lyh.hodgepodge.ui.view.IHistoryView;
import com.lyh.hodgepodge.ui.widget.LMRecyclerView;
import com.lyh.hodgepodge.utils.TipUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by lyh on 2016/12/23.
 */
public class FourFragment extends BaseFragment<HistoryPresenter> implements IHistoryView,
        LMRecyclerView.LoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    private List<History.ShowapiResBodyBean.ListBean> mList;
    private HistoryAdapter adapter;

    private boolean isRefresh = true;
    private boolean canLoading = true;

    @BindView(R.id.et_date)
    EditText etDate;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.recycler_view)
    LMRecyclerView recyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_customer;
    }

    @Override
    protected void initPresenter() {
        presenter = new HistoryPresenter(getContext(), this);
        presenter.init();
    }

    @Override
    public void initView() {
        mList = new ArrayList<>();
        adapter = new HistoryAdapter(mList, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.grey);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                presenter.fetchHistoryData(etDate.getText().toString());
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.clear();
                presenter.fetchHistoryData(etDate.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showListView(List<ListBean> list) {
        mList.clear();
        mList.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {

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
        canLoading = false;
        TipUtil.showSnackTip(recyclerView, getString(R.string.no_more_data));
    }


    @Override
    public void loadMore() {

    }
}
