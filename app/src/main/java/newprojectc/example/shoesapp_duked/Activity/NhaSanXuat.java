package newprojectc.example.shoesapp_duked.Activity;

public class NhaSanXuat {
    // String sqlNhaSanXuat = " CREATE TABLE NhaSanXuat " + "(" + "MaNSX INTEGER PRIMARY KEY , " + " TeenNSX TEXT, " +
    //                "DiaChi TEXT, " + " DienThoai INTEGER"  + ")";
    private int MaNSX;
    private String tenNSX;
    private String DiaChi;
    private int DienThoai;

    @Override
    public String toString() {
        return "NhaSanXuat{" +
                "MaNSX=" + MaNSX +
                ", tenNSX='" + tenNSX + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", DienThoai=" + DienThoai +
                '}';
    }

    public int getMaNSX() {
        return MaNSX;
    }

    public void setMaNSX(int maNSX) {
        MaNSX = maNSX;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public int getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(int dienThoai) {
        DienThoai = dienThoai;
    }

    public NhaSanXuat() {
    }

    public NhaSanXuat(int maNSX, String tenNSX, String diaChi, int dienThoai) {
        MaNSX = maNSX;
        this.tenNSX = tenNSX;
        DiaChi = diaChi;
        DienThoai = dienThoai;
    }
}
