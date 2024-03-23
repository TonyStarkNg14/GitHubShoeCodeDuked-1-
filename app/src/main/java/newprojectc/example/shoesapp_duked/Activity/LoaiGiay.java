package newprojectc.example.shoesapp_duked.Activity;

public class LoaiGiay {
    // String sqlLoaiGiay = " CREATE TABLE LoaiGiay " + "(" + "MaLoai INTEGER PRIMARY KEY , " + " TenLoaiGiay TEXT, " +
    //                "TenHinh BLOB, " + " TenCot INTEGER" +  ")";
    private int MaLoai;
    private String TenLoaiGiay;
    private int TenHinh;
    private int TenCot;

    public LoaiGiay() {
    }

    @Override
    public String toString() {
        return "LoaiGiay{" +
                "MaLoai=" + MaLoai +
                ", TenLoaiGiay='" + TenLoaiGiay + '\'' +
                ", TenHinh=" + TenHinh +
                ", TenCot=" + TenCot +
                '}';
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }

    public String getTenLoaiGiay() {
        return TenLoaiGiay;
    }

    public void setTenLoaiGiay(String tenLoaiGiay) {
        TenLoaiGiay = tenLoaiGiay;
    }

    public int getTenHinh() {
        return TenHinh;
    }

    public void setTenHinh(int tenHinh) {
        TenHinh = tenHinh;
    }

    public int getTenCot() {
        return TenCot;
    }

    public void setTenCot(int tenCot) {
        TenCot = tenCot;
    }

    public LoaiGiay(int maLoai, String tenLoaiGiay, int tenHinh, int tenCot) {
        MaLoai = maLoai;
        TenLoaiGiay = tenLoaiGiay;
        TenHinh = tenHinh;
        TenCot = tenCot;
    }
}
