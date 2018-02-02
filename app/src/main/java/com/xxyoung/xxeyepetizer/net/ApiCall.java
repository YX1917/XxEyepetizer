package com.xxyoung.xxeyepetizer.net;


import com.xxyoung.xxeyepetizer.bean.MyFollowBean;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yangxing on 2017/11/10.
 */

public interface ApiCall {
    /**
     * 获取id列表
     *
     * @return
     */
    @Headers("Cache-Control: public, max-age=3600")
    @GET("api/v4/tabs/follow")
    Observable<MyFollowBean> getFollow(@Query("start") String start, @Query("num") String num);


}
