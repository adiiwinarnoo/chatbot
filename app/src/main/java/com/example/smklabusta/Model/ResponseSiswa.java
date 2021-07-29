package com.example.smklabusta.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseSiswa{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("dataLogin")
	private DataLogin dataLogin;

	@SerializedName("sukses")
	private boolean sukses;

	@SerializedName("status")
	private int status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setDataLogin(DataLogin dataLogin){
		this.dataLogin = dataLogin;
	}

	public DataLogin getDataLogin(){
		return dataLogin;
	}

	public void setSukses(boolean sukses){
		this.sukses = sukses;
	}

	public boolean isSukses(){
		return sukses;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}