package com.btap.cnpm_pttk.model;

public class Phieudatsan {
    private int id;
    private String ngaylamhopdong;
    private String ngayketthuc;
    private String khunggiothue;
    private Chusan thongtinchusan;
    private Khachhang thongtinkhachhang;

    public Phieudatsan() {
    }

    public Phieudatsan(int id, String ngaylamhopdong, String ngayketthuc, String khunggiothue, Chusan thongtinchusan, Khachhang thongtinkhachhang) {
        this.id = id;
        this.ngaylamhopdong = ngaylamhopdong;
        this.ngayketthuc = ngayketthuc;
        this.khunggiothue = khunggiothue;
        this.thongtinchusan = thongtinchusan;
        this.thongtinkhachhang = thongtinkhachhang;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgaylamhopdong() {
        return ngaylamhopdong;
    }

    public void setNgaylamhopdong(String ngaylamhopdong) {
        this.ngaylamhopdong = ngaylamhopdong;
    }

    public Chusan getThongtinchusan() {
        return thongtinchusan;
    }

    public void setThongtinchusan(Chusan thongtinchusan) {
        this.thongtinchusan = thongtinchusan;
    }

    public Khachhang getThongtinkhachhang() {
        return thongtinkhachhang;
    }

    public void setThongtinkhachhang(Khachhang thongtinkhachhang) {
        this.thongtinkhachhang = thongtinkhachhang;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public String getKhunggiothue() {
        return khunggiothue;
    }

    public void setKhunggiothue(String khunggiothue) {
        this.khunggiothue = khunggiothue;
    }
}
