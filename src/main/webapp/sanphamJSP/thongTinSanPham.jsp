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
</head>
<body>
    <div class="book-container">
        <c:forEach items="${requestScope.thongTinSP}" var="sp">
        <div class="book-header">Tên Sách: ${sp.tenSanPham}</div>
        <div class="book-body">
            <p>Tác giả: ${sp.tacGia.tenTacGia}</p>
            <p>Giá: ${sp.giaBan}</p>
            <p>Số lượng: ${sp.soLuong}</p>
            <p>Mô tả: ${sp.moTa}</p>
        </div>
        </c:forEach>
    </div>

    <div class="right-align">
        <button onclick="goToHomePage()">Quay Về Trang Chủ</button>
    </div>


</body>
<script>
    function goToHomePage() {
        window.location.href = 'http://localhost:8080/BookWeb/';
    }
</script>
</html>
