package com.lyh.hodgepodge.ui.view;

import com.lyh.hodgepodge.model.entity.ReadDetails;

import java.util.List;

/**
 * Created by lyh on 2017/1/19.
 */

public interface IReadDetailsView extends IBaseView{
    void showProgressBar();
    void hideProgressBar();
    void showErrorView();
    void showNoMoreData();
    void showReadDetails(String content);
}
