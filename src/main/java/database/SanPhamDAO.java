package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.SanPham;
import Model.TacGia;
import Model.TheLoai;

public class SanPhamDAO implements DAOInterface<SanPham> {

    @Override
    public ArrayList<SanPham> selectAll() {
        ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM sanpham";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String masanpham = rs.getString("masanpham");
                String tensanpham = rs.getString("tensanpham");
                String matacgia = rs.getString("matacgia");
                int namxuatban = rs.getInt("namxuatban");
                double gianhap = rs.getDouble("gianhap");
                double giagoc = rs.getDouble("giagoc");
                double giaban = rs.getDouble("giaban");
                int soluong = (int) rs.getDouble("soluong");
                String matheloai = rs.getString("matheloai");
                String ngonngu = rs.getString("ngonngu");
                String mota = rs.getString("mota");

                TacGia tacGia = (new TacGiaDAO().selectByID(new TacGia(matacgia, "", null, "","")));
                TheLoai theLoai = (new TheLoaiDAO().selectByID(new TheLoai(matheloai, "")));

                SanPham sp = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong,
                        theLoai, ngonngu, mota);
                ketQua.add(sp);
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
    public SanPham selectByID(SanPham t) {

        SanPham ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM sanpham WHERE masanpham=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String masanpham = rs.getString("masanpham");
                String tensanpham = rs.getString("tensanpham");
                String matacgia = rs.getString("matacgia");
                int namxuatban = rs.getInt("namxuatban");
                double gianhap = rs.getDouble("gianhap");
                double giagoc = rs.getDouble("giagoc");
                double giaban = rs.getDouble("giaban");
                int soluong = (int) rs.getDouble("soluong");
                String matheloai = rs.getString("matheloai");
                String ngonngu = rs.getString("ngonngu");
                String mota = rs.getString("mota");

                TacGia tacGia = (new TacGiaDAO().selectByID(new TacGia(matacgia, "", null, "","")));
                TheLoai theLoai = (new TheLoaiDAO().selectByID(new TheLoai(matheloai, "")));

                ketQua = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong,
                        theLoai, ngonngu, mota);
                break;
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    public SanPham selectByIDorName(SanPham t, SanPham u) {

        SanPham ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM sanpham WHERE masanpham=? or tensanpham=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());
            st.setString(2, t.getTenSanPham());

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String masanpham = rs.getString("masanpham");
                String tensanpham = rs.getString("tensanpham");
                String matacgia = rs.getString("matacgia");
                int namxuatban = rs.getInt("namxuatban");
                double gianhap = rs.getDouble("gianhap");
                double giagoc = rs.getDouble("giagoc");
                double giaban = rs.getDouble("giaban");
                int soluong = (int) rs.getDouble("soluong");
                String matheloai = rs.getString("matheloai");
                String ngonngu = rs.getString("ngonngu");
                String mota = rs.getString("mota");

                TacGia tacGia = (new TacGiaDAO().selectByID(new TacGia(matacgia, "", null, "","")));
                TheLoai theLoai = (new TheLoaiDAO().selectByID(new TheLoai(matheloai, "")));

