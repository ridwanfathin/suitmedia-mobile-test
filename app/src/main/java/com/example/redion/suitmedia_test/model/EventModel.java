package com.example.redion.suitmedia_test.model;

/**
 * Created by redion on 25/02/18.
 */

public class EventModel {
    private String nama;
    private int image;
    private String tanggal;


    public EventModel(String nama, int image,String tanggal ) {
        this.nama = nama;
        this.image = image;
        this.tanggal = tanggal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int thumbnail) {
        this.image = thumbnail;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
