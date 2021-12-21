package com.btap.cnpm_pttk.dao;


import com.btap.cnpm_pttk.model.Diachi;
import com.btap.cnpm_pttk.model.Hoten;
import com.btap.cnpm_pttk.model.Khachhang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KhachhangDAO extends DAO{

    public KhachhangDAO() {
        super();
    }

    public ArrayList<Khachhang> getKhachhangtheoten(Khachhang khachhang){
        ArrayList<Khachhang> kq = null;
        String ten = khachhang.getTen().getTen();

        String sql = "select *  from tblkhachhang, tblhoten, tbldiachi where tblhoten.ten like \"%"+ten+"%\" and " +
                "tblkhachhang.tblhoten_id = tblhoten.id_hoten and tblkhachhang.tbldiachi_id = tbldiachi.id_diachi;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                if(kq==null) kq = new ArrayList<Khachhang>();
                Khachhang kh = new Khachhang();
                kh.setId(rs.getInt("id"));
                kh.setNgaysinh(rs.getString("ngaysinh"));
                kh.setEmail(rs.getString("email"));
                kh.setDienthoai(rs.getString("dienthoai"));

                Hoten hoten = new Hoten();
                hoten.setId(rs.getInt("id_hoten"));
                hoten.setHo(rs.getString("ho"));
                hoten.setDem(rs.getString("dem"));
                hoten.setTen(rs.getString("ten"));
                kh.setTen(hoten);

                Diachi diachi = new Diachi();
                diachi.setId(rs.getInt("id_diachi"));
                diachi.setSonha(rs.getString("sonha"));
                diachi.setDuong(rs.getString("duong"));
                diachi.setPhuong(rs.getString("phuong"));
                diachi.setQuan(rs.getString("quan"));
                diachi.setTinh(rs.getString("tinh"));
                kh.setDiachi(diachi);

                kq.add(kh);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return kq;
    }

}
