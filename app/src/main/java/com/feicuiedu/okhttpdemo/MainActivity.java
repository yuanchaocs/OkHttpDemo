package com.feicuiedu.okhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


/**
 * OkHttp
 * 1. 了解OkHttp,掌握其的基本运用
 * 2. 掌握Call模型的运用
 *
 * 基本使用
 * Call
 * 拦截器
 */
public class MainActivity extends AppCompatActivity {

    // OkHttp是square出的一个Http通讯库,用于Java和android应用
    // Android6.0后,将httpClent从SDK中移除,全面转向使用OkHttp
    // 知名的第三方框架都使用OkHttp做为网络连接技术
    // OkHttp是一个Java库

    // OKHTTP使用
    // 1. 库的依赖
    // 2. 运用(初始化，构建Call模型, 执行)
    // 请求 -- 响应
    // 重写,重定向，重试等操作，使得你一个简单请求,会出现多个请求和响应
    //
    // 重写: 保证正确性和传输效率,OkHttp会在发送你的请求之前重写它
    //          请求中缺失的头信息(host)
    // 重定向: OkHttp能跟随新的URL，获取到最终的响应。
    // 重试:
    // 就因为以上的特性
    // 使得你一个简单请求,会出现多个请求和响应
    // 但是这一次操作,不管多少请求响应，都叫一个Call
    //
    //
    // Call可以在任意线程取消Call
    // Call有两种方式来执行：
    //       直接在当前线程执行
    //       其它线程执行
    //
    // 可添加拦截器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 日志拦截器(对请求和响应消息信息进行了拦截输出)
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        // 日志拦截级别
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // #1111 构建OkHttpClient
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();
        // #222 构建Call
        Call call = okHttpClient.newCall(request);
        // #333 Call有两种方式来执行：
        // Response response = call.execute();
        call.enqueue(callback);
    }

    // 网络连接回调，在后台线程执行(OkHttp是一个java库)
    private Callback callback = new Callback() {
        @Override public void onFailure(Call call, IOException e) {
            //Toast.makeText(getApplicationContext(),"failure:"+e.getMessage(),Toast.LENGTH_LONG).show();
        }

        @Override public void onResponse(Call call, Response response) throws IOException {
//            if (response == null) {
//                Toast.makeText(getApplicationContext(),"未知错误!",Toast.LENGTH_LONG).show();
//                return;
//            }
//            // 响应码
//            if(response.isSuccessful()){
//                // 响应头
//                // response.header("");
//                // 响应体
//                ResponseBody body = response.body();
//                Log.d("TAG", body.string());
//                return;
//            }
//            Toast.makeText(getApplicationContext(),"code:"+response.code(),Toast.LENGTH_LONG).show();
        }
    };
}
