package Model;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private TacGia tacGia;
    private int namXuatBan;
    private double giaNhap;
    private double giaGoc;
    private double giaBan;
    private double soLuong;
    private TheLoai theLoai;
    private String ngonNgu;
    private String moTa;
    private String anhSP;


    public SanPham() {

    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public SanPham(String maSanPham, String tenSanPham, TacGia tacGia,
                   int namXuatBan, double giaNhap, double giaGoc, double giaBan,
                   double soLuong, TheLoai theLoai, String ngonNgu, String moTa,
                   String anhSP) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.giaNhap = giaNhap;
        this.giaGoc = giaGoc;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.theLoai = theLoai;
        this.ngonNgu = ngonNgu;
        this.moTa = moTa;
        this.anhSP = anhSP;

    }

    public String getAnhSP() {
        return anhSP;
    }

    public void setAnhSP(String anhSP) {
        this.anhSP = anhSP;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public TacGia getTacGia() {
        return tacGia;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(double giaGoc) {
        this.giaGoc = giaGoc;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "SanPham{" +
               "maSanPham='" + maSanPham + '\'' +
               ", tenSanPham='" + tenSanPham + '\'' +
//               ", maTacGia='" + maTacGia + '\'' +
               ", tacGia=" + tacGia +
               ", namXuatBan=" + namXuatBan +
               ", giaNhap=" + giaNhap +
               ", giaGoc=" + giaGoc +
               ", giaBan=" + giaBan +
               ", soLuong=" + soLuong +
               ", theLoai=" + theLoai +
//               ", maTheLoai='" + maTheLoai + '\'' +
               ", ngonNgu='" + ngonNgu + '\'' +
               ", moTa='" + moTa + '\'' +
               '}';
    }
}
