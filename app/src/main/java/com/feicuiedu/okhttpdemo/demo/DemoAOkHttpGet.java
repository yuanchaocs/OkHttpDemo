package com.feicuiedu.okhttpdemo.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.feicuiedu.okhttpdemo.NetClient;
import com.feicuiedu.okhttpdemo.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DemoAOkHttpGet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_a_okhttp_get);

        OkHttpClient okHttpClient = NetClient.getInstance().getOkHttpClient();
        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();
        // 构建Call
        Call call = okHttpClient.newCall(request);
        // Call有两种方式来执行：
        // Response response = call.execute();
        call.enqueue(callback);
    }

    // 网络连接回调，在后台线程执行(OkHttp是一个java库)
    private Callback callback = new Callback() {
        @Override public void onFailure(Call call, IOException e) {
        }

        @Override public void onResponse(Call call, Response response) throws IOException {
            // response.isSuccessful() 响应码
            // response.header() 响应头
            // ResponseBody body = response.body() 响应体
        }
    };
}
