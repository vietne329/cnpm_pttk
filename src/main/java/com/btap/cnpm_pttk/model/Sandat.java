package com.btap.cnpm_pttk.model;
import java.util.List;

public class Sandat {
    private int id;
    private int soluongsandat;
    private String mota;
    private List<Sanbong> dssandat;

    public Sandat() {
    }

    public Sandat(int id, int soluongsandat, String mota, List<Sanbong> dssandat) {
        this.id = id;
        this.soluongsandat = soluongsandat;
        this.mota = mota;
        this.dssandat = dssandat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoluongsandat() {
        return soluongsandat;
    }

    public void setSoluongsandat(int soluongsandat) {
        this.soluongsandat = soluongsandat;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public List<Sanbong> getDssandat() {
        return dssandat;
    }

    public void setDssandat(List<Sanbong> dssandat) {
        this.dssandat = dssandat;
    }
}
