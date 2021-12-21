package com.btap.cnpm_pttk.dao;
import com.btap.cnpm_pttk.model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhieudatsanDAO extends DAO{

    public PhieudatsanDAO() {
        super();
    }

    public ArrayList<Phieudatsan> getPhieudatsan(int id_kh){
        ArrayList<Phieudatsan> kq = null;

        String sql = "select * from tblphieudatsan, tblkhachhang, tblchusan, tblhoten, tbldiachi,tblsanbong \n" +
                "where tblphieudatsan.tblchusan_id = tblchusan.id_chusan and tblsanbong.id_sanbong = tblchusan.tblsanbong_id\n" +
                "and tblphieudatsan.tblkhachhang_id = tblkhachhang.id  and tblhoten.id_hoten = tblkhachhang.tblhoten_id\n" +
                "and tbldiachi.id_diachi = tblkhachhang.tbldiachi_id  and tblkhachhang_id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id_kh);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                if(kq==null) kq = new ArrayList<>();
                Phieudatsan phieudatsan = new Phieudatsan();
                phieudatsan.setId(rs.getInt("id_pds"));
                phieudatsan.setNgaylamhopdong(rs.getString("ngaylamhopdong"));
                phieudatsan.setNgayketthuc(rs.getString("ngayketthuc"));
                phieudatsan.setKhunggiothue(rs.getString("khunggiothue"));

                Khachhang kh = new Khachhang();
                kh.setId(id_kh);
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
                kh.setDiachi(diachi);;
                phieudatsan.setThongtinkhachhang(kh);

                Chusan cs =new Chusan();
                cs.setId(rs.getInt("id_chusan"));
                cs.setTenchusan(rs.getString("hoten"));
                cs.setDiachi(rs.getString("diachi"));
                cs.setDienthoai(rs.getString("sdt_cs"));
                cs.setNgaysinh(rs.getString("ngaysinh_cs"));
                cs.setEmail(rs.getString("email_cs"));
                Sanbong sanbong = new Sanbong();
                sanbong.setId(rs.getInt("id_sanbong"));
                sanbong.setTen(rs.getString("ten"));
                sanbong.setGia(rs.getFloat("gia"));
                sanbong.setMota(rs.getString("mota"));
                cs.setSanbongsohuu(sanbong);

                phieudatsan.setThongtinchusan(cs);

                kq.add(phieudatsan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return kq;
    }

}
