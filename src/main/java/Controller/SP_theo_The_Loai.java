package Controller;

import Model.SanPham;
import database.SanPhamDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "dsSanPham", urlPatterns = {"/sp-the-loai"})
public class SP_theo_The_Loai extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maTheLoai_raw = request.getParameter("maTheLoai");
        String maTheLoai = String.valueOf(maTheLoai_raw);
        SanPhamDAO sanPhamDAO3 = new SanPhamDAO();
        ArrayList<SanPham> arrayList = sanPhamDAO3.getByMaTheLoai(maTheLoai);
        request.setAttribute("SPbymaTheLoai", arrayList);
        request.getRequestDispatcher("/sanphamJSP/dsSanPham.jsp").forward(request, response);
    }

//    public static void main(String[] args) {
//        SanPhamDAO dao = new SanPhamDAO();
//        ArrayList<SanPham> ketQua = dao.getByMaTheLoai("TL3");
//        for (SanPham s : ketQua) {
//            System.out.println(s.toString());
//        }
//    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void dsSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maTheLoai_raw = request.getParameter("maTheLoai");
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        ArrayList<SanPham> arrayList = sanPhamDAO.getByMaTheLoai(maTheLoai_raw);
        request.setAttribute("SPbymaTheLoai", arrayList);
        request.getRequestDispatcher("/sanphamJSP/dsSanPham.jsp").forward(request, response);
    }
}
