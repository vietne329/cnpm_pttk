package com.btap.cnpm_pttk.model;

import java.util.List;

public class Chusan {
    private int id;
    private String tenchusan;
    private String ngaysinh;
    private String diachi;
    private String email;
    private String dienthoai;
    private Sanbong sanbongsohuu;

    public Chusan() {
    }

    public Chusan(int id, String tenchusan, String ngaysinh, String diachi, String email, String dienthoai, Sanbong sanbongsohuu) {
        this.id = id;
        this.tenchusan = tenchusan;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.email = email;
        this.dienthoai = dienthoai;
        this.sanbongsohuu = sanbongsohuu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenchusan() {
        return tenchusan;
    }

    public void setTenchusan(String tenchusan) {
        this.tenchusan = tenchusan;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
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

    public Sanbong getSanbongsohuu() {
        return sanbongsohuu;
    }

    public void setSanbongsohuu(Sanbong sanbongsohuu) {
        this.sanbongsohuu = sanbongsohuu;
    }
}
