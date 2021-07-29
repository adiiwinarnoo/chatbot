package com.example.smklabusta.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.smklabusta.R;

public class SplashActivity extends AppCompatActivity {
    private int delay = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent inten = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(inten);
                finish();
            }
        },delay);
    }
}