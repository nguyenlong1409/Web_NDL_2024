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

@WebServlet(name = "tim_kiem", urlPatterns = {"/tim-kiem"})
public class TimKiemSanPham extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String giaTriTK_raw = request.getParameter("timkiem");
        String giaTriTK;
        String url = "";

        try{
            giaTriTK = String.valueOf(giaTriTK_raw);
            SanPhamDAO dao = new SanPhamDAO();
            if(giaTriTK == null || giaTriTK.equals("")){
                url = "#";
            } else{
                ArrayList<SanPham> ketQua = dao.timKiemSP(giaTriTK);
                request.setAttribute("ketQuaTKTimKiem", ketQua);
                request.setAttribute("giaTriTk", giaTriTK );
                url = "/sanphamJSP/timKiem.jsp";
            }
        } catch (NumberFormatException e){

        }
        request.getRequestDispatcher(url).forward(request, response);
    }


}
