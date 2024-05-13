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
<%
    String urlpage = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                  + request.getContextPath();
%>
<!-- Header-->
<%@include file="../header.jsp"%>
<%--<jsp:include page="../header.jsp"></jsp:include>--%>
<!-- End Header-->
<h3 style="text-align: center">Kết quả cho ${giaTriTK}</h3>
<div class="container">
    <div class="row">
        <div class="col-lg-3">
            <div class="list-group">
                <a href="" class="list-group-item list-group-item-action" aria-current="true">Sách nổi bật</a>
                <a href="tim-kiem?timkiem=tiểu thuyết" class="list-group-item list-group-item-action">Tiểu thuyết</a>
                <a href="tim-kiem?timkiem=trinh thám" class="list-group-item list-group-item-action">Trinh thám</a>
                <a href="tim-kiem?timkiem=VI" class="list-group-item list-group-item-action">Sách tiếng Việt</a>
                <a href="tim-kiem?timkiem=FL" class="list-group-item list-group-item-action">Foreign Books</a>
            </div>
        </div>
        <div class="col-lg-9">
            <!-- product -->
            <div class="row">
                <c:forEach items="${requestScope.ketQuaTKTimKiem}" var="sp">
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card h-100">
                            <img src="<%= urlpage%>/image/product/${sp.anhSP}" class="card-img-top" alt="..." height="300px"></a>
                            <div class="card-body">
                                <h5 class="card-title">
                                    <a href="thong-tin?tenSanPham_raw=${sp.tenSanPham}"> ${sp.tenSanPham}</a>
                                </h5>
                                <p class="card-text">${sp.moTa}</p>
                                <p class="card-text">${sp.giaBan}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

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
