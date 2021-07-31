package com.example.smklabusta.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smklabusta.Model.SiswaRelasiItem;
import com.example.smklabusta.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class profilAdapter extends RecyclerView.Adapter<profilAdapter.HolderProfil> {
List<SiswaRelasiItem> siswaProfilItems;
Context context;

    public profilAdapter(List<SiswaRelasiItem> siswaProfilItems, Context context) {
        this.siswaProfilItems = siswaProfilItems;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public HolderProfil onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.siswa_list, parent, false);


        return new HolderProfil(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HolderProfil holder, int position) {

        holder.tvNisn.setText(siswaProfilItems.get(position).getNomorInduk());
        holder.tvNama.setText(siswaProfilItems.get(position).getNama());
        holder.tvKelas.setText(siswaProfilItems.get(position).getKelas());
        holder.tvJurusan.setText(siswaProfilItems.get(position).getJurusan());
        holder.tvJekel.setText(siswaProfilItems.get(position).getJeniskelamin());
    }

    @Override
    public int getItemCount() {
        return siswaProfilItems.size();
    }

    public class HolderProfil extends RecyclerView.ViewHolder {
        TextView tvNisn,tvNama,tvKelas,tvJurusan,tvJekel;
        public HolderProfil(@NonNull @NotNull View itemView) {
            super(itemView);
            tvNisn = itemView.findViewById(R.id.tv_nisn);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvKelas = itemView.findViewById(R.id.tv_kelas);
            tvJurusan = itemView.findViewById(R.id.tv_jurusan);
            tvJekel = itemView.findViewById(R.id.tv_jekel);
        }
    }
}
