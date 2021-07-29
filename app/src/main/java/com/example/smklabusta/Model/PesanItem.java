package com.example.smklabusta.Model;

import com.google.gson.annotations.SerializedName;

public class PesanItem{

	@SerializedName("id_chat")
	private String idChat;

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("response_pesan")
	private String response_pesan;



	@SerializedName("created_at")
	private String createdAt;

	public void setIdChat(String idChat){
		this.idChat = idChat;
	}

	public String getIdChat(){
		return idChat;
	}

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public String getResponse_pesan() {
		return response_pesan;
	}

	public void setResponse_pesan(String response_pesan) {
		this.response_pesan = response_pesan;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}


}