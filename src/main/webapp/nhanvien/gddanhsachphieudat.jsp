<%@page import="java.util.ArrayList" %>
<%@ page import="com.btap.cnpm_pttk.model.*" %>
<%@ page import="com.btap.cnpm_pttk.dao.PhieudatsanDAO" %>
<%@ page import="com.btap.cnpm_pttk.dao.HoadonDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách phiếu đặt</title>
</head>
<body>

    <div style="text-align: center">
        <h2>DANH SÁCH PHIẾU ĐẶT </h2>
        <%  int id_kh = Integer.parseInt((String)request.getParameter("id_kh"));
            PhieudatsanDAO dao = new PhieudatsanDAO();
            ArrayList<Phieudatsan> lists = dao.getPhieudatsan(id_kh);
        %>
        <table style="margin: 0 auto" id="main" style="text-align: center;margin-top: 20px; margin-left: 30px;" border="1">
            <tr>
                <th style="padding: 20px">Thông tin khách hàng</th>
                <th style="padding: 20px">Ngày làm hợp đồng</th>
                <th style="padding: 20px">Ngày kết thúc hợp đồng</th>
                <th style="padding: 20px">Khung giờ thuê</th>
                <th style="padding: 10px">Thông tin chủ sân</th>
                <th style="padding: 10px">Thông tin sân đặt</th>
                <th style="padding: 10px">Thông tin buổi đặt</th>
                <th style="padding: 10px">Tổng tiền thuê sân dự kiến</th>
                <th style="padding: 20px">Chức năng</th>
            </tr>
            <% float tongtienthuesandukien = 0; %>
            <% for(int i = 0 ; i < lists.size(); i++){
                ArrayList<Sanbong> listSB;
                ArrayList<Buoidatsan> listBDS;
                HoadonDAO hoadonDAO = new HoadonDAO();
                listBDS = hoadonDAO.getDsbuoidatsan(id_kh,lists.get(i).getId());
                listSB = hoadonDAO.getDsSanBong(id_kh,lists.get(i).getId());
                session.setAttribute("kh"+lists.get(i).getThongtinkhachhang().getId(),lists.get(i).getThongtinkhachhang());
                session.setAttribute("cs"+lists.get(i).getThongtinchusan(),lists.get(i).getThongtinchusan());
                session.setAttribute("pds"+lists.get(i).getId(),lists.get(i));
                String hoten_kh = lists.get(i).getThongtinkhachhang().getTen().getHo()+" "+lists.get(i).getThongtinkhachhang().getTen().getDem()+" "+
                        lists.get(i).getThongtinkhachhang().getTen().getTen();

                String diachi_kh = lists.get(i).getThongtinkhachhang().getDiachi().getSonha() + " "+lists.get(i).getThongtinkhachhang().getDiachi().getDuong()
                        +" "+lists.get(i).getThongtinkhachhang().getDiachi().getPhuong()+" "+lists.get(i).getThongtinkhachhang().getDiachi().getQuan()+" "+
                        lists.get(i).getThongtinkhachhang().getDiachi().getTinh();

                float tiensan = 0;
                int sobuoi= 0;
            %>
            <tr>
                <th style="padding: 5px"><%="Tên: "+hoten_kh+" <br>Địa chỉ: "+diachi_kh+" <br>SDT: "+lists.get(i).getThongtinkhachhang().getDienthoai()+" <br>Email: "+lists.get(i).getThongtinkhachhang().getEmail()+" <br>Ngày sinh: "+
                        lists.get(i).getThongtinkhachhang().getNgaysinh()%></th>
                <th style="padding: 5px"><%=lists.get(i).getNgaylamhopdong()%></th>
                <th style="padding: 5px"><%= lists.get(i).getNgayketthuc() %></th>
                <th style="padding: 5px"><%= lists.get(i).getKhunggiothue() %></th>
                <th style="padding: 5px"><%= "Tên: "+lists.get(i).getThongtinchusan().getTenchusan()+" <br>Ngày sinh: "+lists.get(i).getThongtinchusan().getNgaysinh()+" <br>Địa chỉ: "+lists.get(i).getThongtinchusan().getDiachi()
                        +" <br>Email: "+lists.get(i).getThongtinchusan().getEmail()+" <br>SDT: "+lists.get(i).getThongtinchusan().getDienthoai()%></th>
                <th style="padding: 5px"> <% for(int j = 0 ; j <listSB.size();j++){ tiensan += listSB.get(j).getGia(); %><%="Tên: "+listSB.get(j).getTen()+"<br> Giá:"+String.format("%.0f",listSB.get(j).getGia())+" đồng<br>Mô tả: "+
                listSB.get(j).getMota()+"<br>"%><%}%></th>

                <th style="padding: 5px"> <% for(int j = 0 ; j <listBDS.size();j++){ sobuoi++; %><%="- Tên: "+listBDS.get(j).getTen()+"- Ngày:"+listBDS.get(j).getNgay()+"<br>"%><%}%></th>

                <th style="padding: 10px"> <%=String.format("%.0f",tongtienthuesandukien = tiensan*sobuoi)%> đồng </th>

                <th style="padding: 5px"><a href="gdthanhtoan.jsp?id_kh=<%=lists.get(i).getThongtinkhachhang().getId()%>&id_pds=<%=lists.get(i).getId()%>&tiensan=<%=tongtienthuesandukien%>"style="color: red">Thanh toán</a> </th>
            </tr>
            <%}%>
        </table>

        <form style="margin-top: 15px" action="gddanhsachkh.jsp" method="get">
            <input type="hidden" name="tenkh" value="<%=lists.get(0).getThongtinkhachhang().getTen().getTen()%>" />
            <input type="submit" value="Quay lại">
        </form>

    </div>

</body>
</html>
