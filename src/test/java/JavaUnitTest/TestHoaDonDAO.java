package JavaUnitTest;
import com.btap.cnpm_pttk.dao.DAO;
import com.btap.cnpm_pttk.dao.HoadonDAO;
import com.btap.cnpm_pttk.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Assert;


public class TestHoaDonDAO extends DAO{

    HoadonDAO hoadonDAO = new HoadonDAO();

    public int demBDS(int id_kh, int id_pds){
        int output = 0;
        String sql ="select count(*) as count_bds from tblbuoidatsan,tblphieudatsan,tblkhachhang where tblphieudatsan.id_pds = tblbuoidatsan.tblphieudatsan_id and tblkhachhang.id = ? and tblphieudatsan.id_pds = ?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id_kh);
            ps.setInt(2,id_pds);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                output = rs.getInt("count_bds");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

    public int demDV(int id_kh, int id_pds){
        int output = 0;
        String sql ="select count(*) as count_dv from tblphieudatsan,tblbuoidatsan,tblkhachhang,tbldichvu where \n" +
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
                output = rs.getInt("count_dv");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

    public int demSB(int id_kh, int id_pds){
        int output = 0;
        String sql ="SELECT count(*) as count_sb\n" +
                "FROM tblsanbong,tblsandat,tblkhachhang,tblphieudatsan \n" +
                "where tblsanbong.id_sanbong = tblsandat.tblsanbong_id and tblsandat.tblphieudatsan_id = tblphieudatsan.id_pds \n" +
                "and tblphieudatsan.tblkhachhang_id = tblkhachhang.id and tblkhachhang.id = ? and tblphieudatsan.id_pds = ?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id_kh);
            ps.setInt(2,id_pds);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                output = rs.getInt("count_sb");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }


    @DisplayName("Test l???y ???????c H??a ????n v???i id_kh??ch h??ng v?? id_phi???u ?????t s??n c?? t???n t???i")
    @Test
    public void getHoaDon(){
        int id_kh = 1;
        int id_pds = 1;

        Hoadon hoadon = hoadonDAO.getHoadon(id_kh,id_pds);
        Assert.assertNotNull(hoadon);
    }

    @DisplayName("Test kh??ng l???y ???????c H??a ????n v???i id_kh??ch h??ng v?? id_phi???u ?????t s??n kh??ng t???n t???i")
    @Test
    public void getHoaDon1(){
        int id_kh = 9999;
        int id_pds = 9999;

        Hoadon hoadon = hoadonDAO.getHoadon(id_kh,id_pds);
        Assert.assertEquals(0,hoadon.getId());
    }

    @DisplayName("Test l???y ???????c danh s??ch bu???i ?????t s??n theo id_kh??ch h??ng v?? id_phi???u ?????t s??n t???n t???i")
    @Test
    public void getDsbuoidatsan(){
        ArrayList<Buoidatsan> listBDS;
        int id_kh = 1;
        int id_pds = 1;

        listBDS = hoadonDAO.getDsbuoidatsan(id_kh,id_pds);
        Assert.assertNotNull(listBDS);

        int count = demBDS(id_kh,id_pds);
        Assert.assertEquals(count,listBDS.size());
    }

    @DisplayName("Test l???y ???????c danh s??ch bu???i ?????t s??n theo id_kh??ch h??ng v?? id_phi???u ?????t s??n kh??ng t???n t???i")
    @Test
    public void getDsbuoidatsan1(){
        ArrayList<Buoidatsan> listBDS;
        int id_kh = 999;
        int id_pds = 999;

        listBDS = hoadonDAO.getDsbuoidatsan(id_kh,id_pds);
        Assert.assertNull(listBDS);

        int count = demBDS(id_kh,id_pds);
        Assert.assertEquals(0,count);
    }

    @DisplayName("Test l???y ???????c danh s??ch d???ch v??? theo id_kh??ch h??ng v?? id_phi???u ?????t s??n t???n t???i")
    @Test
    public void getDsdichvu(){
        ArrayList<Dichvu> listDV;
        int id_kh = 1;
        int id_pds = 1;

        listDV = hoadonDAO.getDsdichvu(id_kh,id_pds);
        Assert.assertNotNull(listDV);

        int count = demDV(id_kh,id_pds);
        Assert.assertEquals(count,listDV.size());
    }

    @DisplayName("Test l???y ???????c danh s??ch d???ch v??? theo id_kh??ch h??ng v?? id_phi???u ?????t s??n kh??ng t???n t???i")
    @Test
    public void getDsdichvu1(){
        ArrayList<Dichvu> listDV;
        int id_kh = 999;
        int id_pds = 999;

        listDV = hoadonDAO.getDsdichvu(id_kh,id_pds);
        Assert.assertNull(listDV);

        int count = demDV(id_kh,id_pds);
        Assert.assertEquals(0,count);
    }

    @DisplayName("Test l???y ???????c danh s??ch s??n b??ng theo id_kh??ch h??ng v?? id_phi???u ?????t s??n ???? t???n t???i")
    @Test
    public void getDsSanBong(){
        ArrayList<Sanbong> listSB;
        int id_kh = 1;
        int id_pds = 1;

        listSB = hoadonDAO.getDsSanBong(id_kh,id_pds);
        Assert.assertNotNull(listSB);

        int count = demSB(id_kh,id_pds);
        System.out.println(count);
        Assert.assertEquals(count,listSB.size());
    }

    @DisplayName("Test l???y ???????c danh s??ch s??n b??ng theo id_kh??ch h??ng v?? id_phi???u ?????t s??n kh??ng t???n t???i")
    @Test
    public void getDsSanBong1(){
        ArrayList<Sanbong> listSB;
        int id_kh = 999;
        int id_pds = 999;

        listSB = hoadonDAO.getDsSanBong(id_kh,id_pds);
        Assert.assertNull(listSB);

        int count = demSB(id_kh,id_pds);
        Assert.assertEquals(0,count);
    }

    @DisplayName("Test x??a m???t h??ng theo id_d???ch v??? ???? t???n t???i")
    @Test
    public void xoaMH(){
        try {
            con.setAutoCommit(false);
            int id_dv = 1;
            boolean check = hoadonDAO.xoaMH(id_dv);
            Assert.assertTrue(check);
        }
        catch(Exception e) {
        }
        finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception e) {
            }
        }
    }

