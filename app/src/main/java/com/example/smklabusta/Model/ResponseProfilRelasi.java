package com.example.smklabusta.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseProfilRelasi{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("siswa_relasi")
	private List<SiswaRelasiItem> siswaRelasi;

	@SerializedName("status")
	private int status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setSiswaRelasi(List<SiswaRelasiItem> siswaRelasi){
		this.siswaRelasi = siswaRelasi;
	}

	public List<SiswaRelasiItem> getSiswaRelasi(){
		return siswaRelasi;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}