package com.example.smklabusta.Model;

public class Chat {

    private String pesan;
    private boolean isReceived;
    private String type ;
    private String gambar;



    public Chat(String pesan, boolean isReceived, String type, String gambar) {
        this.pesan = pesan;
        this.isReceived = isReceived;
        this.type = type;
        this.gambar = gambar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getPesan(){return pesan;}

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public boolean isReceived() {
        return isReceived;
    }

    public void setReceived(boolean received) {
        this.isReceived = isReceived;
    }
}
