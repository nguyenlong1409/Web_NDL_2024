<%@ page import="Model.SanPham" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.SanPhamDAO" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/1/2024
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Tất cả sản phẩm</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width-device-width, initial-scale=1, shink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
</head>
<body>
<%
    String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                  + request.getContextPath();
%>
<%--<div class="all-classes-container">--%>
<%--    <form class="form" action="<%=url1%>/san-pham" method="post">--%>
<%--        <input type="hidden" name="hanhDongSP" value="danh-sach-san-pham"/>--%>
<%--        <input class="btn btn-primary form-control" type="submit" value="Thông tin sản phẩm"--%>
<%--               name="submit" id="submit"/>--%>
<%--        </a> <br>--%>
<%--</div>--%>


<h3>Thông tin tất cả sản phẩm</h3>
<h5><a href="themSanPham.jsp">Thêm sản phẩm</a> </h5>
<h5><a href="suaSanPham.jsp">Sửa sản phẩm</a> </h5>
<table class="table" style="font-size: 14px; width: 80%; margin: auto;">
    <thead>
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Tác giả</th>
        <th>Năm xuất bản</th>
        <th>Giá nhập</th>
        <th>Giá gốc</th>
        <th>Giá bán</th>
        <th>Số lượng</th>
        <th>Thể loại</th>
        <th>Ngôn ngữ</th>
        <th>Mô tả</th>
    </tr>
    </thead>
    <c:forEach items="${requestScope.danhSach}" var="sanPhamDAO2">
        <c:set var="maSanPham" value="${sanPhamDAO.maSanPham}"/>
        <tr>
            <td>${maSanPham}</td>
            <td>${sanPhamDAO2.tenSanPham}</td>
            <td>${sanPhamDAO2.maTacGia}</td>
            <td>${sanPhamDAO2.namXuatBan}</td>
            <td>${sanPhamDAO2.giaNhap}</td>
            <td>${sanPhamDAO2.giaGoc}</td>
            <td>${sanPhamDAO2.giaBan}</td>
            <td>${sanPhamDAO2.soLuong}</td>
            <td>${sanPhamDAO2.theLoai.tenTheLoai}</td>
            <td>${sanPhamDAO2.moTa}</td>
            <td>${sanPhamDAO2.ngonNgu}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
