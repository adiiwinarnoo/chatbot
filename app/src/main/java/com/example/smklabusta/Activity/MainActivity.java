package com.example.smklabusta.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;

import com.example.smklabusta.fragment.ChattFragment;
import com.example.smklabusta.fragment.HomeFragment;
import com.example.smklabusta.fragment.ProfileFragment;
import com.example.smklabusta.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pixplicity.easyprefs.library.Prefs;

public class MainActivity extends AppCompatActivity {

    public String nomor,alamat;
    public BottomNavigationView navigationView;



    public BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            =item -> {
        switch (item.getItemId()){

            case R.id.beranda:
                HomeFragment homeFragment = new HomeFragment();
                FragmentTransaction fragmentHomeTransaction = getSupportFragmentManager().beginTransaction();
                fragmentHomeTransaction.replace(R.id.controller, homeFragment);
                fragmentHomeTransaction.commit();
                return true;
            case R.id.chat:
                ChattFragment chatFragment = new ChattFragment();
                FragmentTransaction fragmenChattTransaction = getSupportFragmentManager().beginTransaction();
                fragmenChattTransaction.replace(R.id.controller, chatFragment);
                fragmenChattTransaction.commit();
                return true;
            case R.id.profil:
                ProfileFragment profileFragment = new ProfileFragment();
                FragmentTransaction fragmentProfilTransaction = getSupportFragmentManager().beginTransaction();
                fragmentProfilTransaction.replace(R.id.controller, profileFragment);
                fragmentProfilTransaction.commit();

//                nomor = getIntent().getStringExtra("nisn");
                nomor = Prefs.getString("nisn","");
                Bundle bundle = new Bundle();
                bundle.putString("nisn",nomor);
                profileFragment.setArguments(bundle);
                return true;

//                if (chatFragment!=null){
//                    if (chatFragment.equals("message")){
//                        navigationView.setSelected(true);
//                        fragmenChattTransaction.replace(R.id.chat, chatFragment);
//                        navigationView.getSelectedItemId(chatFragment);
//                    }
//                }


        }
        return false;

//    };


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.controller, homeFragment);
        fragmentTransaction.commit();


        navigationView = (BottomNavigationView) findViewById(R.id.navView);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);




    }
//

    }

