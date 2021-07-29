package com.example.smklabusta.fragment;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smklabusta.Activity.LoginActivity;
import com.example.smklabusta.Adapter.profilAdapter;
import com.example.smklabusta.Api.SiswaRetrofit;
import com.example.smklabusta.Model.ResponseSiswaProfil;
import com.example.smklabusta.Model.SiswaProfilItem;
import com.example.smklabusta.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {


//    View rootView;
//    String nisn,password;
//    EditText enisn,epass;
    TextView nisn,namaleng,kelasp,jurusanp;
    TextView nisn2,namalengk2,kelasp2,jurusanp2;
    Button btnlogout;
    private String nisnfix,namalengk5,kelas5,jurusan5;
    RecyclerView recyclerView;

    private String Tag = "ProfileFragment";

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
//        nisn = view.findViewById(R.id.txt_nisn);
//        namaleng = view.findViewById(R.id.txt_namaleng);
//        kelasp = view.findViewById(R.id.txt_kelasp);
//        jurusanp = view.findViewById(R.id.txt_jurusanp);
        recyclerView = view.findViewById(R.id.rec_profil);

        Bundle bundle = getArguments();

        if (bundle != null){
            nisnfix = bundle.getString("nisn");
//            nisn.setText(nisnfix);
            tampilProfil();

        }

        btnlogout = view.findViewById(R.id.logout_profil);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));

            }
        });
//        ambildata();
        return  view;

    }

    private void tampilProfil() {

        SiswaRetrofit.service.getsiswa(nisnfix).enqueue(new Callback<ResponseSiswaProfil>() {
            @Override
            public void onResponse(Call<ResponseSiswaProfil> call, Response<ResponseSiswaProfil> response) {
                int status = response.body().getStatus();

                if (status ==1){
                    List<SiswaProfilItem> siswaProfilItems = response.body().getSiswaProfil();
                    profilAdapter adapter = new profilAdapter(siswaProfilItems, getActivity());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
            }

            @Override
            public void onFailure(Call<ResponseSiswaProfil> call, Throwable t) {

            }
        });
    }


}


