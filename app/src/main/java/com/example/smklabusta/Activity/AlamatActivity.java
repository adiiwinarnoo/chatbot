package com.example.smklabusta.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smklabusta.R;

public class AlamatActivity extends AppCompatActivity {

    public static final String EXTRA_STRING = "extra_string";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alamat);

    }
}