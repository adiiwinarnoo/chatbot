package com.example.smklabusta.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SiswaRetrofit {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.100.6/SMK_LABUSTA/index.php/ApiSiswa/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static com.example.smklabusta.Api.APIservice service = retrofit.create(com.example.smklabusta.Api.APIservice.class);

}
