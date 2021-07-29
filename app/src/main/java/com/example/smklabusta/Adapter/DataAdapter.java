package com.example.smklabusta.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smklabusta.Model.GuruItem;
import com.example.smklabusta.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.HolderData> {
    private Context context;
    List<GuruItem> dataGuruList;

    public DataAdapter(Context context, List<GuruItem> dataGuruList) {
        this.context = context;
        this.dataGuruList = dataGuruList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.guru_list, parent, false);
        return new HolderData(layout) ;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
//        DataGuru dataGuru = dataGuruList.get(position);
        holder.tvnama.setText(dataGuruList.get(position).getNama());
        holder.tvnisn.setText(String.valueOf(dataGuruList.get(position).getNomorInduk()));
        holder.tvpelajaran.setText(dataGuruList.get(position).getPelajaran());

    }

    @Override
    public int getItemCount() {

        return dataGuruList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvnama,tvnisn,tvpelajaran;


        public HolderData(View itemView) {
            super(itemView);

            tvnama = itemView.findViewById(R.id.tv_nama);
            tvnisn = itemView.findViewById(R.id.tv_nisn);
            tvpelajaran = itemView.findViewById(R.id.tv_mapel);
        }
    }
}
