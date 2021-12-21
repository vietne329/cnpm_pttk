<%@ page import="com.btap.cnpm_pttk.dao.HoadonDAO" %>
<%@page import="java.util.*" %>
<%@ page import="com.btap.cnpm_pttk.dao.KhachhangDAO" %>
<%@ page import="com.btap.cnpm_pttk.model.*" %>
<%@ page import="com.btap.cnpm_pttk.dao.PhieudatsanDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thanh toán</title>
</head>
<body>

    <div style="text-align:left; margin-left: 20px">
        <h1>HÓA ĐƠN THANH TOÁN</h1>
        <% int id_kh = Integer.parseInt((String)request.getParameter("id_kh"));
            int id_pds = Integer.parseInt((String)request.getParameter("id_pds"));
            float tiensan = Float.parseFloat((String)request.getParameter("tiensan"));
            HoadonDAO dao = new HoadonDAO();
            Hoadon hoadon = dao.getHoadon(id_kh,id_pds);
            session.setAttribute("hoadon",hoadon);
            ArrayList<Sanbong> listSanbong = dao.getDsSanBong(id_kh,id_pds);
            ArrayList<Buoidatsan> listBuoidatsan = dao.getDsbuoidatsan(id_kh,id_pds);
            ArrayList<Dichvu> listDv = dao.getDsdichvu(id_kh,id_pds);

            PhieudatsanDAO pdsDAO = new PhieudatsanDAO();
            ArrayList<Phieudatsan> lists = pdsDAO.getPhieudatsan(id_kh);
        float tongsotien = 0;
        %>

        <h3>- Ngày làm hợp đồng: <%=hoadon.getPhieudatsan().getNgaylamhopdong()%></h3>
        <h3>- Ngày kết thúc: <%=hoadon.getPhieudatsan().getNgayketthuc()%></h3>
        <h3>- Tiền sân: <%=String.format("%.0f",tiensan)+" đồng"%></h3>
        <h3>- Các ngày đặt: <br> <% for (Buoidatsan b: listBuoidatsan) { tongsotien += b.getTongsotien();%>
                    <h4 style="font-size: small"><%="Tên: "+b.getTen()+" - Ngày: "+b.getNgay()+" - Tiền dịch vụ: "+String.format("%.0f",b.getTongsotien())+" đồng"%></h4>
            <%}%></h3>
        <h3>- Thông tin sân:</h3>
        <% for (int i = 0 ; i < listSanbong.size(); i++){%>
        <h4 style="font-size: small"><%="Tên: "+listSanbong.get(i).getTen()+" - Giá: "+String.format("%.0f", listSanbong.get(i).getGia())+" đồng - Mô tả: "+listSanbong.get(i).getMota()%></h4>
        <%}%>

        <h3>- Thông tin khách hàng: </h3>
        <h4 style="font-size: small">Họ và tên: <%=lists.get(0).getThongtinkhachhang().getTen().getHo()+" "+lists.get(0).getThongtinkhachhang().getTen().getDem()+" "+lists.get(0).getThongtinkhachhang().getTen().getTen() %> </h4>
        <h4 style="font-size: small">Địa chỉ: <%=lists.get(0).getThongtinkhachhang().getDiachi().getSonha()+" "+lists.get(0).getThongtinkhachhang().getDiachi().getDuong()+" "+lists.get(0).getThongtinkhachhang().getDiachi().getPhuong()+" "+
                lists.get(0).getThongtinkhachhang().getDiachi().getQuan()+" "+lists.get(0).getThongtinkhachhang().getDiachi().getTinh()%></h4>
        <h4 style="font-size: small">Ngày sinh: <%=lists.get(0).getThongtinkhachhang().getNgaysinh()%></h4>
        <h4 style="font-size: small">Số điện thoại: <%=lists.get(0).getThongtinkhachhang().getDienthoai()%></h4>
        <h4 style="font-size: small">Email: <%=lists.get(0).getThongtinkhachhang().getEmail()%></h4>

        <%if(hoadon.getIsthanhtoan()==1){%>
        <h4 style="color: red">Trạng thái: Đã thanh toán </h4>
        <%}%>

        <%if(hoadon.getIsthanhtoan()==0){%>
        <h4 style="color: red">Trạng thái: Chưa thanh toán </h4>
        <%}%>

        <% for(int i = 0 ; i < listBuoidatsan.size();i++){ String ten = listBuoidatsan.get(i).getTen(); %>
        <h4> <%=listBuoidatsan.get(i).getTen()%> </h4>

        <table id="main" style="text-align: center;" border="1">
            <tr>

                <th style="padding: 20px">Mã sản phẩm</th>
                <th style="padding: 20px">Tên sản phẩm</th>
                <th style="padding: 20px">Đơn giá</th>
                <th style="padding: 20px">Số lượng</th>
                <th style="padding: 20px">Tổng tiền</th>
                <th style="padding: 20px">Chức năng</th>
            </tr>

            <% for(int j = 0; j < listDv.size(); j++){
                if(listDv.get(j).getTenbuoi().equals(ten)){
            %>
            <tr>
                <th style="padding: 20px"><%= listDv.get(j).getMadichvu()%></th>
                <th style="padding: 20px"><%= listDv.get(j).getTen()%></th>
                <th style="padding: 20px"><%= String.format("%.0f", listDv.get(j).getDongia())%></th>
                <th style="padding: 20px"><%= listDv.get(j).getSoluong()%></th>
                <th style="padding: 20px"><%= String.format("%.0f", listDv.get(j).getTongtien())%></th>
                <th style="padding: 10px"><a href="xoadichvu.jsp?bds_id=<%=listBuoidatsan.get(i).getId()%>&tiensan=<%=tiensan%>&id_dv=<%=listDv.get(j).getId()%>&id_kh=<%=id_kh%>&id_pds=<%=id_pds%>"style="color: red">Xóa</a>,
                    <a href="updatedichvu.jsp?id_bds=<%=listBuoidatsan.get(i).getId()%>&tiensan=<%=tiensan%>&id_dv=<%=listDv.get(j).getId()%>&dongia=<%=listDv.get(j).getDongia()%>&id_kh=<%=id_kh%>&id_pds=<%=id_pds%>"style="color: red">Cập nhật</a>
                </th>
            </tr>
            <% }} %>
        </table>
        <%}%>
        <h4>Tổng số tiền cần thanh toán: <%=String.format("%.0f", tongsotien = tongsotien+tiensan)%> đồng</h4>
        <a href="dothanhtoan.jsp?id_hoadon=<%=hoadon.getId()%>&tongsotien=<%=tongsotien%>" style="padding: 5px;">Thanh toán</a>
    </div>

</body>
</html>
