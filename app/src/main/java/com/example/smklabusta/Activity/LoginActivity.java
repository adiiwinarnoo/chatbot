package com.example.smklabusta.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smklabusta.Api.LoginRetrofit;
import com.example.smklabusta.Model.ResponseSiswa;
import com.example.smklabusta.R;
import com.example.smklabusta.fragment.ProfileFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText enisn, epass;
    Button btnLogin;
//    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        enisn = findViewById(R.id.edt_nisn);
        epass = findViewById(R.id.edt_pass);

        btnLogin = findViewById(R.id.login_profil);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Login();
            }
        });

    }

    private void Login() {

        String nisn = enisn.getText().toString();
        String Password = epass.getText().toString();

        if (nisn.isEmpty()){
            enisn.requestFocus();
            enisn.setError("Tolong Masukan Nama anda yang benar");
            return;
        }
        if (Password.isEmpty()){
            epass.requestFocus();
            epass.setError("Tolong masukan Password dengan Benar");
            return;
        }

        LoginRetrofit.service.login(nisn,Password).enqueue(new Callback<ResponseSiswa>() {
                    @Override
                    public void onResponse(Call<ResponseSiswa> call, Response<ResponseSiswa> response) {
//                        String pesan = response.body().getPesan();

                        int siswa = response.body().getStatus();

                        if (siswa == 1){
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            Toast.makeText(LoginActivity.this,"Login Berhasil", Toast.LENGTH_LONG).show();

                            intent.putExtra("nisn",nisn);
                            startActivity(intent);

                        }else {
                            Toast.makeText(LoginActivity.this,"Silahkan Masukan NISN dan Password Yang benar", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseSiswa> call, Throwable t) {
                        Toast.makeText(LoginActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });

    }
}