package com.btap.cnpm_pttk.dao;
import com.btap.cnpm_pttk.model.Diachi;
import com.btap.cnpm_pttk.model.Hoten;
import com.btap.cnpm_pttk.model.Thanhvien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThanhvienDAO extends DAO{

    public ThanhvienDAO() {
        super();
    }

    public boolean checkLogin(Thanhvien tv){
        boolean check = false;

        String sql = "select * from tblthanhvien,tblhoten,tbldiachi where username = ? and password = ? " +
                "and tblthanhvien.tbldiachi_id=tbldiachi.id_diachi and tblthanhvien.tblhoten_id = tblhoten.id_hoten;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,tv.getUsername());
            ps.setString(2,tv.getPassword());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                tv.setId(rs.getInt("id"));

                Hoten hoten = new Hoten();
                hoten.setId(rs.getInt("id_diachi"));
                hoten.setHo(rs.getString("ho"));
                hoten.setDem(rs.getString("dem"));
                hoten.setTen(rs.getString("ten"));
                tv.setTen(hoten);

                Diachi diachi = new Diachi();
                diachi.setId(rs.getInt("id_hoten"));
                diachi.setDuong(rs.getString("duong"));
                diachi.setPhuong(rs.getString("phuong"));
                diachi.setSonha(rs.getString("sonha"));
                diachi.setQuan(rs.getString("quan"));
                diachi.setTinh(rs.getString("tinh"));
                tv.setDiachi(diachi);

                tv.setNgaysinh(rs.getString("ngaysinh"));
                tv.setEmail(rs.getString("email"));
                tv.setDienthoai(rs.getString("dienthoai"));
                tv.setVaitro(rs.getString("vaitro"));
                check =true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

}
