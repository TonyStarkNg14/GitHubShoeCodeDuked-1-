package newprojectc.example.shoesapp_duked.model;
public class DonHang {
    private int maDh;
    private int maKh;
    private int ngayDat;
    private long tongtien;
    private String trangThai;
    private int ngayGiao;
    private String tenNguoiNhan;
    private String diachinhan;

    private String sdt;
    private String maThanhToan;
    private String hinhthuc;
    private String hinhthucgh;

    public DonHang(int maDh, int maKh, int ngayDat, long tongtien, String trangThai, int ngayGiao
            , String tenNguoiNhan, String diachinhan, String sdt, String maThanhToan, String hinhthuc, String hinhthucgh) {
        this.maDh = maDh;
        this.maKh = maKh;
        this.ngayDat = ngayDat;
        this.tongtien = tongtien;
        this.trangThai = trangThai;
        this.ngayGiao = ngayGiao;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diachinhan = diachinhan;
        this.sdt = sdt;
        this.maThanhToan = maThanhToan;
        this.hinhthuc = hinhthuc;
        this.hinhthucgh = hinhthucgh;
    }

    public int getMaDh() {
        return maDh;
    }

    public void setMaDh(int maDh) {
        this.maDh = maDh;
    }

    public int getMaKh() {
        return maKh;
    }

    public void setMaKh(int maKh) {
        this.maKh = maKh;
    }

    public int getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(int ngayDat) {
        this.ngayDat = ngayDat;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(int ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiachinhan() {
        return diachinhan;
    }

    public void setDiachinhan(String diachinhan) {
        this.diachinhan = diachinhan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public String getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }

    public String getHinhthucgh() {
        return hinhthucgh;
    }

    public void setHinhthucgh(String hinhthucgh) {
        this.hinhthucgh = hinhthucgh;
    }
}
