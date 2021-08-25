package com.example.smklabusta.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GuruRetrofit {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.43.26/SMK_LABUSTA/index.php/Apiguru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static com.example.smklabusta.Api.APIservice service = retrofit.create(com.example.smklabusta.Api.APIservice.class);

}
