package com.example.smklabusta.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseData{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("Guru")
	private List<GuruItem> guru;

	@SerializedName("status")
	private int status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setGuru(List<GuruItem> guru){
		this.guru = guru;
	}

	public List<GuruItem> getGuru(){
		return guru;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseData{" + 
			"pesan = '" + pesan + '\'' + 
			",guru = '" + guru + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}