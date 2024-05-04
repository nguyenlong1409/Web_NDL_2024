<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/3/2024
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table class="table" style="font-size: 14px; width: 80%; margin: auto;">
    <thead>
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Tác giả</th>
        <th>Năm xuất bản</th>
        <th>Giá bán</th>
        <th>Số lượng</th>
        <th>Thể loại</th>
        <th>Ngôn ngữ</th>
        <th>Mô tả</th>
    </tr>
    </thead>
    <c:forEach items="${requestScope.SPbymaTheLoai}" var="sanPhamDAO3">
        <tr>
            <td>${sanPhamDAO3.maSanPham}</td>
            <td>${sanPhamDAO3.tenSanPham}</td>
            <td>${sanPhamDAO3.maTacGia}</td>
            <td>${sanPhamDAO3.namXuatBan}</td>
            <td>${sanPhamDAO3.giaBan}</td>
            <td>${sanPhamDAO3.soLuong}</td>
            <td>${sanPhamDAO3.theLoai.tenTheLoai}</td>
            <td>${sanPhamDAO3.moTa}</td>
            <td>${sanPhamDAO3.ngonNgu}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
