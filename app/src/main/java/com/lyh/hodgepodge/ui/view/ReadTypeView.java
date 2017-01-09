package com.lyh.hodgepodge.ui.view;

import com.lyh.hodgepodge.model.entity.ReadType;

import java.util.List;

/**
 * Created by lyh on 2017/1/9.
 */

public interface ReadTypeView extends IBaseView {
    void showProgressBar();
    void hideProgressBar();
    void showErrorView();
    void showListView(List<ReadType.ShowapiResBodyBean.TypeListBean> readTypes);
}
