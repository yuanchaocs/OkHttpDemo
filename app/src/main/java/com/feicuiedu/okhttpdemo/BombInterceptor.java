package com.feicuiedu.okhttpdemo;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 用来处理Bomb需要的统一头字段信息的拦截器
 *
 * 作者：yuanchao on 2016/8/15 0015 15:33
 * 邮箱：yuanchao@feicuiedu.com
 */
public class BombInterceptor implements Interceptor{

    // 链条,串
    @Override public Response intercept(Chain chain) throws IOException {
        // 拦截这次的Request
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        // 加入一些信息
        builder.addHeader("X-Bmob-Application-Id", "623aaef127882aed89b9faa348451da3");
        builder.addHeader("X-Bmob-REST-API-Key", "c00104962a9b67916e8cbcb9157255de");
        builder.addHeader("Content-Type", "application/json");
        return chain.proceed(builder.build());
    }
}
