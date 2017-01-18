package com.lyh.hodgepodge.ui.view;

import com.lyh.hodgepodge.model.entity.Baisi;
import com.lyh.hodgepodge.model.entity.Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean;

import java.util.List;

/**
 * Created by lyh on 2016/12/21.
 */

public interface BaisiView extends IBaseView {
    void showProgressBar();
    void hideProgressBar();
    void showErrorView();
    void showNoMoreData();
    void showListView(List<ContentlistBean> baisiList);
}
