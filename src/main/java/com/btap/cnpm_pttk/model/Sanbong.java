package com.btap.cnpm_pttk.model;

public class Sanbong {
    private int id;
    private String ten;
    private float gia;
    private String mota;

    public Sanbong() {
    }

    public Sanbong(int id, String ten, float gia, String mota) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
