package com.lyh.hodgepodge.ui.view;

import java.util.List;

/**
 * Created by lyh on 2016/12/21.
 */

public interface BaisiView extends BaseView {
    void showProgressBar();
    void hideProgressBar();
    void showErrorView();
    void showNoMoreData();
}
