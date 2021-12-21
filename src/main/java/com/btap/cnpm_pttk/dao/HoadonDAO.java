package com.btap.cnpm_pttk.dao;
import com.btap.cnpm_pttk.model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class HoadonDAO extends DAO{
    public HoadonDAO() {
        super();
    }

    public Hoadon getHoadon(int id_kh, int id_pds){
        Hoadon hoadon = new Hoadon();
        String sql = "select * from tblhoadon,tblphieudatsan,tblbuoidatsan,tblkhachhang\n" +
                "where tblhoadon.tblphieudatsan_id = tblphieudatsan.id_pds\n" +
                "and tblbuoidatsan.tblphieudatsan_id = tblphieudatsan.id_pds and tblphieudatsan.tblkhachhang_id = tblkhachhang.id \n" +
                "and tblphieudatsan.tblkhachhang_id = ? and tblphieudatsan.id_pds = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_kh);
            ps.setInt(2,id_pds);

            ResultSet rs = ps.executeQuery();

            ArrayList<Buoidatsan> lists_bds = new ArrayList<>();

            while(rs.next()){
                hoadon.setId(rs.getInt("id_hoadon"));
                hoadon.setTongsotien(rs.getFloat("tongsotien_hd"));
                hoadon.setIsthanhtoan(rs.getInt("isthanhtoan"));
                Phieudatsan pds = new Phieudatsan();
                pds.setId(rs.getInt("id_pds"));
                pds.setNgaylamhopdong(rs.getString("ngaylamhopdong"));
                pds.setNgayketthuc(rs.getString("ngayketthuc"));
                pds.setKhunggiothue(rs.getString("khunggiothue"));

                hoadon.setPhieudatsan(pds);
                Buoidatsan bds = new Buoidatsan();
                bds.setId(rs.getInt("id_bds"));
                bds.setTen(rs.getString("ten"));
                bds.setNgay(rs.getString("ngay"));
                bds.setTongsotien(rs.getFloat("tongsotien"));
                lists_bds.add(bds);
                hoadon.setBds(lists_bds);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        return hoadon;
    }

    public ArrayList<Buoidatsan> getDsbuoidatsan(int id_kh,int id_pds){
        ArrayList<Buoidatsan> ds = null;
        String sql = "select * from tblbuoidatsan,tblphieudatsan,tblkhachhang where tblphieudatsan.id_pds = tblbuoidatsan.tblphieudatsan_id and tblkhachhang.id = ? and tblphieudatsan.id_pds = ?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id_kh);
            ps.setInt(2,id_pds);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                if(ds==null) ds = new ArrayList<>();
                Buoidatsan bds = new Buoidatsan();
                bds.setId(rs.getInt("id_bds"));
                bds.setTen(rs.getString("ten"));
                bds.setNgay(rs.getString("ngay"));
                bds.setTongsotien(rs.getFloat("tongsotien"));
                ds.add(bds);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ds;
    }

    public ArrayList<Dichvu> getDsdichvu(int id_kh,int id_pds){
        ArrayList<Dichvu> ds = null;
        String sql = "select * from tblphieudatsan,tblbuoidatsan,tblkhachhang,tbldichvu where \n" +
                "tblbuoidatsan.tblphieudatsan_id = tblphieudatsan.id_pds and \n" +
                "tbldichvu.tblbuoidatsan_id = tblbuoidatsan.id_bds\n" +
                "and tblbuoidatsan.tblphieudatsan_id = tblphieudatsan.id_pds and tblphieudatsan.tblkhachhang_id = tblkhachhang.id and\n" +
                "tblphieudatsan.tblkhachhang_id = ? and tblphieudatsan.id_pds =?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id_kh);
            ps.setInt(2,id_pds);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                if(ds==null) ds = new ArrayList<>();
                Dichvu dv = new Dichvu();
                dv.setId(rs.getInt("id_dichvu"));
                dv.setMadichvu(rs.getString("ma_sp"));
                dv.setTen(rs.getString("ten_sp"));
                dv.setSoluong(rs.getInt("soluong_sp"));
                dv.setDongia(rs.getFloat("dongia_sp"));
                dv.setTongtien(rs.getFloat("tongtien"));
                dv.setTenbuoi(rs.getString("ten"));
                ds.add(dv);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ds;

    }

    public ArrayList<Sanbong> getDsSanBong(int id_kh,int id_pds){
        ArrayList<Sanbong> dssanbong = null;
        String sql = "SELECT tblsanbong.id_sanbong,tblsanbong.ten,tblsanbong.gia,tblsanbong.mota \n" +
                "FROM tblsanbong,tblsandat,tblkhachhang,tblphieudatsan \n" +
                "where tblsanbong.id_sanbong = tblsandat.tblsanbong_id and tblsandat.tblphieudatsan_id = tblphieudatsan.id_pds \n" +
                "and tblphieudatsan.tblkhachhang_id = tblkhachhang.id and tblkhachhang.id = ? and tblphieudatsan.id_pds = ?; ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id_kh);
            ps.setInt(2,id_pds);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                if(dssanbong==null) dssanbong = new ArrayList<>();
                Sanbong sb = new Sanbong();
                sb.setId(rs.getInt("id_sanbong"));
                sb.setTen(rs.getString("ten"));
                sb.setGia(rs.getFloat("gia"));
                sb.setMota(rs.getString("mota"));
                dssanbong.add(sb);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dssanbong;

    }

    public boolean xoaMH(int id_mh){
        String sql = "delete from tbldichvu where id_dichvu = ?";
        int n = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_mh);
            n = ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    public boolean capnhatBDS(float tongsotien, int bds_id){
        String sql = "update tblbuoidatsan set tongsotien = ? where tblbuoidatsan.id_bds = ?;";
        int n = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, Long.parseLong(String.format("%.0f",tongsotien)));
            ps.setInt(2,bds_id);
            n = ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    public boolean capnhatMH(int id_dv,int soluong,float dongia){
         String sql = "update tbldichvu set soluong_sp= ? ,tongtien= ? where tbldichvu.id_dichvu = ?";
        int n = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,soluong);
            ps.setLong(2, Long.parseLong(String.format("%.0f",dongia*soluong)));
            ps.setInt(3,id_dv);

            n = ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    public float getTongTienDichVuByBuoiDatSanId(int bds_id){
        float tongtien = 0;
        String sql ="select sum(tongtien) as tongtien from tbldichvu where tblbuoidatsan_id = ? group by tblbuoidatsan_id;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,bds_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
               tongtien = rs.getFloat("tongtien");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tongtien;
    }

    public boolean thanhtoan(Hoadon hoadon) throws SQLException {
        int n = 0;
        String sql ="update tblhoadon set isthanhtoan = 1,tongsotien_hd = ?  where tblhoadon.id_hoadon = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, Long.parseLong(String.format("%.0f",hoadon.getTongsotien())));
            ps.setInt(2,hoadon.getId());
             n = ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

}
