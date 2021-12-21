<%@ page import="com.btap.cnpm_pttk.dao.HoadonDAO" %><%--
  Created by IntelliJ IDEA.
  User: VietMD
  Date: 12/19/2021
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%  int id_dv = Integer.parseInt((String)request.getParameter("id_dv"));
        float dongia = Float.parseFloat((String)request.getParameter("dongia"));
        int id_kh = Integer.parseInt((String)request.getParameter("id_kh"));
        int id_pds = Integer.parseInt((String)request.getParameter("id_pds"));
        int soluong = Integer.parseInt((String)request.getParameter("soluong"));
        float tiensan = Float.parseFloat((String)request.getParameter("tiensan"));
        int id_bds = Integer.parseInt((String)request.getParameter("id_bds"));

        HoadonDAO hoadonDAO = new HoadonDAO();
        boolean check = hoadonDAO.capnhatMH(id_dv,soluong,dongia);
        float tongtien = hoadonDAO.getTongTienDichVuByBuoiDatSanId(id_bds);
        boolean check2 = hoadonDAO.capnhatBDS(tongtien,id_bds);

        if(check && check2){
            request.setAttribute("id_kh",id_kh);
            request.setAttribute("id_pds",id_pds);
            request.setAttribute("tiensan",tiensan);
            request.getRequestDispatcher("gdthanhtoan.jsp").forward(request, response);
        }

    %>
</body>
</html>
