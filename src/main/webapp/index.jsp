<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dang nhap</title>
</head>
<body>
<div style="text-align: center;">
    <h1 style="margin-bottom: 20px"> ĐĂNG NHẬP </h1>
    <form style="margin: 0 auto;" name="dangnhap" action="dodangnhap.jsp" method="post">
        <table style="margin: 0 auto;" border="0">
            <tr>
                <td>Tên đăng nhập:</td>
                <td><input type="text" name="username" id="username"
                           required /></td>
            </tr>
            <tr>
                <td>Mật khẩu:</td>
                <td><input type="password" name="password" id="password"
                           required /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Đăng nhập" /></td>
            </tr>
        </table>
    </form>



</div>

</body>
</html>
</body>
</html>