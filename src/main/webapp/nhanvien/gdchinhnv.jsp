<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.ArrayList,com.btap.cnpm_pttk.dao.*,
         com.btap.cnpm_pttk.model.*"%>

<html>
<head>
    <title>Trang chủ nhân viên</title>
</head>
<body>

    <div style="text-align: center">
        <h1 style="margin: 0 auto 20px;">TRANG CHỦ NHÂN VIÊN </h1>

        <% Thanhvien tv = (Thanhvien) session.getAttribute("nv");
            if(tv==null){
                response.sendRedirect("index.jsp?err=timeout");
            }else{
                tv.getTen().getTen();
            }
            assert tv != null;%>
        <h3 style="margin-bottom: 20px;" > Xin chào: <%=tv.getTen().getHo().toUpperCase() +" "+ tv.getTen().getDem().toUpperCase() +" "+ tv.getTen().getTen().toUpperCase()%> </h3>
        <h3> CHỨC NĂNG: </h3>

        <form style="margin: 0 auto;" action="gdtimkiemkh.jsp">
            <input style="padding: 5px" type="submit" value="Khách hàng thanh toán">
        </form>

        <form style="margin-top: 15px" action="../index.jsp">
            <input style="padding: 5px" type="submit" value="Đăng xuất">
        </form>

    </div>



</body>
</html>
