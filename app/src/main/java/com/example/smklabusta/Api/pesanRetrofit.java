package com.example.smklabusta.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class pesanRetrofit {
    public static Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("http://labusta.000webhostapp.com/SMK_LABUSTA/index.php/Apichat/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static com.example.smklabusta.Api.APIservice service =
            retrofit.create(com.example.smklabusta.Api.APIservice.class);
}
