package com.lyh.hodgepodge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.model.entity.Read.ShowapiResBodyBean.PagebeanBean.ContentlistBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lyh on 2017/1/17.
 */

public class ReadAdapter extends RecyclerView.Adapter<ReadAdapter.ReadHolder> {

    List<ContentlistBean> readList;
    Context context;


    public ReadAdapter(List<ContentlistBean> readList, Context context) {
        this.readList = readList;
        this.context = context;
    }

    @Override
    public ReadHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_read, parent, false);
        return new ReadHolder(view);
    }

    @Override
    public void onBindViewHolder(ReadHolder holder, int position) {
        ContentlistBean read = readList.get(position);
        holder.tvDesc.setTag(read);
        holder.tvDesc.setText(readList.get(position).getSummary());
    }

    @Override
    public int getItemCount() {
        return readList.size();
    }

    class ReadHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.iv_img)
        ImageView ivImg;
        public ReadHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
