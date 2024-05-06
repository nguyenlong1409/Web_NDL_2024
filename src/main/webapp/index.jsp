<%@ page import="Model.KhachHang" %>
<%@ page import="database.SanPhamDAO" %>
<%@ page import="Model.SanPham" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.TheLoaiDAO" %>
<%@ page import="Model.TheLoai" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/23/2024
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width-device-width, initial-scale=1, shink-to-fit=no">
    <title>Bookstore</title>

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
<!-- Navbar-->
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
                    <a class="nav-link active" aria-current="page" href="#">Trang chủ</a>
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
            <form class="d-flex" role="search" action="tim-kiem" method="post">
                <input class="form-control me-2" type="search" placeholder="Tìm kiếm" aria-label="Search" name="timkiem" id="timkiem">
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

<!-- Page content -->
<div class="container">
    <div class="row">
        <!-- Menu Left -->
        <div class="col-lg-3">
            <div class="list-group">
                <a href="" class="list-group-item list-group-item-action" aria-current="true">Sách nổi bật</a>
                <a href="#" class="list-group-item list-group-item-action">Tiểu thuyết</a>
                <a href="#" class="list-group-item list-group-item-action">Trinh thám</a>
                <a href="#" class="list-group-item list-group-item-action">Văn học Việt Nam</a>
            </div>
        </div>
        <!-- End Menu Left -->

        <!-- Slider and Products -->
        <div class="col-lg-9 ">
            <!-- Slider -->
            <div id="carouselExampleDark" class="carousel carousel-dark slide">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active"
                            aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="10000">
                        <img src="image/slider/1.png" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
<%--                            <h5>First slide label</h5>--%>
<%--                            <p>Some representative placeholder content for the first slide.</p>--%>
                        </div>
                    </div>
                    <div class="carousel-item" data-bs-interval="2000">
                        <img src="image/slider/2.png" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
<%--                            <h5>Second slide label</h5>--%>
<%--                            <p>Some representative placeholder content for the second slide.</p>--%>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="image/slider/3.png" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
<%--                            <h5>Third slide label</h5>--%>
<%--                            <p>Some representative placeholder content for the third slide.</p>--%>
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
            <!-- End Slider -->

            <!-- Product -->
            <div class="row">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="#">
                            <img src="image/product/1.png" class="card-img-top" alt="..." height="500px"></a>
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Nhà giả kim</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="#">
                            <img src="image/product/2.png" class="card-img-top" alt="..." height="500px"></a>
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Nhà giả kim</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="#">
                            <img src="image/product/3.png" class="card-img-top" alt="..." height="500px"></a>
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Nhà giả kim</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Product -->
        </div>
    </div>
</div>
<!-- End Page content -->

<!-- Footer -->
<div class="container">
    <footer class="row row-cols-1 row-cols-sm-2 row-cols-md-5 py-5 my-5 border-top">
        <div class="col mb-3">
            <a href="/" class="d-flex align-items-center mb-3 link-body-emphasis text-decoration-none">
                <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
            </a>
            <p class="text-body-secondary">© 2024</p>
        </div>

        <div class="col mb-3">

        </div>

        <div class="col mb-3">
            <h5>Section</h5>
            <ul class="nav flex-column">
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Home</a></li>
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Features</a></li>
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Pricing</a></li>
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">FAQs</a></li>
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">About</a></li>
            </ul>
        </div>

        <div class="col mb-3">
            <h5>Section</h5>
            <ul class="nav flex-column">
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Home</a></li>
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Features</a></li>
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Pricing</a></li>
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">FAQs</a></li>
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">About</a></li>
            </ul>
        </div>

        <div class="col mb-3">
            <h5>Section</h5>
            <ul class="nav flex-column">
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Home</a></li>
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Features</a></li>
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Pricing</a></li>
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">FAQs</a></li>
                <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">About</a></li>
            </ul>
        </div>
    </footer>
</div>
<!-- End Footer-->

</body>
</html>
