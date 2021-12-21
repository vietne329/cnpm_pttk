<%@ page import="com.btap.cnpm_pttk.model.Khachhang" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="com.btap.cnpm_pttk.dao.KhachhangDAO" %>
<%@ page import="com.btap.cnpm_pttk.model.Hoten" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
</head>
<body>

    <div style="text-align: center">
        <h2>DANH SÁCH KHÁCH HÀNG</h2>
        <%  String name_search = (String)request.getParameter("tenkh");
            session.setAttribute("tenkh",name_search);
            Khachhang kh = new Khachhang();
            Hoten hoten = new Hoten();
            hoten.setTen(name_search);
            kh.setTen(hoten);
            KhachhangDAO khachhangDAO = new KhachhangDAO();
            ArrayList<Khachhang> lists = khachhangDAO.getKhachhangtheoten(kh);
        %>
        <table style="margin: 0 auto" id="main" style="margin-top: 20px;" border="1">
            <tr>
                <th style="padding: 20px">ID</th>
                <th style="padding: 20px">Tên khách hàng</th>
                <th style="padding: 20px">Email</th>
                <th style="padding: 20px">Ngày sinh</th>
                <th style="padding: 20px">Địa chỉ</th>
                <th style="padding: 20px">Số điện thoại</th>
            </tr>

                <% for(int i = 0 ; i < lists.size(); i++){
        String diachi = lists.get(i).getDiachi().getSonha() + " "+lists.get(i).getDiachi().getDuong()
                +" "+lists.get(i).getDiachi().getPhuong()+" "+lists.get(i).getDiachi().getQuan()+" "+
                lists.get(i).getDiachi().getTinh();

    %>
            <tr>
                <th style="padding: 10px"><%= lists.get(i).getId()%></th>
                <th style="padding: 10px"><a href="gddanhsachphieudat.jsp?id_kh=<%=lists.get(i).getId()%>"><%= lists.get(i).getTen().getHo() + " "+ lists.get(i).getTen().getDem() + " "+ lists.get(i).getTen().getTen()%></a></th>
                <th style="padding: 10px"><%= lists.get(i).getEmail() %></th>
                <th style="padding: 10px"><%= lists.get(i).getNgaysinh()%></th>
                <th style="padding: 10px"><%= diachi %></th>
                <th style="padding: 10px"><%= lists.get(i).getDienthoai()%></th>
            </tr>
                <%}%>
        </table>

        <form action="gdtimkiemkh.jsp" style="margin-top: 15px">
            <input style="size: 15px" type="submit" value="Quay lại">
        </form>
    </div>
</body>
</html>
