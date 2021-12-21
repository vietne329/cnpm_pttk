<%@ page import="com.btap.cnpm_pttk.dao.HoadonDAO" %>
<%@ page import="com.btap.cnpm_pttk.model.Hoadon" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int id_hoadon = Integer.parseInt((String)request.getParameter("id_hoadon"));
    float tongsotien = Float.parseFloat((String)request.getParameter("tongsotien"));
    HoadonDAO hoadonDAO = new HoadonDAO();
    Hoadon hoadon = (Hoadon) session.getAttribute("hoadon");
    hoadon.setTongsotien(tongsotien);
    try {
        boolean check = hoadonDAO.thanhtoan(hoadon);
        if(check){
            response.sendRedirect("gdchinhnv.jsp");
        }else{
            response.sendRedirect("gdthanhtoan.jsp");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
%>