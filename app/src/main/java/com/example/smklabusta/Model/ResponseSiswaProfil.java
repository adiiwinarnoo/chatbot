package com.example.smklabusta.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseSiswaProfil{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("siswa_profil")
	private List<SiswaProfilItem> siswaProfil;

	@SerializedName("status")
	private int status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setSiswaProfil(List<SiswaProfilItem> siswaProfil){
		this.siswaProfil = siswaProfil;
	}

	public List<SiswaProfilItem> getSiswaProfil(){
		return siswaProfil;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}