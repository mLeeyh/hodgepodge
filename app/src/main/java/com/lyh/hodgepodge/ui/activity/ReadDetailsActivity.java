package com.lyh.hodgepodge.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lyh.hodgepodge.Config;
import com.lyh.hodgepodge.R;
import com.lyh.hodgepodge.adapter.ReadDetailsAdapter;
import com.lyh.hodgepodge.model.entity.ReadDetails;
import com.lyh.hodgepodge.presenter.ReadDetailsPresenter;
import com.lyh.hodgepodge.ui.view.IReadDetailsView;
import com.lyh.hodgepodge.utils.ShareElement;
import com.lyh.hodgepodge.utils.TipUtil;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

/**
 * Created by lyh on 2017/1/18.
 */

public class ReadDetailsActivity extends ToolBarActivity<ReadDetailsPresenter> implements IReadDetailsView {

    private List<ReadDetails.ShowapiResBodyBean> list;
    private String url;
    private ReadDetailsAdapter adapter;

    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.progressbar)
    SmoothProgressBar progressbar;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_special_read;
    }

    @Override
    protected void initPresenter() {
        presenter = new ReadDetailsPresenter(this, this);
        presenter.init();
    }

    @Override
    public void initView() {
        getIntentData();
        initReadDetailsView();
    }

    private void getIntentData() {
        url = getIntent().getStringExtra("url");
        Log.i("1111", "url = " + url);
        list = new ArrayList<>();
        adapter = new ReadDetailsAdapter(this, list);
        presenter.fetchReadDetailsData(url);
    }

    private void initReadDetailsView() {
        ivHead.setImageDrawable(ShareElement.shareDrawable);
        ViewCompat.setTransitionName(ivHead, Config.SPECIAL_READ_IMAGE);
    }

    @Override
    public void showReadDetails(String content) {
        Log.i("1111", content.toString());
        try {
            JSONTokener jsonParser = new JSONTokener(content);
            // 此时还未读取任何json文本，直接读取就是一个JSONObject对象。
            // 如果此时的读取位置在"name" : 了，那么nextValue就是"yuanzhifei89"（String）
            JSONObject person = (JSONObject) jsonParser.nextValue();
            // 接下来的就是JSON对象的操作了
            String title = person.getString("title");
            String neirong = person.getString("neirong");
            Log.i("1111","title = " + title);
            tvTitle.setText(title);
            tvContent.setText(Html.fromHtml(neirong));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showProgressBar() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showErrorView() {
        tvTitle.setText("获取数据失败了！！！");
    }


    @Override
    public void showNoMoreData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ShareElement.shareDrawable = null;
        list = null;
        presenter.release();
        presenter = null;
    }
}
