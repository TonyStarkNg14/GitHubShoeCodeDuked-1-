package newprojectc.example.shoesapp_duked.Activity;

public class CTDonHang {
    private int MaDH;
    private int MaGiay;
    private int SoLuong;
    private int dongia;
    private int tien;

    public int getMaDH() {
        return MaDH;
    }

    public void setMaDH(int maDH) {
        MaDH = maDH;
    }

    public int getMaGiay() {
        return MaGiay;
    }

    public void setMaGiay(int maGiay) {
        MaGiay = maGiay;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }

    public CTDonHang(int maDH, int maGiay, int soLuong, int dongia, int tien) {
        MaDH = maDH;
        MaGiay = maGiay;
        SoLuong = soLuong;
        this.dongia = dongia;
        this.tien = tien;
    }

    public CTDonHang() {
    }

    @Override
    public String toString() {
        return "CTDonHang{" +
                "MaDH=" + MaDH +
                ", MaGiay=" + MaGiay +
                ", SoLuong=" + SoLuong +
                ", dongia=" + dongia +
                ", tien=" + tien +
                '}';
    }
}
