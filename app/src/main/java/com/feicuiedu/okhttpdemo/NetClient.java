package com.feicuiedu.okhttpdemo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    private Retrofit retrofit;
    private BombApi bombApi;

    private NetClient() {

        // 日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new BombInterceptor()) // 统一处理Bomb的必要头字段拦截器
                .addInterceptor(httpLoggingInterceptor) // 打印日志的拦截器
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.bmob.cn")
                // Gson转换器
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        bombApi = retrofit.create(BombApi.class);
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public BombApi getBombApi() {
        return bombApi;
    }
}
