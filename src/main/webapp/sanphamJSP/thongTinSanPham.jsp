<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/6/2024
  Time: 1:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Thông tin sản phẩm</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông tin sách</title>
    <style>
        .book-container {
            width: 400px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #f9f9f9;
        }

        .book-header, .book-body, .book-footer {
            margin-bottom: 10px;
        }

        .book-header {
            font-size: 24px;
            color: #333;
            text-align: center;
        }

        .book-body > p {
            font-size: 16px;
            color: #666;
            margin: 5px 0;
        }

        .book-footer {
            font-size: 14px;
            text-align: center;
            color: darkgreen;
        }
    </style>

    <style>
        .right-align {
            text-align: right; /* Căn phải nội dung bên trong */
            padding: 10px; /* Để tránh nút dính vào cạnh */
        }

        .button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            color: white;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
        }

        .button:hover {
            background-color: #45a049;
        }
    </style>
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
    String urlpage = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                  + request.getContextPath();
%>
<!-- Header-->
<%@include file="../header.jsp"%>
<%--<jsp:include page="../header.jsp"></jsp:include>--%>
<!-- End Header-->
<div class="book-container">
    <c:forEach items="${requestScope.thongTinSP}" var="sp">
        <div class="book-header">${sp.tenSanPham}</div>
        <div class="col-lg-4 col-md-6 mb-4">
            <img src="<%= urlpage%>/image/product/${sp.anhSP}" class="card-img-middle" alt="..." height="200px">
        </div>
        <div class="col-lg-4 col-md-6 mb-4">
            <div class="book-body">
                <p>Tác giả: ${sp.tacGia.tenTacGia}</p>
                <p style="font: lighter">Giá: ${sp.giaBan}</p>
                <p style="font: lighter">Số lượng: ${sp.soLuong}</p>
                <p style="font: lighter">Mô tả: ${sp.moTa}</p>
            </div>

        </div>
    </c:forEach>
</div>
</body>
</html>
