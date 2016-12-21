package com.lyh.hodgepodge.http;

import com.lyh.hodgepodge.Config;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lyh on 2016/12/21.
 */

public interface HttpRetrofit {
    // http://gank.io/api/data/数据类型/请求个数/第几页
    @GET(value = "255-1?" + Config.APPID + "/{page}")
    Observable<MeiziData> getMeiziData(@Path("page") int page);

}
