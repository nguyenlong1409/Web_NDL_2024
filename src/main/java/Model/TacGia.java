package Model;

import java.util.Date;
import java.util.Objects;

public class TacGia {
    private String maTacGia;
    private String tenTacGia;
    private Date ngaySinh;
    private String tieuSu;
    private String quocTich;

    public TacGia() {
    }

    public TacGia(String maTacGia,String tenTacGia, Date ngaySinh, String tieuSu, String quocTich) {
        this.tenTacGia = tenTacGia;
        this.ngaySinh = ngaySinh;
        this.maTacGia = maTacGia;
        this.tieuSu = tieuSu;
        this.quocTich = quocTich;

    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public java.sql.Date getNgaySinh() {
        return (java.sql.Date) ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTieuSu() {
        return tieuSu;
    }

    public void setTieuSu(String tieuSu) {
        this.tieuSu = tieuSu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TacGia tacGia = (TacGia) o;
        return Objects.equals(maTacGia, tacGia.maTacGia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maTacGia, tenTacGia, ngaySinh, quocTich);
    }

    @Override
    public String toString() {
        return "TacGia{" +
               "maTacGia='" + maTacGia + '\'' +
               ", tenTacGia='" + tenTacGia + '\'' +
               ", ngaySinh=" + ngaySinh +
               ", quocTich='" + quocTich + '\'' +
               ", tieuSu='" + tieuSu + '\'' +
               '}';
    }
}
