package Model;

import java.util.Date;
import java.util.Objects;

public class DonHang {

    private String maDonHang;
    private KhachHang khachHang;
    private String diaChiMuaHang;
    private String diaChiNhanHang;
    private String trangThai;
    private String hinhThucThanhToan;
    private String trangThaiThanhToan;
    private double soTienDaThanhToan;
    private double soTienConThieu;
    private Date ngayDatHang;
    private Date ngayGiaoHang;

    public DonHang() {
    }

    public DonHang(String maDH, KhachHang khachHang, String diaChiNguoiMua, String diaChiNhanHang, String trangThai, String hinhThucThanhToan, double soTienDaThanhToan, double soTienConThieu, java.sql.Date ngayDatHang, java.sql.Date ngayGiaoHang) {
    }

    public DonHang(String maDonHang, KhachHang khachHang, String diaChiMuaHang, String diaChiNhanHang, String trangThai,
                   String hinhThucThanhToan, String trangThaiThanhToan, double soTienConThieu, double soTienDaThanhToan,
                   Date ngayDatHang, Date ngayGiaoHang) {
        this.maDonHang = maDonHang;
        this.khachHang = khachHang;
        this.diaChiMuaHang = diaChiMuaHang;
        this.diaChiNhanHang = diaChiNhanHang;
        this.trangThai = trangThai;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.soTienConThieu = soTienConThieu;
        this.soTienDaThanhToan = soTienDaThanhToan;
        this.ngayDatHang = ngayDatHang;
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getDiaChiMuaHang() {
        return diaChiMuaHang;
    }

    public void setDiaChiMuaHang(String diaChiMuaHang) {
        this.diaChiMuaHang = diaChiMuaHang;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public double getSoTienDaThanhToan() {
        return soTienDaThanhToan;
    }

    public void setSoTienDaThanhToan(double soTienDaThanhToan) {
        this.soTienDaThanhToan = soTienDaThanhToan;
    }

    public java.sql.Date getNgayDatHang() {
        return (java.sql.Date) ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public double getSoTienConThieu() {
        return soTienConThieu;
    }

    public void setSoTienConThieu(double soTienConThieu) {
        this.soTienConThieu = soTienConThieu;
    }

    public java.sql.Date getNgayGiaoHang() {
        return (java.sql.Date) ngayGiaoHang;
    }

    public void setNgayGiaoHang(Date ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    @Override
    public String toString() {
        return "DonHang{" +
               "maDonHang='" + maDonHang + '\'' +
               ", khachHang=" + khachHang +
               ", diaChiMuaHang='" + diaChiMuaHang + '\'' +
               ", diaChiNhanHang='" + diaChiNhanHang + '\'' +
               ", trangThai='" + trangThai + '\'' +
               ", hinhThucThanhToan='" + hinhThucThanhToan + '\'' +
               ", trangThaiThanhToan='" + trangThaiThanhToan + '\'' +
               ", soTienDaThanhToan=" + soTienDaThanhToan +
               ", soTienConThieu=" + soTienConThieu +
               ", ngayDatHang=" + ngayDatHang +
               ", ngayGiaoHang=" + ngayGiaoHang +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonHang donHang = (DonHang) o;
        return Objects.equals(maDonHang, donHang.maDonHang);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(maDonHang);
    }
}
