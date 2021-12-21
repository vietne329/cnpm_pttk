package com.btap.cnpm_pttk.model;

public class Hoten {
    private int id;
    private String ho;
    private String dem;
    private String ten;

    public Hoten() {
    }

    public Hoten(int id, String ho, String dem, String ten) {
        this.id = id;
        this.ho = ho;
        this.dem = dem;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getDem() {
        return dem;
    }

    public void setDem(String dem) {
        this.dem = dem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
