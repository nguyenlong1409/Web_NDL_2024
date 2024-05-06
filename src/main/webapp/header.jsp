<%@ page import="Model.KhachHang" %>
<%@ page import="database.TheLoaiDAO" %>
<%@ page import="Model.TheLoai" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2024
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!-- Navbar-->
<%
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="image/logo/Logobook1.jpg" alt="Boostrap"
                 height="24">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Thể loại
                    </a>
                    <ul class="dropdown-menu">
                        <%
                            TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
                            ArrayList<TheLoai> arrayList = theLoaiDAO.selectAll();
                            request.setAttribute("arrayList", arrayList);
                        %>
                        <li><a class="dropdown-item" href="sp-the-loai?maTheLoai=${theLoaiDao.maTheLoai}">Tất cả</a></li>
                        <c:forEach items="${requestScope.arrayList}" var="theLoaiDao">
                            <li><a class="dropdown-item" href="sp-the-loai?maTheLoai=${theLoaiDao.maTheLoai}">${theLoaiDao.tenTheLoai}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Tìm kiếm" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>

            <form>
                <%
                    Object obj = session.getAttribute("khachHang");
                    KhachHang khachHang = null;
                    if (obj!=null){
                        khachHang = (KhachHang)obj;
                    }

                    if(khachHang==null){
                %>
                <a class="btn btn-primary" style="white-space: nowrap;" href="khachhangJsp/dangnhap.jsp">
                    Đăng nhập
                </a>
                <%} else { %>
                <ul calss="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item dropstart">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            <b><%=khachHang.getTenDangNhap() %>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Thông báo</a></li>
                            <%--                        <li><a class="dropdown-item" href="san-pham?hanhDongSP=quan-ly-san-pham">Quản lý sản phẩm</a></li>--%>
                            <li><a class="dropdown-item" href="sanphamJSP/quanLySP.jsp">Quản lý sản phẩm</a></li>
                            <li><a class="dropdown-item" href="khachhangJsp/thayDoiThongTin.jsp">Thay đổi thông tin</a></li>
                            <li><a class="dropdown-item" href="khachhangJsp/doiMatKhau.jsp">Đổi mật khẩu</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="khach-hang?hanhDong=dang-xuat">Đăng xuất</a></li>
                        </ul>
                    </li>
                </ul>

                <% } %>
            </form>
        </div>
    </div>
</nav>
<!-- End Navbar-->
