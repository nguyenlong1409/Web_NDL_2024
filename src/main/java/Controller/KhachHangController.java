package Controller;

import Model.KhachHang;
import Util.MaHoa;
import database.KhachHangDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

@WebServlet(name = "KhachHangController", urlPatterns = {"/khach-hang"})
public class KhachHangController extends HttpServlet {

    public KhachHangController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hanhDong = request.getParameter("hanhDong");
        if (hanhDong.equals("dang-nhap")) {
            dangNhap(request, response);
        } else if (hanhDong.equals("dang-xuat")) {
            dangXuat(request, response);
        } else if (hanhDong.equals("dang-ky")) {
            dangKy(request, response);
        } else if (hanhDong.equals("doi-mat-khau")) {
            doiMatKhau(request, response);
        } else if (hanhDong.equals("thay-doi-thong-tin")) {
            thayDoiThongTin(request, response);
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void dangNhap(HttpServletRequest request, HttpServletResponse response) {

        try {
            String tenDangNhap = request.getParameter("tenDangNhap");
            String matKhau = request.getParameter("matKhau");
            matKhau = MaHoa.toSHA1(matKhau);

            KhachHang kh = new KhachHang();
            kh.setTenDangNhap(tenDangNhap);
            kh.setMatKhau(matKhau);

            KhachHangDAO khachHangDAO = new KhachHangDAO();
            KhachHang khachHang = khachHangDAO.chonTenvaMK(kh);

            String url = "";
            if (khachHang != null) {
                HttpSession session = request.getSession();
                session.setAttribute("khachHang", khachHang);
                url = "/index.jsp";
            } else {
                request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khấu không chính xác");
                url = "/khachhangJsp/dangnhap.jsp";
            }
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void dangXuat(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            session.invalidate(); // Hủy bo Session

            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                         + request.getContextPath();
            response.sendRedirect(url + "/index.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void dangKy(HttpServletRequest request, HttpServletResponse response) {

        try {
            String tenDangNhap = request.getParameter("tenDangNhap");
            String matKhau = request.getParameter("matKhau");
            String matKhauNhapLai = request.getParameter("matKhauNhapLai");
            String hoVaTen = request.getParameter("hoVaTen");
            String gioiTinh = request.getParameter("gioiTinh");
            String ngaySinh = request.getParameter("ngaySinh");
            String diaChi = request.getParameter("diaChi");
            String diaChiNhanHang = request.getParameter("diaChiNhanHang");
            String diaChiMuaHang = request.getParameter("diaChiMuaHang");
            String soDienThoai = request.getParameter("soDienThoai");
            String email = request.getParameter("email");
            String nhanEmail = request.getParameter("nhanEmail");

            request.setAttribute("tenDangNhap", tenDangNhap);
            request.setAttribute("hoVaTen", hoVaTen);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("diachiNhanHang", diaChiNhanHang);
            request.setAttribute("diaChiMuaHang", diaChiMuaHang);
            request.setAttribute("soDienThoai", soDienThoai);
            request.setAttribute("email", email);
            request.setAttribute("nhanEmail", nhanEmail);

            String url = "";
            String baoLoi = "";
            KhachHangDAO khachHangDAO = new KhachHangDAO();
            if (khachHangDAO.ktTenDangNhap(tenDangNhap)) {
                baoLoi += "Tên đăng nhập đã tồn tại <br/>";
            }
            if (!matKhau.equals(matKhauNhapLai)) {
                baoLoi += "Mật khẩu không khớp <br/>";
            } else {
                matKhau = MaHoa.toSHA1(matKhau);
            }


            request.setAttribute("baoLoi", baoLoi);

            if (!baoLoi.isEmpty()) {
                url = "/khachhangJsp/dangky.jsp";
            } else {
                Random rd = new Random();
                String maKhachHang = System.currentTimeMillis() + rd.nextInt(100) + "";
                KhachHang khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
                        diaChiMuaHang, Date.valueOf(ngaySinh), soDienThoai, email, nhanEmail != null, "user");
                khachHangDAO.chenTT(khachHang);

                url = "/khachhangJsp/ThanhCong1.jsp";
            }

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doiMatKhau(HttpServletRequest request, HttpServletResponse response) {

        try {
            String matKhauHienTai = request.getParameter("matKhauHienTai");
            String matKhauMoi = request.getParameter("matKhauMoi");
            String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");

            String matKhauHienTaiSHA1 = MaHoa.toSHA1(matKhauHienTai);
            String baoLoi = "";

            //Kiem tra mật khẩu cũ có giống không
            //Kiem tea đăng nhập
            HttpSession session = request.getSession();
            Object obj = session.getAttribute("khachHang");
            KhachHang khachHang = null;
            String url = "/khachhangJsp/doiMatKhau.jsp";

            if (obj != null) {
                khachHang = (KhachHang) obj;
            }

            if (khachHang == null) {
                baoLoi = "Chưa đăng nhập";
            } else {
                //Kiểm tra tinh chính xác của mật khẩu
                if (!matKhauHienTaiSHA1.equals(khachHang.getMatKhau())) {
                    baoLoi = "Mật khẩu hiện tại chưa chính xác";
                } else {
                    if (!matKhauMoi.equals(matKhauMoiNhapLai)) {
                        baoLoi = "Mật khẩu không khớp";
                    } else {
                        String matKhauMoiSHA1 = MaHoa.toSHA1(matKhauMoi);
                        khachHang.setMatKhau(matKhauMoiSHA1);
                        KhachHangDAO khachHangDAO = new KhachHangDAO();
                        if (khachHangDAO.doiMatKhau(khachHang)) {
                            baoLoi = "Đã thay đổi mật khẩu thành công";
                            url = "/khachhangJsp/ThanhCong1.jsp";
                        } else {
                            baoLoi = "Đổi mật khẩu thất bại";
                        }
                    }
                }
            }

            request.setAttribute("baoLoi", baoLoi);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void thayDoiThongTin(HttpServletRequest request, HttpServletResponse response) {

        try {
            String hoVaTen = request.getParameter("hoVaTen");
            String gioiTinh = request.getParameter("gioiTinh");
            String ngaySinh = request.getParameter("ngaySinh");
            String diaChi = request.getParameter("diaChi");
            String diaChiNhanHang = request.getParameter("diaChiNhanHang");
            String diaChiMuaHang = request.getParameter("diaChiMuaHang");
            String soDienThoai = request.getParameter("soDienThoai");
            String email = request.getParameter("email");
            String nhanEmail = request.getParameter("nhanEmail");

            request.setAttribute("hoVaTen", hoVaTen);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("diachiNhanHang", diaChiNhanHang);
            request.setAttribute("diaChiMuaHang", diaChiMuaHang);
            request.setAttribute("soDienThoai", soDienThoai);
            request.setAttribute("email", email);
            request.setAttribute("nhanEmail", nhanEmail);

            String url = "";
            String baoLoi = "";
            KhachHangDAO khachHangDAO = new KhachHangDAO();

            request.setAttribute("baoLoi", baoLoi);
            if (baoLoi.length() > 0) {
                url = "/khachhangJsp/thayDoiThongTin.jsp";
            } else {
                Object obj = request.getSession().getAttribute("khachHang");
                KhachHang khachHang = null;
                if (obj != null) {
                    khachHang = (KhachHang) obj;
                    if (khachHang != null) {
                        String maKhachHang = khachHang.getMaKhachHang();
                        KhachHang kh = new KhachHang(maKhachHang, "", "", hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
                                diaChiMuaHang, Date.valueOf(ngaySinh), soDienThoai, email, nhanEmail != null, "user");
                        khachHangDAO.capNhatKH(kh);

                        KhachHang kh2 = khachHangDAO.chonTheoMa(kh);
                        request.getSession().setAttribute("khachHang", kh2);
                        url = "/khachhangJsp/ThanhCong1.jsp";
                    }

                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
                    requestDispatcher.forward(request, response);
                }
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
