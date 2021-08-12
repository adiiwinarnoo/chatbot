package com.example.smklabusta.Model;

import com.google.gson.annotations.SerializedName;

public class DataGuruItem{

	@SerializedName("Nomor Induk")
	private String nomorInduk;

	@SerializedName("Nama")
	private String nama;

	@SerializedName("Pelajaran")
	private String pelajaran;

	@SerializedName("id")
	private String id;

	@SerializedName("id_guru")
	private String idGuru;

	@SerializedName("photo")
	private int photo;

	public int getPhoto() {
		return photo;
	}

	public void setPhoto(int photo) {
		this.photo = photo;
	}

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

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setIdGuru(String idGuru){
		this.idGuru = idGuru;
	}

	public String getIdGuru(){
		return idGuru;
	}
}