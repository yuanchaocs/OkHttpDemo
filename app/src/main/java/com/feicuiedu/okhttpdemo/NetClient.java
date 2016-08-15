package com.feicuiedu.okhttpdemo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 作者：yuanchao on 2016/8/15 0015 11:59
 * 邮箱：yuanchao@feicuiedu.com
 */
public class NetClient {
    private static NetClient sInstance;

    public static synchronized NetClient getInstance() {
        if (sInstance == null) {
            sInstance = new NetClient();
        }
        return sInstance;
    }

    private OkHttpClient okHttpClient;

    private NetClient() {

        // 日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor) // 打印日志的拦截器
                .build();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
