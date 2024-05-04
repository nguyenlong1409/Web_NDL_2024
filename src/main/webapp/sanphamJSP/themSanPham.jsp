<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/2/2024
  Time: 12:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width-device-width, initial-scale=1, shink-to-fit=no">
    <title>Thêm sản phẩm</title>
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
    String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                  + request.getContextPath();
%>

<div class="container">
    <div class="text-center"><h3>Thêm sản phẩm</h3></div>
    <form class="form" action="<%=url1%>/san-pham" method="post">
        <input type="hidden" name="hanhDongSP" value="them-san-pham" />
        <div class="mb-3">
            <label for="maSanPham" class="form-label">Mã sản phẩm</label>
            <input type="text" class="form-control" id="maSanPham" name="maSanPham" >
        </div>
        <div class="mb-3">
            <label for="tenSanPham" class="form-label">Tên sản phẩm</label>
            <input type="text" class="form-control" id="tenSanPham" name="tenSanPham">
        </div>
        <div class="mb-3">
            <label for="maTacGia" class="form-label">Mã tác giả</label>
            <input type="text" class="form-control" id="maTacGia" name="maTacGia" >
        </div>
        <div class="mb-3">
            <label for="namXuatBan" class="form-label">Năm xuất bản</label>
            <input type="text" class="form-control" id="namXuatBan" name="namXuatBan" >
        </div>
        <div class="mb-3">
            <label for="giaNhap" class="form-label">Giá nhập</label>
            <input type="text" class="form-control" id="giaNhap" name="giaNhap" >
        </div>
        <div class="mb-3">
            <label for="giaGoc" class="form-label">Giá gốc</label>
            <input type="text" class="form-control" id="giaGoc" name="giaGoc" >
        </div>
        <div class="mb-3">
            <label for="giaBan" class="form-label">Giá bán</label>
            <input type="text" class="form-control" id="giaBan" name="giaBan" >
        </div>
        <div class="mb-3">
            <label for="soLuong" class="form-label">Số lượng</label>
            <input type="text" class="form-control" id="soLuong" name="soLuong" >
        </div>
        <div class="mb-3">
            <label for="maTheLoai" class="form-label">Thể loại</label>
            <input type="text" class="form-control" id="maTheLoai" name="maTheLoai" >
        </div>
        <div class="mb-3">
            <label for="moTa" class="form-label">Mô tả</label>
            <input type="text" class="form-control" id="moTa" name="moTa" >
        </div>
        <div class="mb-3">
            <label for="ngonNgu" class="form-label">Ngôn ngữ</label>
            <input type="text" class="form-control" id="ngonNgu" name="ngonNgu" >
        </div>
        <input class="btn btn-primary form-control" type="submit" value="Lưu thông tin" name="submit" id="submit"/>
    </form>
</div>
</body>
</html>
