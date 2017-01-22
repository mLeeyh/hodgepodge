package com.lyh.hodgepodge.http;

import com.lyh.hodgepodge.model.entity.Baisi;
import com.lyh.hodgepodge.model.entity.History;
import com.lyh.hodgepodge.model.entity.Read;
import com.lyh.hodgepodge.model.entity.ReadDetails;
import com.lyh.hodgepodge.model.entity.ReadType;

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
    Observable<Baisi> getBaisiData(@Query("page") int page,
                                   @Query("showapi_appid") String appid,
                                   @Query("showapi_timestamp") String showapi_timestamp,
                                   @Query("title") String title,
                                   @Query("type") String type,
                                   @Query("showapi_sign") String sign);

    // https://route.showapi.com/990-1?showapi_appid=25788&showapi_timestamp=20170109112724&showapi_sign=e966e108fe2e7e6902507a487900d7bf
    @GET("990-1")
    Observable<ReadType> getReadType(@Query("showapi_appid") String appid,
                                     @Query("showapi_timestamp") String timestamp,
                                     @Query("showapi_sign") String sign);

    //https://route.showapi.com/990-2?id=1&page=1&showapi_appid=25788&showapi_timestamp=20170117142354&showapi_sign=85c11ad78b79f8498fc015201a12741e
    @GET("990-2")
    Observable<Read> getReadData(@Query("id") String id,
                                 @Query("page") int page,
                                 @Query("showapi_appid") String appid,
                                 @Query("showapi_timestamp") String timestamp,
                                 @Query("showapi_sign") String sign);

    //https://route.showapi.com/644-1?showapi_appid=25788&showapi_timestamp=20170118162152&url=http://www.de99.cn/news/1/13461.html&showapi_sign=1c030a3b5fdb52f480b2c8c9d3a27e73
    @GET("644-1")
    Observable<ReadDetails> getReadDetails(@Query("showapi_appid") String appid,
                                           @Query("showapi_timestamp") String timestamp,
                                           @Query("url") String url,
                                           @Query("showapi_sign") String sign);

    //https://route.showapi.com/119-42?date=0706&showapi_appid=25788&showapi_timestamp=20170122085047&showapi_sign=fc645c6fdaf6bb1338ee2252fa94a733
    @GET("119-42")
    Observable<History> getHistoryData(@Query("date")String date,
                                       @Query("showapi_appid") String appid,
                                       @Query("showapi_timestamp") String timestamp,
                                       @Query("showapi_sign") String sign);
}
