package com.lyh.hodgepodge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.model.entity.Baisi;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lyh on 2016/12/24.
 */

public class BaisiAdapter extends RecyclerView.Adapter<BaisiAdapter.BaisiHolder> {

    List<Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean> mList;
    Context context;


    public BaisiAdapter(List<Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list, Context context) {
        this.mList = list;
        this.context = context;
    }

    @Override
    public BaisiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_baisi, parent, false);
        return new BaisiHolder(view);
    }

    @Override
    public void onBindViewHolder(BaisiHolder holder, int position) {
        Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean baisi = mList.get(position);
        holder.tvDescTitle.setTag(baisi);
        holder.tvDescTitle.setText(mList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class BaisiHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_desc_title)
        TextView tvDescTitle;
        @BindView(R.id.iv_picture)
        ImageView ivPicture;

        public BaisiHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
