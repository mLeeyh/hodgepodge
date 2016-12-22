package com.lyh.hodgepodge.http;

import com.lyh.hodgepodge.model.BaisiData;
import com.lyh.hodgepodge.model.FunnyData;
import com.lyh.hodgepodge.model.GanHuoData;
import com.lyh.hodgepodge.model.GankData;
import com.lyh.hodgepodge.model.MeiziData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lyh on 2016/12/21.
 */

public interface HttpRetrofit {
    // http://route.showapi.com/255-1?showapi_appid=29268&type=&title=&page=&showapi_sign=2bc6af3dbede4893b5e00ff7f006e7dc
    @GET("255-1")
    Observable<BaisiData> getBaisiData(@Query("showapi_appid") String appid, @Query("type") String type,
                                       @Query("title") String title, @Query("page") String page,
                                       @Query("showapi_sign") String sign);
    // http://gank.io/api/data/数据类型/请求个数/第几页
    @GET(value = "data/福利/" + "20" + "/{page}")
    Observable<MeiziData> getMeiziData(@Path("page") int page);
    @GET("data/休息视频/" + "20" + "/{page}")
    Observable<FunnyData> getFunnyData(@Path("page") int page);

    //请求某天干货数据
    @GET("day/{year}/{month}/{day}")
    Observable<GankData> getDailyData(
            @Path("year") int year,
            @Path("month") int month,
            @Path("day") int day);

    //请求不同类型干货（通用）
    @GET("data/{type}/"+"20"+"/{page}")
    Observable<GanHuoData> getGanHuoData(@Path("type") String type, @Path("page") int page);
}
