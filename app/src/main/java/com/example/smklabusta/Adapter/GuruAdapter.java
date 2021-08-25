package com.example.smklabusta.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.smklabusta.Model.DataGuruItem;
import com.example.smklabusta.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GuruAdapter extends RecyclerView.Adapter<GuruAdapter.Holderguru> {
    List<DataGuruItem> dataGuruItems;
    Context context;

    public GuruAdapter(Context context, List<DataGuruItem> dataGuruItems) {
        this.context = context;
        this.dataGuruItems = dataGuruItems;
    }



    @Override
    public Holderguru onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.guruget_list, parent, false);

        return new Holderguru(layout);
    }

    @Override
    public void onBindViewHolder(Holderguru holder, int position) {


        DataGuruItem dataGuruItem = dataGuruItems.get(position);
        Glide.with(holder.itemView.getContext())
                .load(dataGuruItem.getPhoto())
                .apply(new RequestOptions().override(120, 150))
                .into(holder.imageView);

        holder.tvNama.setText(dataGuruItems.get(position).getNama());
        holder.tvNmrin.setText(dataGuruItems.get(position).getNomorInduk());
        holder.tvMapel.setText(dataGuruItems.get(position).getPelajaran());
    }

    @Override
    public int getItemCount() {

        return dataGuruItems.size();
    }

    public class Holderguru extends RecyclerView.ViewHolder {
        TextView tvNama, tvNmrin, tvMapel;
        ImageView imageView;

        public Holderguru(@NonNull @NotNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_namaguru);
            tvNmrin = itemView.findViewById(R.id.tv_nisnguru);
            tvMapel = itemView.findViewById(R.id.tv_mapelguru);
//            imageView = itemView.findViewById(R.id.messageGambar);

        }
    }
}
