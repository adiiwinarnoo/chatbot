package com.example.smklabusta.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.smklabusta.Model.DataGuruItem;
import com.example.smklabusta.R;
import com.example.smklabusta.Model.Chat;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    int count = 0;

    private List<Chat> messageList;
//    private Activity activity;
    private Context context;

    public ChatAdapter(List<Chat> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }

    @NonNull @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_message_one, parent, false);
        return new MyViewHolder(view);
    }

    @Override public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        String message = messageList.get(position).getPesan();
//        String text = messageList.get(position).getDataGuruItems().get(position).getPelajaran();

        boolean isReceived = messageList.get(position).isReceived();
        String type = messageList.get(position).getType();
        if(isReceived){
            if(type.equals("picture")){
                Glide.with(holder.itemView.getContext())
                        .load(messageList.get(position).getGambar())
                        .apply(new RequestOptions().override(120, 150))
                        .into(holder.messageGambar);

                holder.messageReceive.setVisibility(View.VISIBLE);
                holder.messageSend.setVisibility(View.GONE);
                holder.messageGambar.setVisibility(View.VISIBLE);
                holder.messageReceive.setText(message);

            }else{
                holder.messageReceive.setVisibility(View.VISIBLE);
                holder.messageSend.setVisibility(View.GONE);
                holder.messageGambar.setVisibility(View.GONE);
                holder.messageReceive.setText(message);

            }

        }else {
            count++;
            holder.messageSend.setVisibility(View.VISIBLE);
            holder.messageReceive.setVisibility(View.GONE);
            holder.messageGambar.setVisibility(View.GONE);
            holder.messageSend.setText(message);
        }



    }

    @Override public int getItemCount() {
        return messageList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView messageSend;
        TextView messageReceive;
        TextView messsageQuery;
        ImageView messageGambar;
        RecyclerView recyclerGuru;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            messageSend = itemView.findViewById(R.id.message_send);
            messageReceive = itemView.findViewById(R.id.message_receive);
            messageGambar = itemView.findViewById(R.id.typeGambar);
//            recyclerGuru = itemView.findViewById(R.id.rec_gurur);
        }
    }

}
