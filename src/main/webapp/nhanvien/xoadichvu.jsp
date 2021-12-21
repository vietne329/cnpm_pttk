<%@ page import="com.btap.cnpm_pttk.dao.HoadonDAO" %><%--
  Created by IntelliJ IDEA.
  User: VietMD
  Date: 12/18/2021
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% int id_kh = Integer.parseInt((String)request.getParameter("id_kh"));
        int id_pds = Integer.parseInt((String)request.getParameter("id_pds"));
        int id_dv =Integer.parseInt((String)request.getParameter("id_dv"));
        float tiensan = Float.parseFloat((String)request.getParameter("tiensan"));
        int id_bds = Integer.parseInt((String)request.getParameter("bds_id"));


        HoadonDAO hoadonDAO = new HoadonDAO();
        boolean check = hoadonDAO.xoaMH(id_dv);
        float tongtien = hoadonDAO.getTongTienDichVuByBuoiDatSanId(id_bds);
        boolean check2 = hoadonDAO.capnhatBDS(tongtien,id_bds);

        if(check && check2){
            request.setAttribute("tiensan",tiensan);
            request.setAttribute("id_kh",id_kh);
            request.setAttribute("id_pds",id_pds);
            request.getRequestDispatcher("gdthanhtoan.jsp").forward(request, response);
        }
    %>
</body>
</html>
