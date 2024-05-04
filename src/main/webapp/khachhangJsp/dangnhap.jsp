<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/24/2024
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width-device-width, initial-scale=1, shink-to-fit=no">
    <title>Đăng nhập</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>
    <!-- Custom styles for this template -->
    <%
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                     + request.getContextPath();
    %>
    <link href="<%=url%>/css/signin.css" rel="stylesheet">


</head>
<body>
<main class="form-signin w-50 m-auto">
    <%
        String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                     + request.getContextPath();
    %>
    <form class="text-center" action="<%=url1%>/khach-hang" method="POST">
        <input type="hidden" name="hanhDong" value="dang-nhap"/>
        <h1 class="h3 mb-3 fw-normal">ĐĂNG NHẬP</h1>
        <%
            String baoLoi = request.getAttribute("baoLoi")+"";
            if(baoLoi.equals("null")){
                baoLoi = "";
            }
        %>
        <div class="text-center">
            <%=baoLoi %>
        </div>

        <div class="form-floating">
            <input type="text" class="form-control" id="tenDangNhap"
                   placeholder="Tên đăng nhập" name="tenDangNhap"> <label for="tenDangNhap">Tên đăng nhập</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="matKhau"
                   placeholder="Mật khẩu" name="matKhau"> <label for="matKhau">Mật khẩu</label>
        </div>

        <div class="checkbox mb-3">
            <label> <input type="checkbox" value="remember-me">
                Ghi nhớ tài khoản này
            </label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Đăng nhập</button>
        <h6>Chưa có tài khoản?</h6>
        <a href="dangky.jsp">Đăng ký</a>
        <p class="mt-5 mb-3 text-muted"></p>
    </form>
</main>
</body>
</html>
