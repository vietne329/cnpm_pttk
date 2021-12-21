package com.btap.cnpm_pttk.model;

public class Thanhvien {
    private int id;
    private String username;
    private String password;
    private Hoten ten;
    private String ngaysinh;
    private Diachi diachi;
    private String email;
    private String dienthoai;
    private String vaitro;

    public Thanhvien() {
    }

    public Thanhvien(int id, String username, String password, Hoten ten, String ngaysinh, Diachi diachi, String email, String dienthoai, String vaitro) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.email = email;
        this.dienthoai = dienthoai;
        this.vaitro = vaitro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }
}
