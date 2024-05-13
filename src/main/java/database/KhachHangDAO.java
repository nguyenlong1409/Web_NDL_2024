package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang> {

    public ArrayList<KhachHang> data = new ArrayList<>();

    @Override
    public ArrayList<KhachHang> chonTatCa() {
        ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM khachhang";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maKhacHang = rs.getString("makhachhang");
                String tenDangNhap = rs.getString("tendangnhap");
                String matKhau = rs.getString("matkhau");
                String hoVaTen = rs.getString("hovaten");
                String gioiTinh = rs.getString("gioitinh");
                String diaChi = rs.getString("diachi");
                String diaChiNhanHang = rs.getString("diachinhanhang");
                String diaChiMuaHang = rs.getString("diachimuahang");
                Date ngaySinh = rs.getDate("ngaysinh");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");
                String vaiTro = rs.getString("vaitro");

                KhachHang kh = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi,
                        diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, vaiTro);
                ketQua.add(kh);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public KhachHang chonTheoMa(KhachHang t) {
        KhachHang ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM khachhang WHERE makhachhang=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maKhacHang = rs.getString("makhachhang");
                String tenDangNhap = rs.getString("tendangnhap");
                String matKhau = rs.getString("matkhau");
                String hoVaTen = rs.getString("hovaten");
                String gioiTinh = rs.getString("gioitinh");
                String diaChi = rs.getString("diachi");
                String diaChiNhanHang = rs.getString("diachinhanhang");
                String diaChiMuaHang = rs.getString("diachimuahang");
                Date ngaySinh = rs.getDate("ngaysinh");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");
                String vaiTro = rs.getString("vaitro");

                ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
                        diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, vaiTro);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    public KhachHang chonTenvaMK(KhachHang t) {
        KhachHang ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM khachhang WHERE tendangnhap=? AND matkhau=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getTenDangNhap());
            st.setString(2, t.getMatKhau());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maKhacHang = rs.getString("makhachhang");
                String tenDangNhap = rs.getString("tendangnhap");
                String matKhau = rs.getString("matkhau");
                String hoVaTen = rs.getString("hovaten");
                String gioiTinh = rs.getString("gioitinh");
                String diaChi = rs.getString("diachi");
                String diaChiNhanHang = rs.getString("diachinhanhang");
                String diaChiMuaHang = rs.getString("diachimuahang");
                Date ngaySinh = rs.getDate("ngaysinh");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");
                String vaiTro = rs.getString("vaitro");

                ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
                        diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, vaiTro);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }


    @Override
    public int chenTT(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO khachhang (makhachhang, tendangnhap, matkhau, hovaten, gioitinh, diachi, " +
                         "diachinhanhang, diachimuahang, ngaysinh, sodienthoai, email, dangkynhanbangtin, vaitro) "
                         + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang());
            st.setString(2, t.getTenDangNhap());
            st.setString(3, t.getMatKhau());
            st.setString(4, t.getHoVaTen());
            st.setString(5, t.getGioiTinh());
            st.setString(6, t.getDiaChi());
            st.setString(7, t.getDiaChiNhanHang());
            st.setString(8, t.getDiaChiMuaHang());
            st.setDate(9, t.getNgaySinh());
            st.setString(10, t.getSoDienThoai());
            st.setString(11, t.getEmail());
            st.setBoolean(12, t.isDangKyNhanBangTin());
            st.setString(13, t.getVaiTro());

            // Bước 3: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insertAll(ArrayList<KhachHang> arr) {
        int dem = 0;
        for (KhachHang KhachHang : arr) {
            dem += this.chenTT(KhachHang);
        }
        return dem;
    }

    @Override
    public int xoaTT(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from khachhang " + " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int deleteAll(ArrayList<KhachHang> arr) {
        int dem = 0;
        for (KhachHang KhachHang : arr) {
            dem += this.xoaTT(KhachHang);
        }
        return dem;
    }

    @Override
    public int capNhatTT(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE khachhang " + " SET " + " tendangnhap=?" + ", matkhau=?" + ", hovaten=?" + ", gioitinh=?"
                         + ", diachi=?" + ", diachinhanhang=?" + ", diachimuahang=?" + ", ngaysinh=?" + ", sodienthoai=?"
                         + ", email=?" + ", dangkynhanbangtin=?"+ ",vaitro=?" + " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getTenDangNhap());
            st.setString(2, t.getMatKhau());
            st.setString(3, t.getHoVaTen());
            st.setString(4, t.getGioiTinh());
            st.setString(5, t.getDiaChi());
            st.setString(6, t.getDiaChiNhanHang());
            st.setString(7, t.getDiaChiMuaHang());
            st.setDate(8, t.getNgaySinh());
            st.setString(9, t.getSoDienThoai());
            st.setString(10, t.getEmail());
            st.setBoolean(11, t.isDangKyNhanBangTin());
            st.setString(12, t.getMaKhachHang());
            st.setString(13, t.getVaiTro());
            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }


    public boolean ktTenDangNhap(String tenDangNhap) {
        boolean ketQua = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM khachhang WHERE tendangnhap=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, tenDangNhap);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                ketQua = true;
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }


    public boolean doiMatKhau(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE khachhang " + " SET " + "matkhau=?" + " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMatKhau());
            st.setString(2, t.getMaKhachHang());
            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua>0;
    }

    public int capNhatKH(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE khachhang " + " SET " +  " hovaten=?" + ", gioitinh=?"
                         + ", diachi=?" + ", diachinhanhang=?" + ", diachimuahang=?" + ", ngaysinh=?" + ", sodienthoai=?"
                         + ", email=?" + ", dangkynhanbangtin=?" + " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getHoVaTen());
            st.setString(2, t.getGioiTinh());
            st.setString(3, t.getDiaChi());
            st.setString(4, t.getDiaChiNhanHang());
            st.setString(5, t.getDiaChiMuaHang());
            st.setDate(6, t.getNgaySinh());
            st.setString(7, t.getSoDienThoai());
            st.setString(8, t.getEmail());
            st.setBoolean(9, t.isDangKyNhanBangTin());
            st.setString(10, t.getMaKhachHang());
            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

//        public static void main(String[] args) {
//            KhachHangDAO khachHangDAO = new KhachHangDAO();
////            ArrayList<KhachHang> khachHangs = khachHangDAO.chonTatCa();
////            for (KhachHang khachHang : khachHangs) {
////                System.out.println(khachHang.toString());
////            }
//            KhachHang khach = new KhachHang("KH00007", "KH005", "", "LA",
//                    "", "Nam","","",new Date(2000-1900, 10,
//                    15), "","",true);
//            khachHangDAO.chenTT(khach);
//        }

}