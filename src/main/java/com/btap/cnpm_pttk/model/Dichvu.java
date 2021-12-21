package com.btap.cnpm_pttk.model;

public class Dichvu {
    private int id;
    private String madichvu;
    private String ten;
    private float dongia;
    private int soluong;
    private float tongtien;
    private String tenbuoi;

    public Dichvu() {
    }

    public Dichvu(int id, String madichvu, String ten, float dongia, int soluong, float tongtien, String tenbuoi) {
        this.id = id;
        this.madichvu = madichvu;
        this.ten = ten;
        this.dongia = dongia;
        this.soluong = soluong;
        this.tongtien = tongtien;
        this.tenbuoi = tenbuoi;
    }

    public String getTenbuoi() {
        return tenbuoi;
    }

    public void setTenbuoi(String tenbuoi) {
        this.tenbuoi = tenbuoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMadichvu() {
        return madichvu;
    }

    public void setMadichvu(String madichvu) {
        this.madichvu = madichvu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }


    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }
}
