//package Controller;
//
//import Model.SanPham;
//import database.SanPhamDAO;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
//@WebServlet(urlPatterns = {"/pagination-controll"})
//public class paginationControll extends HttpServlet {
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        int page = 1;
//        int recordsPerPage = 6;
//        if (request.getParameter("page") != null)
//            page = Integer.parseInt(request.getParameter("page"));
//        SanPhamDAO dao = new SanPhamDAO();
//        ArrayList<SanPham> list = dao.getAllPage((page - 1) * recordsPerPage, recordsPerPage);
//        int noOfRecords = dao.getNoOfRecords();
//        int noOfPages = (int)Math.ceil(noOfRecords * 1.0 / recordsPerPage);
//        request.setAttribute("sanPhamTheoTrang", list);
//        request.setAttribute("noOfPages", noOfPages);
//        request.setAttribute("currentPage", page);
//        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
//        view.forward(request, response);
//    }
//
//}
