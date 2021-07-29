package com.example.smklabusta.Model;

import com.google.gson.annotations.SerializedName;

public class DataLogin{

	@SerializedName("Nomor_Induk")
	private String nomorInduk;

	@SerializedName("Nama")
	private String nama;

	@SerializedName("Jurusan")
	private String jurusan;

	@SerializedName("Kelas")
	private String kelas;

	@SerializedName("Password")
	private String password;

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

	public void setJurusan(String jurusan){
		this.jurusan = jurusan;
	}

	public String getJurusan(){
		return jurusan;
	}

	public void setKelas(String kelas){
		this.kelas = kelas;
	}

	public String getKelas(){
		return kelas;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}
}