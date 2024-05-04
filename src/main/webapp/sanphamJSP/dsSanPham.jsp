<%@ page import="database.SanPhamDAO" %>
<%@ page import="Model.SanPham" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/3/2024
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3 style="text-align: center">Danh mục Sách</h3>
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
    <c:forEach items="${requestScope.SPbymaTheLoai}" var="sp">
        <tr>
            <td>${sp.maSanPham}</td>
            <td>${sp.tenSanPham}</td>
            <td>${sp.maTacGia}</td>
            <td>${sp.namXuatBan}</td>
            <td>${sp.giaBan}</td>
            <td>${sp.soLuong}</td>
            <td>${sp.theLoai.tenTheLoai}</td>
            <td>${sp.ngonNgu}</td>
            <td>${sp.moTa}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
