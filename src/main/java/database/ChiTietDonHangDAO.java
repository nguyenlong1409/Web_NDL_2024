package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.ChiTietDonHang;
import Model.DonHang;
import Model.SanPham;
import Model.TheLoai;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang> {

    @Override
    public ArrayList<ChiTietDonHang> chonTatCa() {
        ArrayList<ChiTietDonHang> ketQua = new ArrayList<ChiTietDonHang>();

        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM chitietdonhang";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:

            while (rs.next()) {
                String maChiTietDonHang = rs.getString("machitietdonhang");
                String madonhang = rs.getString("madonhang");
                String masanpham = rs.getString("masanpham");
                double soluong = rs.getDouble("soluong");
                double giagoc = rs.getDouble("giagoc");
                double giamgia = rs.getDouble("giamgia");
                double giaban = rs.getDouble("giaban");
                double thuevat = rs.getDouble("thuevat");
                double tongtien = rs.getDouble("tongtien");

                DonHang donhang = new DonHang();
                donhang.setMaDonHang(madonhang);

                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(masanpham);
                DonHang dh = (new DonHangDAO().chonTheoMa(donhang));
                SanPham sp = (new SanPhamDAO().chonTheoMa(sanPham));
                ChiTietDonHang ctdh = new ChiTietDonHang(maChiTietDonHang, dh, sp, soluong, giagoc, giamgia, giaban,
                        thuevat, tongtien);
                ketQua.add(ctdh);
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
    public ChiTietDonHang chonTheoMa(ChiTietDonHang t) {
        ChiTietDonHang ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM chitietdonhang WHERE machitietdonhang=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaChiTietDonHang());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String maChiTietDonHang = rs.getString("machitietdonhang");
                String donhang = rs.getString("madonhang");// o
                String sanpham = rs.getString("masanpham");// o
                double soluong = rs.getDouble("soluong");
                double giagoc = rs.getDouble("giagoc");
                double giamgia = rs.getDouble("giamgia");
                double giaban = rs.getDouble("giaban");
                double thuevat = rs.getDouble("thuevat");
                double tongtien = rs.getDouble("tongtien");

                DonHang dh = new DonHangDAO().chonTheoMa(new DonHang(donhang, null, "", "",
                        "", "", 0, 0, null, null));
                SanPham sp = new SanPhamDAO().chonTheoMa(new SanPham(sanpham, "", null, 0, 0,
                        0, 0, 0, new TheLoai(), "", "", ""));

                ketQua = new ChiTietDonHang(maChiTietDonHang, dh, sp, soluong, giagoc, giamgia, giaban, thuevat,
                        tongtien);
                break;
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
    public int chenTT(ChiTietDonHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO chitietdonhang (machitietdonhang, madonhang,masanpham, soluong, giagoc,giamgia,giaban,thuevat,tongtien) "
                         + " VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaChiTietDonHang());
            st.setString(2, t.getDonHang().getMaDonHang());
            st.setString(3, t.getSanPham().getMaSanPham());
            st.setDouble(4, t.getSoLuong());
            st.setDouble(5, t.getGiaGoc());
            st.setDouble(7, t.getGiamGia());
            st.setDouble(6, t.getGiaBan());
            st.setDouble(8, t.getThueVAT());
            st.setDouble(9, t.getTongTien());
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
    public int insertAll(ArrayList<ChiTietDonHang> arr) {
        int dem = 0;
        for (ChiTietDonHang ChiTietDonHang : arr) {
            dem += this.chenTT(ChiTietDonHang);
        }
        return dem;
    }

    @Override
    public int xoaTT(ChiTietDonHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from chitietdonhang " + " WHERE machitietdonhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaChiTietDonHang());

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
    public int deleteAll(ArrayList<ChiTietDonHang> arr) {
        int dem = 0;
        for (ChiTietDonHang ChiTietDonHang : arr) {
            dem += this.xoaTT(ChiTietDonHang);
        }
        return dem;
    }

    @Override
    public int capNhatTT(ChiTietDonHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE chitietdonhang SET madonhang=?, masanpham=?, soluong=?, giagoc=?, giamgia=?, giaban=?, thuevat=?, tongtien=?"
                         + " WHERE machitietdonhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getDonHang().getMaDonHang());
            st.setString(2, t.getSanPham().getMaSanPham());
            st.setDouble(3, t.getSoLuong());
            st.setDouble(4, t.getGiaGoc());
            st.setDouble(5, t.getGiamGia());
            st.setDouble(6, t.getGiaBan());
            st.setDouble(7, t.getThueVAT());
            st.setDouble(8, t.getTongTien());
            st.setString(9, t.getMaChiTietDonHang());

            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    public static void main(String[] args) {

        ChiTietDonHangDAO chiTietDonHangDAO = new ChiTietDonHangDAO();
        ArrayList<ChiTietDonHang> chiTietDonHangs= chiTietDonHangDAO.chonTatCa();
        for (ChiTietDonHang chiTietDonHang : chiTietDonHangs) {
            System.out.println(chiTietDonHang);
        }

    }

}