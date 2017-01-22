package com.lyh.hodgepodge.ui.view;

import com.lyh.hodgepodge.model.entity.History.ShowapiResBodyBean.ListBean;

import java.util.List;

/**
 * Created by lyh on 2017/1/22.
 */

public interface IHistoryView extends IBaseView {
    void showProgressBar();
    void hideProgressBar();
    void showErrorView();
    void showNoMoreData();
    void showListView(List<ListBean> readList);
}
