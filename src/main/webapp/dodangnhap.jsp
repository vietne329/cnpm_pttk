<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.ArrayList,com.btap.cnpm_pttk.dao.*,com.btap.cnpm_pttk.model.*"%>
<%
    String username = (String)request.getParameter("username");
    String password = (String)request.getParameter("password");
    Thanhvien tv = new Thanhvien();

    tv.setUsername(username);
    tv.setPassword(password);
    ThanhvienDAO dao = new ThanhvienDAO();
    boolean kq = dao.checkLogin(tv);
    if(kq && (tv.getVaitro().equalsIgnoreCase("nv"))){
        session.setAttribute("nv", tv);
        response.sendRedirect("nhanvien\\gdchinhnv.jsp");
    }else if(kq &&(tv.getVaitro().equalsIgnoreCase("ql"))){
        session.setAttribute("ql", tv);
        response.sendRedirect("quanly\\gdchinhql.jsp");
    }else{
        response.sendRedirect("gddangnhap.jsp?err=fail");
    }
%>
