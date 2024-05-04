<%@ page import="Model.KhachHang" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/24/2024
  Time: 4:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width-device-width, initial-scale=1, shink-to-fit=no">
    <title>Thay đổi thông tin</title>
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
    if (obj != null) {
        khachHang = (KhachHang) obj;
    }

    if (khachHang == null) {
%>
<h2>Bạn chưa đăng nhập. <br/> <a href="../index.jsp">Quay lại trang chủ</a></h2>

<%
    } else {
%>

<div class="container">
    <%
        String baoLoi = request.getAttribute("baoLoi") + "";
        baoLoi = (baoLoi.equals("null")) ? "" : baoLoi;

        String hoVaTen = khachHang.getHoVaTen();
        String gioiTinh = khachHang.getGioiTinh();
        String ngaySinh = khachHang.getNgaySinh().toString();
        String diaChi = khachHang.getDiaChi();
        String diaChiMuaHang = khachHang.getDiaChiMuaHang();
        String diaChiNhanHang = khachHang.getDiaChiNhanHang();
        String soDienThoai = khachHang.getSoDienThoai();
        String email = khachHang.getEmail();
        boolean nhanEmail = khachHang.isDangKyNhanBangTin();
    %>

    <%
        String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                     + request.getContextPath();
    %>

    <div class="container">
        <div class="text-center"><h3>Thay đổi thông tin</h3></div>
        <form class="form" action="<%=url1%>/khach-hang" method="post">
            <input type="hidden" name="hanhDong" value="thay-doi-thong-tin"/>
            <div class="col-sm-6">
                <h4>Thông tin đăng ký</h4>
                <div class="mb-3">
                    <label for="hoVaTen" class="form-label">Họ và Tên</label>
                    <input type="text" class="form-control" id="hoVaTen" name="hoVaTen" value="<%= hoVaTen%>">
                </div>
                <div class="mb-3">
                    <label for="gioiTinh" class="form-label">Giới tính</label>
                    <select class="form-control" id="gioiTinh" name="gioiTinh">
                        <option></option>
                        <option value="Nam" <%= (gioiTinh == "Nam") ? "selected='selected'" : ""%> >Nam</option>
                        <option value="Nữ" <%= (gioiTinh == "Nữ") ? "selected='selected'" : ""%> >Nữ</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="ngaySinh" class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="<%= ngaySinh %>"
                           required="required">
                </div>
                <hr/>
                <h4>Địa chỉ</h4>
                <div class="mb-3">
                    <label for="diaChi" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" id="diaChi" name="diaChi" value="<%= diaChi %>">
                </div>
                <div class="mb-3">
                    <label for="diaChiNhanHang" class="form-label">Địa chỉ nhận hàng</label>
                    <input type="text" class="form-control" id="diaChiNhanHang" name="diaChiNhanHang"
                           value="<%= diaChiNhanHang %>">
                </div>
                <div class="mb-3">
                    <label for="diaChiMuaHang" class="form-label">Địa chỉ mua hàng</label>
                    <input type="text" class="form-control" id="diaChiMuaHang" name="diaChiMuaHang"
                           value="<%= diaChiMuaHang %>">
                </div>
                <div class="mb-3">
                    <label for="soDienThoai" class="form-label">Số điện thoại</label>
                    <input type="tel" class="form-control" id="soDienThoai" name="soDienThoai"
                           value="<%= soDienThoai %>">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">email</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%= email %>">
                </div>
                <div class="mb-3">
                    <label for="nhanEmail" class="form-label">Nhận Email</label>
                    <input type="checkbox" class="form-check-inputl" id="nhanEmail" name="nhanEmail" <%=(nhanEmail?"checked":"")%> >
                </div>
                <input class="btn btn-primary form-control" type="reset" value="reset" name="reset" id="reset"/>
            </div>
            <hr/>
            <input class="btn btn-primary form-control" type="submit" value="Lưu thông tin" name="submit" id="submit"/>
        </form>
    </div>
</div>
<% } %>

</body>
</html>
