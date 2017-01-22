package com.lyh.hodgepodge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.model.entity.History.ShowapiResBodyBean.ListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lyh on 2017/1/22.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {

    List<ListBean> list;
    Context context;


    public HistoryAdapter(List<ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public HistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryHolder holder, int position) {
        ListBean mList = list.get(position);
        holder.title.setTag(mList);
        holder.title.setText(mList.getTitle());
        holder.time.setText(mList.getYear() + "-" + mList.getMonth() + "-" + mList.getDay());

    }

    @Override
    public int getItemCount() {
        Log.i("1111"," getItemCount() = " +  list.size());
        return list.size();
    }

    class HistoryHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.time)
        TextView time;

        public HistoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
