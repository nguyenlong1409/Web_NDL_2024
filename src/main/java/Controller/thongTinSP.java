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

@WebServlet(name = "ThongTinSanPham", urlPatterns = {"/thong-tin"})
public class thongTinSP extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tenSanPham_raw = request.getParameter("tenSanPham_raw");
        String tenSP;
        String url = "";
        try{
            tenSP = String.valueOf(tenSanPham_raw);
            SanPhamDAO dao = new SanPhamDAO();
            ArrayList<SanPham> ketQua = dao.selectByName(tenSP);
            request.setAttribute("thongTinSP", ketQua);
            url = "/sanphamJSP/thongTinSanPham.jsp";
        } catch (NumberFormatException e){

        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}
