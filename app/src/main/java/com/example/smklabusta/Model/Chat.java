package com.example.smklabusta.Model;

public class Chat {

    private String pesan;
    private boolean isReceived;

    public Chat(String pesan, boolean isReceived){
        this.pesan = pesan;
        this.isReceived = isReceived;
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
