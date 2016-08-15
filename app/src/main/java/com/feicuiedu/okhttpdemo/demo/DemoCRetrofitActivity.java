package com.feicuiedu.okhttpdemo.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.feicuiedu.okhttpdemo.BombApi;
import com.feicuiedu.okhttpdemo.NetClient;
import com.feicuiedu.okhttpdemo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DemoCRetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_c_retrofit);

        BombApi bombApi = NetClient.getInstance().getBombApi();
        User user = new User("test110","123123");
        // 执行注册接口(传入请求体user, 响应结束是UserResult)
        Call<UserResult> call = bombApi.register(user);
        call.enqueue(callback);
    }

    // 在UI线程回调
    private Callback<UserResult> callback = new Callback<UserResult>() {
        @Override public void onResponse(Call<UserResult> call, Response<UserResult> response) {

        }

        @Override public void onFailure(Call<UserResult> call, Throwable t) {

        }
    };
}
