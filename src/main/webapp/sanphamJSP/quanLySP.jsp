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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>
</head>
<body>
<!-- Header-->
<%--<%@include file="../header.jsp"%>--%>
<%--<jsp:include page="../header.jsp"></jsp:include>--%>
<!-- End Header-->

<%
    SanPhamDAO sanPhamDAO2 = new SanPhamDAO();
    ArrayList<SanPham> arrayListQLSP = sanPhamDAO2.selectAll();
    request.setAttribute("danhSach", arrayListQLSP);
%>

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
    <c:forEach items="${requestScope.danhSach}" var="sp">
        <c:set var="maSanPham" value="${sp.maSanPham}"/>
        <tr>
            <td>${maSanPham}</td>
            <td>${sp.tenSanPham}</td>
            <td>${sp.tacGia.tenTacGia}</td>
            <td>${sp.namXuatBan}</td>
            <td>${sp.giaNhap}</td>
            <td>${sp.giaGoc}</td>
            <td>${sp.giaBan}</td>
            <td>${sp.soLuong}</td>
            <td>${sp.theLoai.tenTheLoai}</td>
            <td>${sp.ngonNgu}</td>
            <td>${sp.moTa}</td>
        </tr>
    </c:forEach>
</table>

<button onclick="goToHomePage()">Quay Về Trang Chủ</button>

<!-- Footer -->
<%@ include file="../footer.jsp"%>
<!-- End Footer -->

</body>
<script>
    function goToHomePage() {
        window.location.href = 'http://localhost:8080/BookWeb/';
    }
</script>
</html>
