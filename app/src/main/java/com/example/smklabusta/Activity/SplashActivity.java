package com.example.smklabusta.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.smklabusta.R;
import com.example.smklabusta.fragment.HomeFragment;
import com.pixplicity.easyprefs.library.Prefs;

public class SplashActivity extends AppCompatActivity {
    private int delay = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkLogin();
            }
        },delay);

    }
    private void checkLogin(){
        int logoutstatus = Prefs.getInt("LOGOUT",0);
        if (logoutstatus == 1){
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            Intent inten = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(inten);
                finish();
        }
    }
}