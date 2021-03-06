package com.shangyi.android.mycode.textHttp;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by allen on 2016/12/26.
 */

public interface ApiService {

    @GET("v2/book/1220562")
    Observable<String> getBookString();

    //以下是post请求的两种方式demo示例

    /**
     * post提交json数据 demo
     * @param map 键值对
     * @return
     */
//    @POST("xxx")
//    Observable<BaseData<T>> getData(@Body Map map);
//
//    /**
//     * post提交表单 demo
//     * @param name
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("xxx")
//    Observable<BaseData<T>> getData(@Field("name") String name);
//

}
