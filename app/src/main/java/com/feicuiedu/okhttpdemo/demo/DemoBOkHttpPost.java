package com.feicuiedu.okhttpdemo.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.feicuiedu.okhttpdemo.NetClient;
import com.feicuiedu.okhttpdemo.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DemoBOkHttpPost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_b_okhttp_post);
        OkHttpClient okHttpClient = NetClient.getInstance().getOkHttpClient();
        // 构建请求体(用户数据)
        User user = new User("test3", "123123");
        Gson gson = new Gson();
        RequestBody requestBody = RequestBody.create(null, gson.toJson(user));
        // 构建请求
        Request request = new Request.Builder()
                // 请求行
                .url("https://api.bmob.cn/1/users")
                // 请求头(可不加的,已在拦截器添加)
                .addHeader("X-Bmob-Application-Id", "623aaef127882aed89b9faa348451da3")
                .addHeader("X-Bmob-REST-API-Key", "c00104962a9b67916e8cbcb9157255de")
                .addHeader("Content-Type", "application/json")
                // 请求体
                .post(requestBody)
                .build();
        // 创建获取Call
        Call call = okHttpClient.newCall(request);
        // Call的执行
        call.enqueue(callback);
    }

    // 后台线程回调
    private Callback callback = new Callback() {
        @Override public void onFailure(Call call, IOException e) {

        }

        @Override public void onResponse(Call call, Response response) throws IOException {
            // response.isSuccessful()
            // response.code()
            // response.header("Date")
            // ResponseBody responseBody = response.body()
        }
    };
}