package JavaUnitTest;

import com.btap.cnpm_pttk.dao.DAO;
import com.btap.cnpm_pttk.dao.KhachhangDAO;
import com.btap.cnpm_pttk.model.Hoten;
import com.btap.cnpm_pttk.model.Khachhang;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Assert;


public class TestKhanghangDAO extends DAO {

    KhachhangDAO khachhangDAO = new KhachhangDAO();

    public int countKHbyTen(Khachhang kh){
        int output = 0;
        String sql ="select count(*) as kh_quantity from tblkhachhang;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                output = rs.getInt("kh_quantity");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

    public int countKHbyTenCoDieuKien(Khachhang kh){

        int output = 0;
        String sql ="select count(*) as kh_quantity from tblkhachhang,tblhoten where tblkhachhang.tblhoten_id = tblhoten.id_hoten and tblhoten.ten = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,kh.getTen().getTen());
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                output = rs.getInt("kh_quantity");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

    @DisplayName("Test tên khách hàng null(không nhập gì) sẽ trả về toàn bộ khách hàng")
    @Test
    public void getKhachhangTheoTen(){
        Khachhang kh = new Khachhang();
        Hoten hoten = new Hoten();
        hoten.setTen("");
        kh.setTen(hoten);
        ArrayList<Khachhang> listsKH = khachhangDAO.getKhachhangtheoten(kh);
        int kh_quantity = countKHbyTen(kh);

        Assert.assertEquals(kh_quantity,listsKH.size());
    }

    @DisplayName("Test tên khách hàng với tên đúng")
    @Test
    public void getKhachhangTheoTen1(){
        Khachhang kh = new Khachhang();
        Hoten hoten = new Hoten();
        hoten.setTen("Dũng");
        kh.setTen(hoten);
        ArrayList<Khachhang> listsKH = khachhangDAO.getKhachhangtheoten(kh);
        int kh_quantity = countKHbyTenCoDieuKien(kh);

        Assert.assertEquals(kh_quantity,listsKH.size());
    }

    @DisplayName("Test tên khách hàng với tên gần đúng")
    @Test
    public void getKhachhangTheoTen2(){
        Khachhang kh = new Khachhang();
        Hoten hoten = new Hoten();
        hoten.setTen("dung");
        kh.setTen(hoten);
        ArrayList<Khachhang> listsKH = khachhangDAO.getKhachhangtheoten(kh);
        int kh_quantity = countKHbyTenCoDieuKien(kh);

        Assert.assertEquals(kh_quantity,listsKH.size());

    }

    @DisplayName("Test tên khách hàng với tên sai")
    @Test
    public void getKhachhangTheoTen3(){
        Khachhang kh = new Khachhang();
        Hoten hoten = new Hoten();
        hoten.setTen("abcabcabc");
        kh.setTen(hoten);
        ArrayList<Khachhang> listsKH = khachhangDAO.getKhachhangtheoten(kh);
        boolean check = false;
        if(listsKH == null){
            check = true;
        }
        Assert.assertEquals(true,check);
    }



}
