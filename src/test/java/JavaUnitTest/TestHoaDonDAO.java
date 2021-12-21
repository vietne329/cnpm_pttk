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


    @DisplayName("Test lấy được Hóa đơn với id_khách hàng và id_phiếu đặt sân có tồn tại")
    @Test
    public void getHoaDon(){
        int id_kh = 1;
        int id_pds = 1;

        Hoadon hoadon = hoadonDAO.getHoadon(id_kh,id_pds);
        Assert.assertNotNull(hoadon);
    }

    @DisplayName("Test không lấy được Hóa đơn với id_khách hàng và id_phiếu đặt sân không tồn tại")
    @Test
    public void getHoaDon1(){
        int id_kh = 9999;
        int id_pds = 9999;

        Hoadon hoadon = hoadonDAO.getHoadon(id_kh,id_pds);
        Assert.assertEquals(0,hoadon.getId());
    }

    @DisplayName("Test lấy được danh sách buổi đặt sân theo id_khách hàng và id_phiếu đặt sân tồn tại")
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

    @DisplayName("Test lấy được danh sách buổi đặt sân theo id_khách hàng và id_phiếu đặt sân không tồn tại")
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

    @DisplayName("Test lấy được danh sách dịch vụ theo id_khách hàng và id_phiếu đặt sân tồn tại")
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

    @DisplayName("Test lấy được danh sách dịch vụ theo id_khách hàng và id_phiếu đặt sân không tồn tại")
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

    @DisplayName("Test lấy được danh sách sân bóng theo id_khách hàng và id_phiếu đặt sân đã tồn tại")
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

    @DisplayName("Test lấy được danh sách sân bóng theo id_khách hàng và id_phiếu đặt sân không tồn tại")
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

    @DisplayName("Test xóa mặt hàng theo id_dịch vụ đã tồn tại")
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

    @DisplayName("Test xóa mặt hàng theo id_dịch vụ chưa tồn tại")
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

    @DisplayName("Test cập nhật mặt hàng theo id_dịch vụ đã tồn tại ")
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

    @DisplayName("Test cập nhật mặt hàng theo id_dịch vụ chưa tồn tại ")
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

    @DisplayName("Test lấy tổng tiền dịch vụ theo id buổi đặt sân đã tồn tại")
    @Test
    public void getTongTienDichVuByBuoiDatSanId(){
        float tongtien = 0;
        int id_bds = 1;
        tongtien = hoadonDAO.getTongTienDichVuByBuoiDatSanId(id_bds);
        Assert.assertEquals(250000,(long)tongtien);
    }

    @DisplayName("Test lấy tổng tiền dịch vụ theo id buổi đặt sân chưa tồn tại")
    @Test
    public void getTongTienDichVuByBuoiDatSanId1(){
        float tongtien = 0;
        int id_bds = 999;
        tongtien = hoadonDAO.getTongTienDichVuByBuoiDatSanId(id_bds);
        Assert.assertEquals(0,(long)tongtien);
    }

    @DisplayName("Test thanh toán hóa đơn theo id hóa đơn đã tồn tại")
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

    @DisplayName("Test thanh toán hóa đơn theo id hóa đơn chưa tồn tại")
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
