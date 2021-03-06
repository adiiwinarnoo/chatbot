package com.example.smklabusta.Api;

import com.example.smklabusta.Model.ResponseData;
import com.example.smklabusta.Model.ResponseGetGuru;
import com.example.smklabusta.Model.ResponsePesan;
import com.example.smklabusta.Model.ResponseProfilRelasi;
import com.example.smklabusta.Model.ResponseSiswa;
import com.example.smklabusta.Model.ResponseSiswaProfil;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIservice {

    @GET("getguru2")
    Call<ResponseData> getguru2();

    @GET("getguru3")
    Call<ResponseGetGuru> getguru3(@Query("id_guru") String idguru);

    @FormUrlEncoded
    @POST("getsiswaNISN")
    Call<ResponseProfilRelasi> getsiswa(@Field("Nomor_Induk") String nisnfix);

    @FormUrlEncoded
    @POST("Login")
    Call<ResponseSiswa> login(@Field("Nomor_Induk") String nisn,
                              @Field("Password") String password);

    @FormUrlEncoded
    @POST("tambahchat")
    Call<ResponsePesan> inputpesan(@Field("pesan_chat") String inputpesan,
                                   @Field("response_pesan") String response_pesan);

}
