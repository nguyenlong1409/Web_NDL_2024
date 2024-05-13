package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia> {
    @Override
    public ArrayList<TacGia> chonTatCa() {
        ArrayList<TacGia> ketQua = new ArrayList<TacGia>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM tacgia";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maTacGia = rs.getString("matacgia");
                String hoVaTen = rs.getString("hovaten");
                Date ngaySinh = rs.getDate("ngaysinh");
                String tieuSu = rs.getString("tieusu");
                String quocTich = rs.getString("quoctich");

                TacGia tg = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu, quocTich);
                ketQua.add(tg);
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
    public TacGia chonTheoMa(TacGia t) {
        TacGia ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM tacgia WHERE matacgia=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maTacGia = rs.getString("matacgia");
                String hoVaTen = rs.getString("hovaten");
                Date ngaySinh = rs.getDate("ngaysinh");
                String tieuSu = rs.getString("tieusu");
                String quocTich = rs.getString("quoctich");

                ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu, quocTich);
                break;
            }
            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int chenTT(TacGia t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO tacgia (matacgia, hovaten, ngaysinh, tieusu, quoctich) " +
                         " VALUES (?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());
            st.setString(2, t.getTenTacGia());
            st.setDate(3, t.getNgaySinh());
            st.setString(4, t.getTieuSu());
            st.setString(5, t.getQuocTich());

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
    public int insertAll(ArrayList<TacGia> arr) {
        int dem = 0;
        for (TacGia tacGia : arr) {
            dem += this.chenTT(tacGia);
        }
        return dem;
    }

    @Override
    public int xoaTT(TacGia t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from tacgia " +
                         " WHERE matacgia=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());

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
    public int deleteAll(ArrayList<TacGia> arr) {
        int dem = 0;
        for (TacGia tacGia : arr) {
            dem += this.xoaTT(tacGia);
        }
        return dem;
    }

    @Override
    public int capNhatTT(TacGia t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE tacgia " +
                         " SET " +
                         " hovaten=?" +
                         ", ngaysinh=?" +
                         ", tieusu=?" +
                         ", quoctich=?" +
                         " WHERE matacgia=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getTenTacGia());
            st.setDate(2, t.getNgaySinh());
            st.setString(3, t.getTieuSu());
            st.setString(4, t.getQuocTich());
            st.setString(5, t.getMaTacGia());
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

    public TacGia selectByIDorName(TacGia t) {
        TacGia ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM tacgia WHERE matacgia=? or hovaten=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maTacGia = rs.getString("matacgia");
                String hoVaTen = rs.getString("hovaten");
                Date ngaySinh = rs.getDate("ngaysinh");
                String tieuSu = rs.getString("tieusu");
                String quocTich = rs.getString("quoctich");

                ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu, quocTich);
                break;
            }
            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }


//    public static void main(String[] args) {
//        TacGiaDAO tgd = new TacGiaDAO();
////		ArrayList<TacGia> kq = tgd.chonTatCa();
////		for (TacGia tacGia : kq) {
////			System.out.println(tacGia.toString());
////		}
////
////
////		TacGia tg = tgd.selectById(new TacGia("TG1", "", null, ""));
////		System.out.println(tg);
////
//
////		TacGia tg_new = new TacGia("TG10", "David", new Date(2000-1900, 10, 15), "");
////		tgd.chenTT(tg_new);
//
////		TacGia tg_new = new TacGia("TG10", "David", new Date(2000-1900, 10, 15), "");
////		tgd.xoaTT(tg_new);
//
//
//        TacGia tg = tgd.chonTatCa(new TacGia("TG0001", "", null, "",""));
//        System.out.println(tg);
//        tg.setTieuSu("TIỂU SỬ ĐÃ BỊ THAY ĐỔI");
//
//        tgd.capNhatTT(tg);
//    }

}