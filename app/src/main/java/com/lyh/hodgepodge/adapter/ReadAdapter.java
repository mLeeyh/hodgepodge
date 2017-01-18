package com.lyh.hodgepodge.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lyh.hodgepodge.Config;
import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.model.entity.Read.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.lyh.hodgepodge.ui.activity.SpecialReadActivity;
import com.lyh.hodgepodge.ui.widget.RatioImageView;
import com.lyh.hodgepodge.utils.ShareElement;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        holder.ivImg.setBackgroundColor(Color.argb(204, red, green, blue));
        if (read.getImg() != null) {
            Glide.with(context)
                    .load(read.getImg())
                    .crossFade()
                    .into(holder.ivImg);
        }
    }

    @Override
    public int getItemCount() {
        return readList.size();
    }

    class ReadHolder extends RecyclerView.ViewHolder {

        View card;

        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.iv_img)
        RatioImageView ivImg;
        @BindView(R.id.cardView)
        CardView cardView;
        @OnClick(R.id.cardView)
        public void onClick() {
            ShareElement.shareDrawable = ivImg.getDrawable();
            Intent intent = new Intent(context, SpecialReadActivity.class);
            intent.putExtra(Config.SPECIAL_READ, (Serializable) card.getTag());
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                    .makeSceneTransitionAnimation((Activity)context,ivImg,Config.SPECIAL_READ);
            ActivityCompat.startActivity((Activity) context, intent, optionsCompat.toBundle());
        }

        public ReadHolder(View itemView) {
            super(itemView);
            card = itemView;
            ButterKnife.bind(this, itemView);
            ivImg.setOriginalSize(300, 300);
        }
    }
}
