package Controller;


import Model.SanPham;
import Model.TacGia;
import Model.TheLoai;
import database.SanPhamDAO;
import database.TacGiaDAO;
import database.TheLoaiDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


import java.io.IOException;


@WebServlet(name = "themsanpham", urlPatterns = {"/them-san-pham"})
@MultipartConfig(location = "D:\\Java-Intellij\\Bai4_Boostrap2\\src\\main\\webapp\\image\\product",
        fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 5 * 1024 * 1024, // 5MB
        maxRequestSize = 5 * 1024 * 1024 * 5) //25MB
public class ThemSanPham extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        TheLoai theLoai = (new TheLoaiDAO().chonTheoMa(new TheLoai(maTheLoai, "")));
        TacGia tacGia = (new TacGiaDAO().chonTheoMa(new TacGia(maTacGia, "",
                null, "", "")));
        SanPham sanPham = new SanPham();

        int namXuatBan1 = Integer.parseInt(namXuatBan);
        double giaNhap1 = Double.parseDouble(giaNhap);
        double giaGoc1 = Double.parseDouble(giaGoc);
        double giaBan1 = Double.parseDouble(giaBan);
        double soLuong1 = Double.parseDouble(soLuong);

        sanPham.setMaSanPham(maSanPham);
        sanPham.setTenSanPham(tenSanPham);
        sanPham.setTacGia(tacGia);
        sanPham.setNamXuatBan(namXuatBan1);
        sanPham.setGiaNhap(giaNhap1);
        sanPham.setGiaGoc(giaGoc1);
        sanPham.setGiaBan(giaBan1);
        sanPham.setSoLuong(soLuong1);
        sanPham.setTheLoai(theLoai);
        sanPham.setMoTa(moTa);
        sanPham.setNgonNgu(ngonNgu);
        try {
            Part part = request.getPart("anhSP");
            part.write(getFileName(part));
            String ten = getFileName(part);
            System.out.println("ten=" + ten);
            sanPham.setAnhSP(ten);
        } catch (Exception e) {
            e.printStackTrace();
        }

        sanPhamDAO.chenTT(sanPham);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
        }

        private String getFileName(Part part){

            // lấy ra nội dung tải lên
            String contentDisposition = part.getHeader("content-disposition");
            System.out.println("content-disposition=" + contentDisposition);

            if (!contentDisposition.contains("filename=")) {
                return "book.jpg";
            }

            int beginIndex = contentDisposition.indexOf("filename=") +10;
            int endIndex = contentDisposition.length() - 1;
            return contentDisposition.substring(beginIndex, endIndex);
        }

        public void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            doPost(request, response);
        }
    }