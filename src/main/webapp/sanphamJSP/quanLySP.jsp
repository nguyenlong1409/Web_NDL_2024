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
<%
    String urlpage = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                  + request.getContextPath();
%>
<%--<%@include file="../header.jsp"%>--%>
<jsp:include page="../header.jsp"></jsp:include>
<!-- End Header-->
<%
    SanPhamDAO sanPhamDAO2 = new SanPhamDAO();
    ArrayList<SanPham> arrayListQLSP = sanPhamDAO2.chonTatCa();
    request.setAttribute("danhSach", arrayListQLSP);
%>

<h3>Thông tin tất cả sản phẩm</h3>
<h5><a href="themSanPham.jsp">Thêm sản phẩm</a> </h5>
<table class="table" style=" width: 90%; margin: auto;">
    <thead>
    <tr>
        <th></th>
        <th style="font-size: 13px">Mã sản phẩm</th>
        <th style="font-size: 13px">Tên sản phẩm</th>
        <th style="font-size: 13px">Tác giả</th>
        <th style="font-size: 13px">Năm xuất bản</th>
        <th style="font-size: 13px">Giá nhập</th>
        <th style="font-size: 13px">Giá gốc</th>
        <th style="font-size: 13px">Giá bán</th>
        <th style="font-size: 13px">Số lượng</th>
        <th style="font-size: 13px">Thể loại</th>
        <th style="font-size: 13px">Ngôn ngữ</th>
        <th style="font-size: 13px">Mô tả</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${requestScope.danhSach}" var="sp">
        <tr>
            <td>
                <img src="<%= urlpage%>/image/product/${sp.anhSP}" width="60px" ">
            </td>
            <td style="font-size: 12px">${sp.maSanPham}</td>
            <td style="font-size: 12px">${sp.tenSanPham}</td>
            <td style="font-size: 12px"${sp.tacGia.tenTacGia}</td>
            <td style="font-size: 12px">${sp.namXuatBan}</td>
            <td style="font-size: 12px">${sp.giaNhap}</td>
            <td style="font-size: 12px">${sp.giaGoc}</td>
            <td style="font-size: 12px">${sp.giaBan}</td>
            <td style="font-size: 12px">${sp.soLuong}</td>
            <td style="font-size: 12px">${sp.theLoai.tenTheLoai}</td>
            <td style="font-size: 12px">${sp.ngonNgu}</td>
            <td style="font-size: 12px">${sp.moTa}</td>
            <td>
                <a class="btn btn-primary btn-sm"
                   href="suaSanPham.jsp?maSanPhamSua=${sp.maSanPham}">Sửa</a>
            </td>
        </tr>
    </c:forEach>
</table>

<!-- Footer -->
<%@ include file="../footer.jsp"%>
<!-- End Footer -->

</body>
</html>
