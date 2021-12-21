<%--
  Created by IntelliJ IDEA.
  User: VietMD
  Date: 12/18/2021
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật mặt hàng</title>
</head>
<body>
    <% int id_dv = Integer.parseInt((String)request.getParameter("id_dv"));
       float dongia = Float.parseFloat((String)request.getParameter("dongia"));
        int id_kh = Integer.parseInt((String)request.getParameter("id_kh"));
        int id_pds = Integer.parseInt((String)request.getParameter("id_pds"));
        float tiensan = Float.parseFloat((String)request.getParameter("tiensan"));
        int id_bds = Integer.parseInt((String)request.getParameter("id_bds"));
    %>
    <div>
        <h2 style="text-align: center">CẬP NHẬT MẶT HÀNG</h2>
        <br>
        <form style="margin: 0 auto;" name="capnhatdv" action="docapnhatdv.jsp" method="get">
            <table style="margin: 0 auto;" border="0">
                <tr>
                    <td>Số lượng:</td>
                    <td><input type="text" name="soluong" id="soluong"
                               required /></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="id_dv" id="id_dv" value="<%=id_dv%>" /></td>
                    <td><input type="hidden" name="dongia" id="dongia" value="<%=dongia%>"/></td>
                    <td><input type="hidden" name="id_kh" id="id_kh" value="<%=id_kh%>"/></td>
                    <td><input type="hidden" name="id_pds" id="id_pds" value="<%=id_pds%>"/></td>
                    <td><input type="hidden" name="tiensan" id="tiensan" value="<%=tiensan%>"/></td>
                    <td><input type="hidden" name="id_bds" id="id_bds" value="<%=id_bds%>"/></td>
                    <td><input type="submit" value="Cập nhật" /></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
