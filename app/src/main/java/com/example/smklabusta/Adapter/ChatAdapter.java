package com.example.smklabusta.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_message_one, parent, false);
        return new MyViewHolder(view);
    }

    @Override public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String message = messageList.get(position).getPesan();
        boolean isReceived = messageList.get(position).isReceived();
        if(isReceived){
            holder.messageReceive.setVisibility(View.VISIBLE);
            holder.messageSend.setVisibility(View.GONE);
            holder.messageReceive.setText(message);
        }else {
            count++;
            holder.messageSend.setVisibility(View.VISIBLE);
            holder.messageReceive.setVisibility(View.GONE);
            holder.messageSend.setText(message);
        }
    }

    @Override public int getItemCount() {
        return messageList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView messageSend;
        TextView messageReceive;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            messageSend = itemView.findViewById(R.id.message_send);
            messageReceive = itemView.findViewById(R.id.message_receive);
        }
    }

}