    @DisplayName("Test x??a m???t h??ng theo id_d???ch v??? ch??a t???n t???i")
    @Test
    public void xoaMH1(){
        try {
            con.setAutoCommit(false);
            int id_dv = 999;
            boolean check = hoadonDAO.xoaMH(id_dv);
            Assert.assertFalse(check);
        }
        catch(Exception e) {
        }
        finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception e) {
            }
        }
    }

    @DisplayName("Test c???p nh???t m???t h??ng theo id_d???ch v??? ???? t???n t???i ")
    @Test
    public void capnhatMH(){
        try {
            con.setAutoCommit(false);
            int id_dv = 1;
            boolean check = hoadonDAO.capnhatMH(id_dv,20,10000);
            Assert.assertTrue(check);
        }
        catch(Exception e) {
        }
        finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception e) {
            }
        }
    }

    @DisplayName("Test c???p nh???t m???t h??ng theo id_d???ch v??? ch??a t???n t???i ")
    @Test
    public void capnhatMH1(){
        try {
            con.setAutoCommit(false);
            int id_dv = 999;
            boolean check = hoadonDAO.capnhatMH(id_dv,20,10000);
            Assert.assertFalse(check);
        }
        catch(Exception e) {
        }
        finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception e) {
            }
        }
    }

    @DisplayName("Test l???y t???ng ti???n d???ch v??? theo id bu???i ?????t s??n ???? t???n t???i")
    @Test
    public void getTongTienDichVuByBuoiDatSanId(){
        float tongtien = 0;
        int id_bds = 1;
        tongtien = hoadonDAO.getTongTienDichVuByBuoiDatSanId(id_bds);
        Assert.assertEquals(250000,(long)tongtien);
    }

    @DisplayName("Test l???y t???ng ti???n d???ch v??? theo id bu???i ?????t s??n ch??a t???n t???i")
    @Test
    public void getTongTienDichVuByBuoiDatSanId1(){
        float tongtien = 0;
        int id_bds = 999;
        tongtien = hoadonDAO.getTongTienDichVuByBuoiDatSanId(id_bds);
        Assert.assertEquals(0,(long)tongtien);
    }

    @DisplayName("Test thanh to??n h??a ????n theo id h??a ????n ???? t???n t???i")
    @Test
    public void thanhtoan(){
        try {
            con.setAutoCommit(false);
            int id_hd = 1;
            boolean check = hoadonDAO.capnhatMH(1,2550000,id_hd);
            Assert.assertTrue(check);
        }
        catch(Exception e) {
        }
        finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception e) {
            }
        }
    }

    @DisplayName("Test thanh to??n h??a ????n theo id h??a ????n ch??a t???n t???i")
    @Test
    public void thanhtoan1(){
        try {
            con.setAutoCommit(false);
            int id_hd = 1;
            boolean check = hoadonDAO.capnhatMH(999,2550000,id_hd);
            Assert.assertFalse(check);
        }
        catch(Exception e) {
        }
        finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception e) {
            }
        }
    }

}
