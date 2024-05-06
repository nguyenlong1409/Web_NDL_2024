package Controller;

import Model.SanPham;
import Model.TacGia;
import Model.TheLoai;
import database.SanPhamDAO;
import database.TacGiaDAO;
import database.TheLoaiDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@WebServlet(name = "SanPhamController", urlPatterns = {"/san-pham"})
public class SanPhamController extends HttpServlet {

    public SanPhamController() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String hanhDongSP = request.getParameter("hanhDongSP");
        if (hanhDongSP.equals("them-san-pham")) {
            themSP(request, response);
        } else if (hanhDongSP.equals("thay-doi-san-pham")) {
            suaThongTinSP(request, response);
//        } else if (hanhDongSP.equals("quan-ly-san-pham")) {
//            quanLySanPham(request, response);
        } else if (hanhDongSP.equals("xoa-san-pham")) {
            xoaSanPham(request, response);
        } else {
            response.sendRedirect("/sanphamJSP/quanLySP.jsp");
        }
    }

    private void kiemTraSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    private void themSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String maSanPham = request.getParameter("maSanPham");
        String tenSanPham = request.getParameter("tenSanPham");
        String maTacGia = request.getParameter("maTacGia");
        String namXuatBan = request.getParameter("namXuatBan");
        String giaNhap = request.getParameter("giaNhap");
        String giaGoc = request.getParameter("giaGoc");
        String giaBan = request.getParameter("giaBan");
        String soLuong = request.getParameter("soLuong");
        String maTheLoai = request.getParameter("maTheLoai");
        String moTa = request.getParameter("moTa");
        String ngonNgu = request.getParameter("ngonNgu");

        request.setAttribute("maSanPham", maSanPham);
        request.setAttribute("tenSanPham", tenSanPham);
        request.setAttribute("maTacGia", maTacGia);
        request.setAttribute("namXuatBan", namXuatBan);
        request.setAttribute("giaNhap", giaNhap);
        request.setAttribute("giaGoc", giaGoc);
        request.setAttribute("giaBan", giaBan);
        request.setAttribute("soLuong", soLuong);
        request.setAttribute("maTheLoai", maTheLoai);
        request.setAttribute("moTa", moTa);
        request.setAttribute("ngonNgu", ngonNgu);

        String url = "";
        String baoLoi = "";
        SanPhamDAO sanPhamDAO = new SanPhamDAO();

        if (sanPhamDAO.ktMaSanPham(maSanPham)) {
            baoLoi += "Mã sản phẩm đã tồn tại";
        }

        request.setAttribute("baoLoi", baoLoi);
        if (baoLoi.length() > 0) {
            url = "/sanphamJSP/themSanPham.jsp";
        } else {
            TheLoai theLoai = (new TheLoaiDAO().selectByID(new TheLoai(maTheLoai, "")));
            TacGia tacGia = (new TacGiaDAO().selectByID(new TacGia(maTacGia, "", null, "", "")));
            SanPham sanPham = new SanPham(maSanPham, tenSanPham, tacGia, Integer.parseInt(namXuatBan), Double.parseDouble(giaNhap),
                    Double.parseDouble(giaGoc), Double.parseDouble(giaBan), Double.parseDouble(soLuong), theLoai, ngonNgu, moTa);
            sanPhamDAO.insert(sanPham);
            url = "/sanphamJSP/ActionSuccess1.jsp";
        }

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    private void suaThongTinSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String maSanPham = request.getParameter("maSanPham");
        String tenSanPham = request.getParameter("tenSanPham");
        String maTacGia = request.getParameter("maTacGia");
        String namXuatBan = request.getParameter("namXuatBan");
        String giaNhap = request.getParameter("giaNhap");
        String giaGoc = request.getParameter("giaGoc");
        String giaBan = request.getParameter("giaBan");
        String soLuong = request.getParameter("soLuong");
        String maTheLoai = request.getParameter("maTheLoai");
        String moTa = request.getParameter("moTa");
        String ngonNgu = request.getParameter("ngonNgu");

        request.setAttribute("maSanPham", maSanPham);
        request.setAttribute("tenSanPham", tenSanPham);
        request.setAttribute("maTacGia", maTacGia);
        request.setAttribute("namXuatBan", namXuatBan);
        request.setAttribute("giaNhap", giaNhap);
        request.setAttribute("giaGoc", giaGoc);
        request.setAttribute("giaBan", giaBan);
        request.setAttribute("soLuong", soLuong);
        request.setAttribute("maTheLoai", maTheLoai);
        request.setAttribute("moTa", moTa);
        request.setAttribute("ngonNgu", ngonNgu);

        String url = "";
        String baoLoi = "";
        SanPhamDAO sanPhamDAO = new SanPhamDAO();

        if (!sanPhamDAO.ktMaSanPham(maSanPham)) {
            baoLoi += "Mã sản phẩm chưa tồn tại";
        }

        request.setAttribute("baoLoi", baoLoi);
        if (baoLoi.length() > 0) {
            url = "/sanphamJSP/suaSanPham.jsp";
        } else {
            TheLoai theLoai = (new TheLoaiDAO().selectByID(new TheLoai(maTheLoai, "")));
            TacGia tacGia = (new TacGiaDAO().selectByID(new TacGia(maTacGia, "", null, "", "")));
            SanPham sp = new SanPham(maSanPham, tenSanPham, tacGia, Integer.parseInt(namXuatBan), Double.parseDouble(giaNhap),
                    Double.parseDouble(giaGoc), Double.parseDouble(giaBan), Double.parseDouble(soLuong), theLoai, ngonNgu, moTa);
            sanPhamDAO.update(sp);
            url = "/sanphamJSP/ActionSuccess1.jsp";
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    private void xoaSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

//    private void quanLySanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        SanPhamDAO sanPhamDAO2 = new SanPhamDAO();
//        ArrayList<SanPham> arrayList = sanPhamDAO2.selectAll();
//        request.setAttribute("danhSach", arrayList);
//        request.getRequestDispatcher("/sanphamJSP/quanLySP.jsp").forward(request, response);
//    }



//    private void dsSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        SanPhamDAO sanPhamDAO = new SanPhamDAO();
//        ArrayList<SanPham> arrayList = sanPhamDAO.selectAll();
//        request.setAttribute("arrayList", arrayList);
//        request.getRequestDispatcher("tatCaSanPham.jsp").forward(request, response);;
//    }
}
