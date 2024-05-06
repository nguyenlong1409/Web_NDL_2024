<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/6/2024
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>

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

<h3 style="text-align: center">Kết quả cho ${giaTriTK}</h3>
<table class="table" style="font-size: 14px; width: 80%; margin: auto;">
    <thead>
    <tr>
        <th>Tên sản phẩm</th>
        <th>Tác giả</th>
        <th>Năm xuất bản</th>
        <th>Giá bán</th>
        <th>Số lượng</th>
        <th>Thể loại</th>
        <th>Mô tả</th>
    </tr>
    </thead>
    <c:forEach items="${requestScope.ketQuaTKTimKiem}" var="sp">
        <tr>
            <td><a href="thong-tin?tenSanPham_raw=${sp.tenSanPham}"> ${sp.tenSanPham}</a></td>
            <td>${sp.tacGia.tenTacGia}</td>
            <td>${sp.namXuatBan}</td>
            <td>${sp.giaBan}</td>
            <td>${sp.soLuong}</td>
            <td>${sp.theLoai.tenTheLoai}</td>
            <td>${sp.moTa}</td>
        </tr>
    </c:forEach>
</table>


<!-- Footer -->
<%@ include file="../footer.jsp"%>
<!-- End Footer -->

</body>
</html>
