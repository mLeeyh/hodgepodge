package com.lyh.hodgepodge.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lyh on 2016/12/21.
 */

public class HttpClient {
    public static final String HOST = "http://route.showapi.com/";
    public static final String HOST1 = "http://gank.io/api/";
    private static HttpRetrofit httpRetrofit ;
    private  static Retrofit retrofit;
    private HttpClient(){}

    static {
        Gson  gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static HttpRetrofit getHttpRetrofitInstance(){
        if(httpRetrofit == null){
            synchronized (HttpClient.class){
                if(httpRetrofit == null){
                    httpRetrofit = retrofit.create(HttpRetrofit.class);
                }
            }
        }
        return httpRetrofit;
    }
}
