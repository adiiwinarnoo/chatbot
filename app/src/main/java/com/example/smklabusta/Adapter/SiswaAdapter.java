package com.example.smklabusta.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smklabusta.Model.DataLogin;
import com.example.smklabusta.R;

import java.util.ArrayList;
import java.util.List;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.HolderSiswa> {

    private Context context;
    List<DataLogin> siswaList = new ArrayList<>();

    public SiswaAdapter(Context context, List<DataLogin> siswaList) {
        this.context = context;
        this.siswaList = siswaList;
    }

    @Override
    public HolderSiswa onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_profile, parent, false);
        return new HolderSiswa(layout);
    }

    @Override
    public void onBindViewHolder(HolderSiswa holder, int position) {
        holder.tvnisn.setText(siswaList.get(position).getNomorInduk());
        holder.tvnama.setText(siswaList.get(position).getNama());
        holder.tvkelas.setText(siswaList.get(position).getKelas());
        holder.tvjurusan.setText(siswaList.get(position).getJurusan());
    }

    @Override
    public int getItemCount() {
        return siswaList.size();
    }

    public class HolderSiswa extends RecyclerView.ViewHolder {
        TextView tvnisn,tvnama,tvkelas,tvjurusan;

        public HolderSiswa(View itemView) {
            super(itemView);
            tvnisn = itemView.findViewById(R.id.tv_nisn);
            tvnama = itemView.findViewById(R.id.tv_nama);
            tvkelas = itemView.findViewById(R.id.tv_kelas);
            tvjurusan = itemView.findViewById(R.id.tv_jurusan);
        }
    }
}
