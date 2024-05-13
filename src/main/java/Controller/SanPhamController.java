package Controller;

import Model.KhachHang;
import Model.SanPham;
import Model.TacGia;
import Model.TheLoai;
import database.KhachHangDAO;
import database.SanPhamDAO;
import database.TacGiaDAO;
import database.TheLoaiDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;


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

//        SanPham sanPham = new SanPham();
//
//        DiskFileItemFactory factory = new DiskFileItemFactory().fileItemBuilder().get();
//
//        JakartaServletDiskFileUpload upload = new JakartaServletDiskFileUpload(factory);
//        try {
//            List<FileItem> items = upload.parseRequest(request);
//            for (FileItem item : items) {
//                if (item.getFieldName().equals("maSanPham")) {
//                    sanPham.setMaSanPham(item.getString());
//                } else if (item.getFieldName().equals("tenSanPham")) {
//                    sanPham.setTenSanPham(item.getString());
//                } else if (item.getFieldName().equals("maTacGia")) {
//                    String maTG = item.getString();
//                    TacGia tacGia = new TacGiaDAO().chonTheoMa(new TacGia(maTG,
//                            "", null, "", ""));
//                } else if (item.getFieldName().equals("namXuatBan")) {
//                    sanPham.setNamXuatBan(Integer.parseInt(item.getString()));
//                } else if (item.getFieldName().equals("giaNhap")) {
//                    sanPham.setGiaNhap(Double.parseDouble(item.getString()));
//                } else if (item.getFieldName().equals("giaGoc")) {
//                    sanPham.setGiaNhap(Double.parseDouble(item.getString()));
//                } else if (item.getFieldName().equals("giaBan")) {
//                    sanPham.setGiaNhap(Double.parseDouble(item.getString()));
//                } else if (item.getFieldName().equals("soLuong")) {
//                    sanPham.setGiaNhap(Double.parseDouble(item.getString()));
//                } else if (item.getFieldName().equals("maTheLoai")) {
//                    String maTl = item.getString();
//                    TheLoai theLoai = new TheLoaiDAO().chonTheoMa(new TheLoai(maTl, ""));
//                } else if (item.getFieldName().equals("moTa")) {
//                    sanPham.setTenSanPham(item.getString());
//                } else if (item.getFieldName().equals("ngonNgu")) {
//                    sanPham.setTenSanPham(item.getString());
//                } else if (item.getFieldName().equals("anhSP")) {
//                    if (item.getSize() > 0) {
//                        String fileName_raw = item.getName();
//                        String fileName = System.currentTimeMillis() + "." + fileName_raw;
//                        String folder = getServletContext().getRealPath("/image/product");
//                        File file = new File(folder + "/" + fileName);
//                        item.write(file);
//                        sanPham.setAnhSP(fileName);
//                    } else {
//                        sanPham.setAnhSP("/image/product/book.jpg");
//                    }
//                }
//            }
//            SanPhamDAO sanPhamDAO = new SanPhamDAO();
//            sanPhamDAO.chenTT(sanPham);
//            response.sendRedirect("/sanphamJSP/quanLySP");
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    private void suaThongTinSP(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

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
        String anhSP = request.getParameter("anhSP");

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
        request.setAttribute("anhSP", anhSP);

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
            TheLoai theLoai = (new TheLoaiDAO().chonTheoMa(new TheLoai(maTheLoai, "")));
            TacGia tacGia = (new TacGiaDAO().chonTheoMa(new TacGia(maTacGia, "", null, "", "")));
            SanPham sp = new SanPham(maSanPham, tenSanPham, tacGia, Integer.parseInt(namXuatBan),
                    Double.parseDouble(giaNhap), Double.parseDouble(giaGoc), Double.parseDouble(giaBan),
                    Double.parseDouble(soLuong), theLoai, ngonNgu, moTa, anhSP);
            sanPhamDAO.capNhatTT(sp);
            url = "/sanphamJSP/quanLySP";
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }



    private void xoaSanPham(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }

//    private void quanLySanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        SanPhamDAO sanPhamDAO2 = new SanPhamDAO();
//        ArrayList<SanPham> arrayList = sanPhamDAO2.chonTatCa();
//        request.setAttribute("danhSach", arrayList);
//        request.getRequestDispatcher("/sanphamJSP/quanLySP.jsp").forward(request, response);
//    }


//    private void dsSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        SanPhamDAO sanPhamDAO = new SanPhamDAO();
//        ArrayList<SanPham> arrayList = sanPhamDAO.chonTatCa();
//        request.setAttribute("arrayList", arrayList);
//        request.getRequestDispatcher("tatCaSanPham.jsp").forward(request, response);;
//    }

}


