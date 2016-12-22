package com.lyh.hodgepodge.ui.view;


import com.lyh.hodgepodge.model.entity.Gank;

import java.util.List;

/**
 * 干货view
 * Created by xybcoder on 2016/3/1.
 */
public interface IGankView extends BaseView {
    void showGankList(List<Gank> gankList);
    void showProgressBar();
    void hideProgressBar();
    void showErrorView();
}
