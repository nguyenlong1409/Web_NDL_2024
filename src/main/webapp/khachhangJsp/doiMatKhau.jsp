<%@ page import="Model.KhachHang" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/25/2024
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width-device-width, initial-scale=1, shink-to-fit=no">
    <title>Đổi mật khẩu</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>
</head>
<body>

    <%
        Object obj = session.getAttribute("khachHang");
        KhachHang khachHang = null;
        if (obj!=null){
            khachHang = (KhachHang)obj;
        }

        if(khachHang==null){
    %>
    <h2>Bạn chưa đăng nhập. <br/>  <a href="../index.jsp">Quay lại trang chủ</a> </h2>

    <%
        } else {
            String baoLoi = request.getAttribute("baoLoi") + "";
            if (baoLoi.equals("null")) {
                baoLoi = "";
            }
    %>

    <%
        String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                     + request.getContextPath();
    %>

    <div class="container">
    <h3 class="text-center">Đổi mật khẩu</h3>
    <span style="color: red">
        <%=baoLoi%>
    </span>
            <form class="text-center" style="width:200" action="<%=url1%>/khach-hang" method="post">
                <input type="hidden"name="hanhDong" value="doi-mat-khau"/>
                <div class="form-group">
                    <label for="matKhauHienTai">Mật khẩu hiện tại</label>
                    <input type="password" class="form-control" id="matKhauHienTai"  name="matKhauHienTai" required="required">
                </div>
                <div class="form-group">
                    <label for="matKhauMoi">Mật khẩu mới</label>
                    <input type="password" class="form-control" id="matKhauMoi" placeholder="Password" name="matKhauMoi" required="required">
                </div>
                <div class="form-group">
                    <label for="matKhauMoiNhapLai">Xác nhận lại mật khẩu</label>
                    <input type="password" class="form-control" id="matKhauMoiNhapLai" placeholder="Password" name="matKhauMoiNhapLai" required="required" onkeyup="checkPasschange()">
                </div>
                <button type="submit" class="btn btn-primary" name="submit" id="submit">Xác nhận</button>
            </form>
    </div>
    <a href="../index.jsp" >Quay lại</a>
    <%          } %>

</body>
    <script>
        function checkPasschange() {
            matKhauNhapLai = document.getElementById("matKhauNhapLai").value;
            matKhauMoi = document.getElementById("matKhauMoi").value;
            if (matKhauNhapLai!= matKhauMoi) {
                document.getElementById("msg1").innerHTML = "Mật khẩu không khớp";
                return false;
            } else {
                document.getElementById("msg1").innerHTML = "";
                return true;
            }
        }
    </script>
</html>
