package com.btap.cnpm_pttk.model;

public class Khachhang {
    private int id;
    private Hoten ten;
    private String ngaysinh;
    private Diachi diachi;
    private String email;
    private String dienthoai;

    public Khachhang() {
    }

    public Khachhang(int id, Hoten ten, String ngaysinh, Diachi diachi, String email, String dienthoai) {
        this.id = id;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.email = email;
        this.dienthoai = dienthoai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hoten getTen() {
        return ten;
    }

    public void setTen(Hoten ten) {
        this.ten = ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Diachi getDiachi() {
        return diachi;
    }

    public void setDiachi(Diachi diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }
}
