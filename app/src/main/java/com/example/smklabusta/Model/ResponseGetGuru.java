package com.example.smklabusta.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseGetGuru{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("Data Guru")
	private List<DataGuruItem> dataGuru;

	@SerializedName("status")
	private int status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setDataGuru(List<DataGuruItem> dataGuru){
		this.dataGuru = dataGuru;
	}

	public List<DataGuruItem> getDataGuru(){
		return dataGuru;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}