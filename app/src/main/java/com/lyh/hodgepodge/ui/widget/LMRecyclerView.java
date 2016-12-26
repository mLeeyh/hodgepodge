package com.lyh.hodgepodge.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by lyh on 2016/12/26.
 */

public class LMRecyclerView extends RecyclerView {

    private boolean isScrollingToBottom = true;
    private FloatingActionButton floatingActionButton;
    private LoadMoreListener listener;

    public LMRecyclerView(Context context) {
        super(context);
    }

    public LMRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LMRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void applyFloatingActionButton(FloatingActionButton floatingActionButton) {
        this.floatingActionButton = floatingActionButton;
    }

    public void setLoadMoreLister(LoadMoreListener loadMoreLister) {
        this.listener = loadMoreLister;
    }

    @Override
    public void onScrolled(int dx, int dy) {
        isScrollingToBottom = dy > 0;
        if (floatingActionButton != null) {
            if (isScrollingToBottom) {
                if (floatingActionButton.isShown())
                    floatingActionButton.hide();
            } else {
                if (!floatingActionButton.isShown())
                    floatingActionButton.show();
            }
        }
    }

    @Override
    public void onScrollStateChanged(int state) {

        LinearLayoutManager layoutManager = (LinearLayoutManager) getLayoutManager();
        if (state == RecyclerView.SCROLL_STATE_IDLE) {
            int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            int totalItemCount = layoutManager.getItemCount();
            if (lastVisibleItem == (totalItemCount - 1) && isScrollingToBottom) {
                if (listener != null)
                    listener.loadMore();
            }
        }
    }

    public interface LoadMoreListener {
        void loadMore();
    }
}
