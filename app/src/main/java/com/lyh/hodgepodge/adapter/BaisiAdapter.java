package com.lyh.hodgepodge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lyh.hodgepodge.model.entity.Baisi;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by lyh on 2016/12/24.
 */

public class BaisiAdapter extends RecyclerView.Adapter<BaisiAdapter.BaisiHolder> {

    List<Baisi> baisiList;
    Context context;

    public BaisiAdapter(List<Baisi> baisiList, Context context) {
        this.baisiList = baisiList;
        this.context = context;
    }

    @Override
    public BaisiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaisiHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class BaisiHolder extends RecyclerView.ViewHolder {

        public BaisiHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
