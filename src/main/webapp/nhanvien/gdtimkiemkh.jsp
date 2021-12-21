<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.ArrayList,com.btap.cnpm_pttk.dao.*,
         com.btap.cnpm_pttk.model.*"%>
<html>
<head>
    <title>Tìm kiếm nhân viên</title>
</head>
<body>

    <div style="text-align: center">
        <h1> Tìm kiếm khách hàng </h1>
        <h3>Nhập tên khách hàng: </h3>
        <form action="gddanhsachkh.jsp" style="margin: 0 auto">
            <input type="text" name="tenkh" id="tenkh" >
            <input type="submit" value="Tìm kiếm">
        </form>

        <form action="gdchinhnv.jsp" style="margin-top: 15px">
            <input type="submit" value="Quay lại">
        </form>

    </div>

</body>
</html>
