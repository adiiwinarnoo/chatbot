package com.example.smklabusta.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smklabusta.Adapter.ChatAdapter;
import com.example.smklabusta.Api.SiswaRetrofit;
import com.example.smklabusta.Api.pesanRetrofit;
import com.example.smklabusta.Helper.SendMessageInBg;
import com.example.smklabusta.Interface.BotReply;
import com.example.smklabusta.Model.Chat;
import com.example.smklabusta.Model.ResponsePesan;
import com.example.smklabusta.R;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.SessionsSettings;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.common.collect.Lists;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChattFragment extends Fragment implements BotReply {






    public ChattFragment(){

    }
    List<Chat> chats = new ArrayList<>();
    RecyclerView recyclerView;
    ChatAdapter chatAdapter;
    EditText Pesan;
    ImageButton btnSend;
    TextView alamat,guru,tvSend;







    //dialogFlow
    private SessionsClient sessionsClient;
    private SessionName sessionName;
    private String uuid = UUID.randomUUID().toString();
    private String TAG = "mainactivity";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chatt, container, false);
        chatAdapter = new ChatAdapter(chats, getContext());
        Pesan = view.findViewById(R.id.editMessage);
        recyclerView = view.findViewById(R.id.chatView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(chatAdapter);
//        EditText pesan = (EditText) view.findViewById(R.id.editMessage);
        btnSend= view.findViewById(R.id.btnSend);
        alamat= view.findViewById(R.id.tv_alamat);
        guru = view.findViewById(R.id.guru_tv);





        Bundle bundle = getArguments();

        String inimessage;
        if (bundle!=null){
            inimessage = bundle.getString("Message");
            Pesan.setText(inimessage);
        }


//        String guruu = bundle.getString("Data Guru");
//
//        Pesan.setText(guruu);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EditText text = (EditText) v.findViewById(R.id.editMessage);
                String pesan = Pesan.getText().toString();
                if (!pesan.isEmpty()){
                    chats.add(new Chat(pesan, false));
                    Pesan.setText("");
                    sendMessageToBot(pesan);
                    Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
                    Objects.requireNonNull(recyclerView.getLayoutManager())
                            .scrollToPosition(chats.size() - 1);


                }else {
                Toast.makeText(recyclerView.getContext(), "tolong masukan pesan", Toast.LENGTH_SHORT).show();
                }
            }
        });

        SetUpBot();

        return view;

    }
    public void tambahpesan(String inputpesan, String response_pesan){


        pesanRetrofit.service.inputpesan(inputpesan,response_pesan).enqueue(new Callback<ResponsePesan>() {
            @Override
            public void onResponse(Call<ResponsePesan> call, Response<ResponsePesan> response) {

            }

            @Override
            public void onFailure(Call<ResponsePesan> call, Throwable t) {

            }
        });

    }


    private void SetUpBot () {
        try {
            InputStream stream = this.getResources().openRawResource(R.raw.inilabusta);
            GoogleCredentials credentials = GoogleCredentials.fromStream(stream)
                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
            String projectId = ((ServiceAccountCredentials) credentials).getProjectId();

            SessionsSettings.Builder settingsBuilder = SessionsSettings.newBuilder();
            SessionsSettings sessionsSettings = settingsBuilder.setCredentialsProvider(
                    FixedCredentialsProvider.create(credentials)).build();
            sessionsClient = SessionsClient.create(sessionsSettings);
            sessionName = SessionName.of(projectId, uuid);

            Log.d(TAG, "projectId : " + projectId);

        } catch (Exception e) {
            Log.d(TAG, "setUpBot: " + e.getMessage());
        }

    }

    private void sendMessageToBot(String pesan) {
        QueryInput input = QueryInput.newBuilder()
                .setText(TextInput.newBuilder().setText(pesan).setLanguageCode("en-US")).build();
        new SendMessageInBg(this, sessionName, sessionsClient, input).execute();


    }

    int count = 0;
    @Override
    public void callback(DetectIntentResponse returnResponse) {


        String response_messg = chats.get(count).getPesan().toString();

        if(returnResponse!=null) {
            String botReply = returnResponse.getQueryResult().getFulfillmentText();
            Log.d("BOT REPLY", returnResponse.getQueryResult().toString());

            if(!botReply.isEmpty()){
                tambahpesan(response_messg,botReply);
                count+=2;
                chats.add(new Chat(botReply, true));
                chatAdapter.notifyDataSetChanged();
                Objects.requireNonNull(recyclerView.getLayoutManager()).scrollToPosition(chats.size() - 1);

            }else {
                Toast.makeText(recyclerView.getContext(), "ada yang salah nih", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(recyclerView.getContext(), "failed to connect!", Toast.LENGTH_SHORT).show();
        }
    }
}