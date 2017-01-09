package com.lyh.hodgepodge.adapter;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.model.entity.Baisi;
import com.lyh.hodgepodge.ui.widget.RatioImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.Url;

/**
 * Created by lyh on 2016/12/24.
 */

public class BaisiAdapter extends RecyclerView.Adapter<BaisiAdapter.BaisiHolder> {

    List<Baisi.ShowapiResBodyBean.PagebeanBean.ContentlistBean> mList;
    Context context;
    int lastPosition = 0;



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
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        holder.ivPicture.setBackgroundColor(Color.argb(204, red, green, blue));
        if (baisi.getImage0() != null) {
            Glide.with(context).load(baisi.getImage0())
                    .error(R.mipmap.ic_launcher)
                    .crossFade().into(holder.ivPicture);

        }else if (baisi.getVideo_uri() !=null){
            Uri parse = Uri.parse(baisi.getVideo_uri());
            holder.videoView.setVideoPath(parse.toString());
            holder.videoView.start();
            holder.videoView.requestFocus();

        }
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
        @BindView(R.id.videoView)
        VideoView videoView;


        public BaisiHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            ivPicture.setOriginalSize(300,150);
        }
    }


}
