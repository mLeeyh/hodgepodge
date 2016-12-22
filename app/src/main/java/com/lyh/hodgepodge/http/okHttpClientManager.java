package com.lyh.hodgepodge.http;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by lyh on 2016/12/22.
 */

public class OkHttpClientManager {
    private static OkHttpClientManager mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mDelivery;
    private Gson mGson;

    private OkHttpClientManager(){
        mOkHttpClient = new OkHttpClient();
        mDelivery = new Handler(Looper.getMainLooper());
        mGson = new Gson();
    }

    public static OkHttpClientManager getInstance()
    {
        if (mInstance == null)
        {
            synchronized (OkHttpClientManager.class)
            {
                if (mInstance == null)
                {
                    mInstance = new OkHttpClientManager();
                }
            }
        }
        return mInstance;
    }
    //创建okHttpClient对象
    //创建一个Request
    final Request request = new Request.Builder()
            .url("https://github.com/hongyangAndroid")
            .build();
    //new call
    Call call = mOkHttpClient.newCall(request);
//请求加入调度


}
