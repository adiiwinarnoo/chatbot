package com.example.smklabusta.Model;

import com.google.gson.annotations.SerializedName;

public class GuruItem{

	@SerializedName("Nomor Induk")
	private String nomorInduk;

	@SerializedName("Nama")
	private String nama;

	@SerializedName("Pelajaran")
	private String pelajaran;

	public void setNomorInduk(String nomorInduk){
		this.nomorInduk = nomorInduk;
	}

	public String getNomorInduk(){
		return nomorInduk;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setPelajaran(String pelajaran){
		this.pelajaran = pelajaran;
	}

	public String getPelajaran(){
		return pelajaran;
	}

	@Override
 	public String toString(){
		return 
			"GuruItem{" + 
			"nomor Induk = '" + nomorInduk + '\'' + 
			",nama = '" + nama + '\'' + 
			",pelajaran = '" + pelajaran + '\'' + 
			"}";
		}
}