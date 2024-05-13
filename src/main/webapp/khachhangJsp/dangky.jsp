<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/24/2024
  Time: 4:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width-device-width, initial-scale=1, shink-to-fit=no">
    <title>Đăng Ký</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>
    <style>
        .

        red1
        (
        color: red

        ;
        )
    </style>
</head>
<body>

    <%
        String baoLoi = request.getAttribute("baoLoi")+"";
        baoLoi = (baoLoi.equals("null"))?"":baoLoi;


        String tenDangNhap= request.getAttribute("tenDangNhap")+"";
        tenDangNhap = (tenDangNhap.equals("null"))?"":tenDangNhap;

        String hoVaTen= request.getAttribute("hoVaTen")+"";
        hoVaTen = (hoVaTen.equals("null"))?"":hoVaTen;

        String gioiTinh= request.getAttribute("gioiTinh")+"";
        gioiTinh = (gioiTinh.equals("null"))?"":gioiTinh;

        String ngaySinh= request.getAttribute("ngaySinh")+"";
        ngaySinh = (ngaySinh.equals("null"))?"":ngaySinh;

        String diaChi= request.getAttribute("diaChi")+"";
        diaChi = (diaChi.equals("null"))?"":diaChi;

        String diaChiMuaHang= request.getAttribute("diaChiMuaHang")+"";
        diaChiMuaHang = (diaChiMuaHang.equals("null"))?"":diaChiMuaHang;

        String diaChiNhanHang= request.getAttribute("diaChiNhanHang")+"";
        diaChiNhanHang = (diaChiNhanHang.equals("null"))?"":diaChiNhanHang;

        String soDienThoai= request.getAttribute("soDienThoai")+"";
        soDienThoai = (soDienThoai.equals("null"))?"":soDienThoai;

        String email= request.getAttribute("email")+"";
        email = (email.equals("null"))?"":email;

        String nhanEmail= request.getAttribute("nhanEmail")+"";
        nhanEmail = (nhanEmail.equals("null"))?"":nhanEmail;

    %>

    <%
        String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                     + request.getContextPath();
    %>


<div class="container">
    <div class="text-center"><h3>Đăng ký tài khoản</h3></div>
    <form class="form" action="<%=url1%>/khach-hang" method="post">
        <input type="hidden" name="hanhDong" value="dang-ky"/>
        <div class="row">
            <div class="col-sm-6">
                <h4>Tài khoản</h4>
                <div class="mb-3">
                    <label for="tenDangNhap" class="form-label">Tên đăng Nhập</label>
                    <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" required="required">
                </div>
                <div class="mb-3">
                    <label for="matKhau" class="form-label">Mật khẩu <span class="red1">*</span> </label>
                    <input type="password" class="form-control" id="matKhau" name="matKhau" required="required"
                           onkeyup="checkPass()">
                </div>
                <div class="mb-3">
                    <label for="matKhauNhapLai" class="form-label">Xác nhận lại mật khẩu
                        <span id="msg1" class="red1"></span></label>
                    <input type="password" class="form-control" id="matKhauNhapLai" name="matKhauNhapLai"
                           required="required" onkeyup="checkPass()">
                </div>


                <h4>Thông tin đăng ký</h4>
                <div class="mb-3">
                    <label for="hoVaTen" class="form-label">Họ và Tên</label>
                    <input type="text" class="form-control" id="hoVaTen" name="hoVaTen" value="<%= hoVaTen%>">
                </div>
                <div class="mb-3">
                    <label for="gioiTinh" class="form-label">Giới tính</label>
                    <select class="form-control" id="gioiTinh" name="gioiTinh">
                        <option></option>
                        <option value="Nam" <%= (gioiTinh=="Nam")?"selected='selected'": ""%> >Nam</option>
                        <option value="Nữ" <%= (gioiTinh=="Nữ")?"selected='selected'": ""%> >Nữ</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="ngaySinh" class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="<%= ngaySinh %>" required="required" >
                </div>
            </div>

            <div class=" col-sm-6">
                <h4>Địa chỉ</h4>
                <div class="mb-3">
                    <label for="diaChi" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" id="diaChi" name="diaChi" value="<%= diaChi %>">
                </div>
                <div class="mb-3">
                    <label for="diaChiNhanHang" class="form-label">Địa chỉ nhận hàng</label>
                    <input type="text" class="form-control" id="diaChiNhanHang" name="diaChiNhanHang" value="<%= diaChiNhanHang %>">
                </div>
                <div class="mb-3">
                    <label for="diaChiMuaHang" class="form-label">Địa chỉ mua hàng</label>
                    <input type="text" class="form-control" id="diaChiMuaHang" name="diaChiMuaHang" value="<%= diaChiMuaHang %>">
                </div>
                <div class="mb-3">
                    <label for="soDienThoai" class="form-label">Số điện thoại</label>
                    <input type="tel" class="form-control" id="soDienThoai" name="soDienThoai" value="<%= soDienThoai %>">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">email</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%= email %>">
                </div>
                <div class="mb-3">
                    <label for="nhanEmail" class="form-label">Nhận Email</label>
                    <input type="checkbox" class="form-check-inputl" id="nhanEmail" name="nhanEmail">
                </div>
                <div class="mb-3">
                    <label for="xacNhan" class="form-label">Xác nhận thông tin *</label>
                    <input type="checkbox" class="form-check-inputl" id="xacNhan" name="xacNhan" required="required"
                           onchange="checkInfor1()">
                </div>
                <input class="btn btn-primary form-control" type="reset" value="reset" name="reset" id="reset"/>
            </div>
            <hr/>
            <input class="btn btn-primary form-control" type="submit" value="Đăng ký" name="submit" id="submit"
                   style="visibility: hidden"/>
            <a href="url1/index.jsp">Quay lại</a>
        </div>
    </form>
</div>
</div>

</body>

<script>
    function checkPass() {
        matKhau = document.getElementById("matKhau").value;
        matKhauNhapLai = document.getElementById("matKhauNhapLai").value;
        if (matKhau != matKhauNhapLai) {
            document.getElementById("msg1").innerHTML = "Mật khẩu không khớp";
            return false;
        } else {
            document.getElementById("msg1").innerHTML = "";
            return true;
        }
    }

    function checkInfor1() {
        checkInfor = document.getElementById("xacNhan");
        if (checkInfor.checked== true) {
            document.getElementById("submit").style.visibility = "visible";
        } else {
            document.getElementById("submit").style.visibility = "hidden";
        }
    }
</script>


</html>
