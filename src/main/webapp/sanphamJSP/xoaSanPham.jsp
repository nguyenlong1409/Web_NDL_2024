<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/2/2024
  Time: 12:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <div class="text-center"><h3>Thay đổi thông tin sản phẩm</h3></div>
    <form class="form" action="<%=url1%>/san-pham" method="post">
        <input type="hidden" name="hanhDongSP" value="xoa-san-pham"/>
        <div class="mb-3">
            <label for="maSanPham" class="form-label">Mã sản phẩm</label>
            <input type="text" class="form-control" id="maSanPham" name="maSanPham" >
        </div>
        <div class="mb-3">
            <label for="tenSanPham" class="form-label">Tên sản phẩm</label>
            <input type="text" class="form-control" id="tenSanPham" name="tenSanPham">
        </div>
        <div class="mb-3">
            <label for="tenTacGia" class="form-label">Tên tác giả</label>
            <input type="text" class="form-control" id="tenTacGia" name="tenTacGia" >
        </div>
        <div class="mb-3">
            <label for="namXuatBan" class="form-label">Nam xuat ban</label>
            <input type="text" class="form-control" id="namXuatBan" name="namXuatBan" >
        </div>
        <div class="mb-3">
            <label for="giaNhap" class="form-label">Gia nhap</label>
            <input type="text" class="form-control" id="giaNhap" name="giaNhap" >
        </div>
        <div class="mb-3">
            <label for="giaGoc" class="form-label">Gia goc</label>
            <input type="text" class="form-control" id="giaGoc" name="giaGoc" >
        </div>
        <div class="mb-3">
            <label for="giaBan" class="form-label">Gia ban</label>
            <input type="text" class="form-control" id="giaBan" name="giaBan" >
        </div>
        <div class="mb-3">
            <label for="soLuong" class="form-label">So luong</label>
            <input type="text" class="form-control" id="soLuong" name="soLuong" >
        </div>
        <div class="mb-3">
            <label for="theLoai" class="form-label">The loai</label>
            <input type="text" class="form-control" id="theLoai" name="theLoai" >
        </div>
        <div class="mb-3">
            <label for="moTa" class="form-label">Mo ta</label>
            <input type="text" class="form-control" id="moTa" name="moTa" >
        </div>
        <div class="mb-3">
            <label for="ngonNgu" class="form-label">Ngon ngu</label>
            <input type="text" class="form-control" id="ngonNgu" name="ngonNgu" >
        </div>

        <input class="btn btn-primary form-control" type="submit" value="Lưu thông tin" name="submit" id="submit"/>
    </form>
</div>
</body>
</html>
