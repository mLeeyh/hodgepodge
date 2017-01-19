package com.lyh.hodgepodge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.model.entity.ReadDetails;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lyh on 2017/1/19.
 */

public class ReadDetailsAdapter extends RecyclerView.Adapter<ReadDetailsAdapter.ReadDetailsHolder> {


    private Context context;
    private List<ReadDetails.ShowapiResBodyBean> list;

    public ReadDetailsAdapter(Context context, List<ReadDetails.ShowapiResBodyBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ReadDetailsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_read_details, parent, false);
        return new ReadDetailsHolder(view);
    }

    @Override
    public void onBindViewHolder(ReadDetailsHolder holder, int position) {
        ReadDetails.ShowapiResBodyBean content = list.get(position);
        holder.title.setTag(content);
        holder.title.setText(list.get(position).getTitle());
        holder.neirong.setText(list.get(position).getNeirong());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ReadDetailsHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.neirong)
        TextView neirong;

        public ReadDetailsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
