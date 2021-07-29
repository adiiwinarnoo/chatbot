package com.example.smklabusta.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.smklabusta.Adapter.DataAdapter;
import com.example.smklabusta.Api.ConfigRetrofit;
import com.example.smklabusta.Model.GuruItem;
import com.example.smklabusta.Model.ResponseData;
import com.example.smklabusta.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.rv_1);
        ambilData();
    }

    private void ambilData() {

        ConfigRetrofit.service.getguru().enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                int status = response.body().getStatus();
                if (status == 1){
                    List<GuruItem> dataGuruList = response.body().getGuru();
                    DataAdapter adapter = new DataAdapter( MainActivity2.this, dataGuruList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));

                }else{
                    Toast.makeText(MainActivity2.this, "Data Guru Tidak Ada", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(MainActivity2.this, "ADA YANG SALAH : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
}
}