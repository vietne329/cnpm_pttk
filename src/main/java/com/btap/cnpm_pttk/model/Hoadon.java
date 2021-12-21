package com.btap.cnpm_pttk.model;
import java.util.*;

public class Hoadon {
    private int id;
    private float tongsotien;
    private Phieudatsan phieudatsan;
    private int isthanhtoan;

    public Hoadon() {
    }

    public Hoadon(int id, float tongsotien, Phieudatsan phieudatsan, int isthanhtoan) {
        this.id = id;
        this.tongsotien = tongsotien;
        this.phieudatsan = phieudatsan;
        this.isthanhtoan = isthanhtoan;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsthanhtoan() {
        return isthanhtoan;
    }

    public void setIsthanhtoan(int isthanhtoan) {
        this.isthanhtoan = isthanhtoan;
    }

    public float getTongsotien() {
        return tongsotien;
    }

    public void setTongsotien(float tongsotien) {
        this.tongsotien = tongsotien;
    }

    public Phieudatsan getPhieudatsan() {
        return phieudatsan;
    }

    public void setPhieudatsan(Phieudatsan phieudatsan) {
        this.phieudatsan = phieudatsan;
    }

}
