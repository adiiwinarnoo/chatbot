package com.example.smklabusta.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginRetrofit {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.100.6/SMK_LABUSTA/index.php/ApiLogin/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static com.example.smklabusta.Api.APIservice service =
            retrofit.create(com.example.smklabusta.Api.APIservice.class);
}
