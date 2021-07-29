package com.example.smklabusta.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponsePesan{

	@SerializedName("pesan")
	private List<PesanItem> pesan;

	@SerializedName("status")
	private int status;

	public void setPesan(List<PesanItem> pesan){
		this.pesan = pesan;
	}

	public List<PesanItem> getPesan(){
		return pesan;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

}