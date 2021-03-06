package com.shangyi.android.http.interceptor;

import com.shangyi.android.http.base.BaseConfig;
import com.shangyi.android.http.sign.HttpSignHeader;
import com.shangyi.android.utils.SPUtils;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <pre>
 *           .----.
 *        _.'__    `.
 *    .--(Q)(OK)---/$\
 *  .' @          /$$$\
 *  :         ,   $$$$$
 *   `-..__.-' _.-\$$/
 *         `;_:    `"'
 *       .'"""""`.
 *      /,  FLY  ,\
 *     //         \\
 *     `-._______.-'
 *     ___`. | .'___
 *    (______|______)
 * </pre>
 * 包    名 : com.fly.postop.code.http.interceptor
 * 作    者 : FLY
 * 创建时间 : 2018/9/21
 * 描述:  请求拦截器  统一添加请求头使用
 */
public class HeaderInterceptor implements Interceptor {
    private Map<String, Object> headerMaps = new TreeMap<>();

    public HeaderInterceptor(Map<String, Object> headerMaps) {
        this.headerMaps = headerMaps;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder request = chain.request().newBuilder();
        Request origRequest = chain.request();
        String uri=origRequest.url().uri().getPath();
        String queryString=origRequest.url().query();
        headerMaps.put(HttpSignHeader.X_CA_DEVICE_TOKEN, SPUtils.get(BaseConfig.USER_TOKEN, ""));
        headerMaps.put(HttpSignHeader.X_CA_TOKEN, SPUtils.get(BaseConfig.USER_TOKEN, ""));
        String sign = HttpSignHeader.sign(origRequest.method().toUpperCase(),uri,queryString,headerMaps);
        headerMaps.put(HttpSignHeader.X_CA_SIGNATURE,sign);
        if (headerMaps != null && headerMaps.size() > 0) {
            for (Map.Entry<String, Object> entry : headerMaps.entrySet()) {
                request.addHeader(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return chain.proceed(request.build());
    }

}
