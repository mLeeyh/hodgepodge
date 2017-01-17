package com.lyh.hodgepodge.ui.view;

import com.lyh.hodgepodge.model.entity.Read.ShowapiResBodyBean.PagebeanBean.ContentlistBean;

import java.util.List;

/**
 * Created by lyh on 2017/1/17.
 */

public interface IReadView extends IBaseView {
    void showProgressBar();
    void hideProgressBar();
    void showErrorView();
    void showNoMoreData();
    void showListView(List<ContentlistBean> readList);
}
