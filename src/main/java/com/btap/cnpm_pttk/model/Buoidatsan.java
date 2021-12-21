package com.btap.cnpm_pttk.model;

public class Buoidatsan implements Comparable<Buoidatsan>{
    private int id;
    private String ten;
    private String ngay;
    private float tongsotien;


    public Buoidatsan() {
    }

    public Buoidatsan(int id, String ten, String ngay, float tongsotien) {
        this.id = id;
        this.ten = ten;
        this.ngay = ngay;
        this.tongsotien = tongsotien;
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

    public float getTongsotien() {
        return tongsotien;
    }

    public void setTongsotien(float tongsotien) {
        this.tongsotien = tongsotien;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    @Override
    public int compareTo(Buoidatsan o) {
        return this.ten.compareTo(o.getTen());
    }
}
