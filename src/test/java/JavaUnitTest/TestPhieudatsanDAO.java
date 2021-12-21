package JavaUnitTest;

import com.btap.cnpm_pttk.dao.DAO;
import com.btap.cnpm_pttk.dao.PhieudatsanDAO;
import com.btap.cnpm_pttk.model.Khachhang;
import com.btap.cnpm_pttk.model.Phieudatsan;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Assert;

public class TestPhieudatsanDAO extends DAO {

    PhieudatsanDAO phieudatsanDAO = new PhieudatsanDAO();

    public int getTongPhieuDatSanByID_KH(int id_kh){
        int output = 0;
        String sql ="select count(*) as pds_quantity from tblphieudatsan where tblphieudatsan.tblkhachhang_id = ?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id_kh);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                output = rs.getInt("pds_quantity");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

    @DisplayName("Test lấy được phiếu đặt sân với id khách hàng tồn tại")
    @Test
    public void getPhieudatsan(){
        int id_kh = 1;
        ArrayList<Phieudatsan> listPDS = phieudatsanDAO.getPhieudatsan(id_kh);
        int sum = getTongPhieuDatSanByID_KH(id_kh);
        Assert.assertEquals(sum,listPDS.size());
    }

    @DisplayName("Test không lấy được phiếu đặt sân với id khách hàng không tồn tại")
    @Test
    public void getPhieudatsan1(){
        int id_kh = 999;
        ArrayList<Phieudatsan> listPDS = phieudatsanDAO.getPhieudatsan(id_kh);
        boolean check = false;
        if(listPDS == null){
            check = true;
        }
        int sum = getTongPhieuDatSanByID_KH(id_kh);
        boolean check2 = false;
        if(sum == 0){
            check2 = true;
        }
        boolean check3 = false;
        if(check && check2){
            check3=true;
        }
        Assert.assertEquals(true,check3);
    }
}