                ketQua = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong,
                        theLoai, ngonngu, mota);
                break;
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int insert(SanPham t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO bookweb.sanpham (masanpham,tensanpham, matacgia, namxuatban,"
                         + " gianhap, giagoc, giaban, soluong, matheloai, ngonngu, mota) "
                         + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());
            st.setString(2, t.getTenSanPham());
            st.setString(3, t.getTacGia().getMaTacGia());
            st.setInt(4, t.getNamXuatBan());
            st.setDouble(5, t.getGiaNhap());
            st.setDouble(6, t.getGiaGoc());
            st.setDouble(7, t.getGiaBan());
            st.setDouble(8, t.getSoLuong());
            st.setString(9, t.getTheLoai().getMaTheLoai());
            st.setString(10, t.getNgonNgu());
            st.setString(11, t.getMoTa());

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
    public int insertAll(ArrayList<SanPham> arr) {
        int dem = 0;
        for (SanPham SanPham : arr) {
            dem += this.insert(SanPham);
        }
        return dem;
    }

    @Override
    public int delete(SanPham t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from sanpham " + " WHERE masanpham=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());

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
    public int deleteAll(ArrayList<SanPham> arr) {
        int dem = 0;
        for (SanPham SanPham : arr) {
            dem += this.delete(SanPham);
        }
        return dem;
    }

    @Override
    public int update(SanPham t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE sanpham " + " SET " + "tensanpham=?, matacgia=?, namxuatban=?, gianhap=?, giagoc=?, "
                         + "giaban=?, soluong=?, matheloai=?, ngonngu=?, mota=?" + " WHERE masanpham=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getTenSanPham());
            st.setString(2, t.getTacGia().getMaTacGia());
            st.setInt(3, t.getNamXuatBan());
            st.setDouble(4, t.getGiaNhap());
            st.setDouble(5, t.getGiaGoc());
            st.setDouble(6, t.getGiaBan());
            st.setDouble(7, t.getSoLuong());
            st.setString(8, t.getTheLoai().getMaTheLoai());
            st.setString(9, t.getNgonNgu());
            st.setString(10, t.getMoTa());
            st.setString(11, t.getMaSanPham());
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

    public boolean ktMaSanPham(String maSanPham) {
        boolean ketQua = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM sanpham WHERE masanpham=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, maSanPham);

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

    // Lấy ra tên thể loại theo mã thể loại
    public TheLoai getByID(TheLoai t) {
        TheLoai ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM theloai WHERE matheloai=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTheLoai());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maTheLoai = rs.getString("matheloai");
                String tenTheLoai = rs.getString("tentheloai");

                ketQua = new TheLoai(maTheLoai, tenTheLoai);
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

    public ArrayList<SanPham> getByMaTheLoai(String t) {
        ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM sanpham WHERE matheloai=?";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            st.setString(1, t);
            ResultSet rs = st.executeQuery();


            // Bước 4:
            while (rs.next()) {
                String matheloai = rs.getString("matheloai");
                String masanpham = rs.getString("masanpham");
                String tensanpham = rs.getString("tensanpham");
                String matacgia = rs.getString("matacgia");
                int namxuatban = rs.getInt("namxuatban");
                double gianhap = rs.getDouble("gianhap");
                double giagoc = rs.getDouble("giagoc");
                double giaban = rs.getDouble("giaban");
                int soluong = (int) rs.getDouble("soluong");
                String ngonngu = rs.getString("ngonngu");
                String mota = rs.getString("mota");

                TacGia tacGia = (new TacGiaDAO().selectByID(new TacGia(matacgia, "",
                        null, "","")));
                TheLoai theLoai = (new TheLoaiDAO().selectByID(new TheLoai(matheloai, "")));

                SanPham sp = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc,
                        giaban, soluong, theLoai, ngonngu, mota);
                ketQua.add(sp);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    public ArrayList<SanPham> SearchByValue(String t) {

        ArrayList<SanPham> ketQua = new ArrayList<SanPham>();

        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();
            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM bookweb.sanpham AS sp " +
                         "JOIN bookweb.tacgia AS tg ON sp.matacgia = tg.matacgia " +
                         "WHERE sp.tensanpham = ? OR tg.hovaten = ?";
            PreparedStatement st = con.prepareStatement(sql);
            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            st.setString(1, t);
            st.setString(2, t);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String masanpham = rs.getString("masanpham");
                String tensanpham = rs.getString("tensanpham");
                String matacgia = rs.getString("matacgia");
                int namxuatban = rs.getInt("namxuatban");
                double gianhap = rs.getDouble("gianhap");
                double giagoc = rs.getDouble("giagoc");
                double giaban = rs.getDouble("giaban");
                int soluong = rs.getInt("soluong");
                String matheloai = rs.getString("matheloai");
                String ngonngu = rs.getString("ngonngu");
                String mota = rs.getString("mota");
                String hovaten = rs.getString("hovaten");
                Date ngaySinh = rs.getDate("ngaysinh");
                String tieuSu = rs.getString("tieusu");
                String quocTich = rs.getString("quoctich");
                TacGia tacGia = new TacGiaDAO().selectByID(new TacGia(matacgia, "", null, "", ""));
                TheLoai theLoai = new TheLoaiDAO().selectByID(new TheLoai(matheloai, ""));

                SanPham sp = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong,
                        theLoai, ngonngu, mota);

                ketQua.add(sp);
            }
            // Bước 5:
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

//    public SanPham selectByName(String t) {
    public ArrayList<SanPham> selectByName(String t) {

        ArrayList<SanPham> ketQua = new ArrayList<SanPham>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM sanpham WHERE tensanpham=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String masanpham = rs.getString("masanpham");
                String tensanpham = rs.getString("tensanpham");
                String matacgia = rs.getString("matacgia");
                int namxuatban = rs.getInt("namxuatban");
                double gianhap = rs.getDouble("gianhap");
                double giagoc = rs.getDouble("giagoc");
                double giaban = rs.getDouble("giaban");
                int soluong = (int) rs.getDouble("soluong");
                String matheloai = rs.getString("matheloai");
                String ngonngu = rs.getString("ngonngu");
                String mota = rs.getString("mota");

                TacGia tacGia = (new TacGiaDAO().selectByID(new TacGia(matacgia, "", null,
                        "","")));
                TheLoai theLoai = (new TheLoaiDAO().selectByID(new TheLoai(matheloai, "")));

                SanPham sp = new  SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong,
                        theLoai, ngonngu, mota);
                ketQua.add(sp);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

//    public static void main(String[] args) {
//        SanPhamDAO dao = new SanPhamDAO();
//        String kk= "TL1";
//        ArrayList<SanPham> ketQua = dao.getByMaTheLoai(kk);
//        for (SanPham s : ketQua) {
//            System.out.println(s.toString());
//        }
//    }
//        SanPham sp = new SanPham("006", "Trăng sáng", "TG0001", 2000, 60, 70, 80, 100, "TL1", "truyen ngan", "VI");
//        dao.update(sp);
//    }
//        ArrayList<SanPham> ketQua = dao.selectAll();
//        for (SanPham s : ketQua) {
//            System.out.println(s.toString());
//        }
//    }
////        SanPham sanPham = new SanPham("SP005", "Conan", "TG0015",
////                2020, 150, 140, 200, 30,"TL3",
////                "truyen ", "VI");
////        dao.insert(sanPham);
////    }
}