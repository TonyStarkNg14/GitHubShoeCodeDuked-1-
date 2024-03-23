package newprojectc.example.shoesapp_duked.Activity;

public class Admin {

    private int MaAdmin;
    private String HotenAdmin;
    private String DiaChiAdmin;
    private int DienThoaiAdmin;
    private String TenDNAdmin;
    private String MatKhauAdmin;
    private String NgaySinhAdmin;
    private String GioiTinhAdmin;
    private String EmailAdmin;


    public Admin() {
    }

    public Admin(int maAdmin, String hotenAdmin, String diaChiAdmin, int dienThoaiAdmin, String tenDNAdmin, String matKhauAdmin, String ngaySinhAdmin, String gioiTinhAdmin, String emailAdmin) {
        MaAdmin = maAdmin;
        HotenAdmin = hotenAdmin;
        DiaChiAdmin = diaChiAdmin;
        DienThoaiAdmin = dienThoaiAdmin;
        TenDNAdmin = tenDNAdmin;
        MatKhauAdmin = matKhauAdmin;
        NgaySinhAdmin = ngaySinhAdmin;
        GioiTinhAdmin = gioiTinhAdmin;
        EmailAdmin = emailAdmin;
    }
    public Admin(String tenDNAdmin, String matKhauAdmin)
    {
        TenDNAdmin = tenDNAdmin;
        MatKhauAdmin = matKhauAdmin;
    }
    @Override
    public String toString() {
        return "Admin{" +
                "MaAdmin=" + MaAdmin +
                ", HotenAdmin='" + HotenAdmin + '\'' +
                ", DiaChiAdmin='" + DiaChiAdmin + '\'' +
                ", DienThoaiAdmin=" + DienThoaiAdmin +
                ", TenDNAdmin='" + TenDNAdmin + '\'' +
                ", MatKhauAdmin='" + MatKhauAdmin + '\'' +
                ", NgaySinhAdmin='" + NgaySinhAdmin + '\'' +
                ", GioiTinhAdmin='" + GioiTinhAdmin + '\'' +
                ", EmailAdmin='" + EmailAdmin + '\'' +
                '}';
    }

    public int getMaAdmin() {
        return MaAdmin;
    }

    public void setMaAdmin(int maAdmin) {
        MaAdmin = maAdmin;
    }

    public String getHotenAdmin() {
        return HotenAdmin;
    }

    public void setHotenAdmin(String hotenAdmin) {
        HotenAdmin = hotenAdmin;
    }

    public String getDiaChiAdmin() {
        return DiaChiAdmin;
    }

    public void setDiaChiAdmin(String diaChiAdmin) {
        DiaChiAdmin = diaChiAdmin;
    }

    public int getDienThoaiAdmin() {
        return DienThoaiAdmin;
    }

    public void setDienThoaiAdmin(int dienThoaiAdmin) {
        DienThoaiAdmin = dienThoaiAdmin;
    }

    public String getTenDNAdmin() {
        return TenDNAdmin;
    }

    public void setTenDNAdmin(String tenDNAdmin) {
        TenDNAdmin = tenDNAdmin;
    }

    public String getMatKhauAdmin() {
        return MatKhauAdmin;
    }

    public void setMatKhauAdmin(String matKhauAdmin) {
        MatKhauAdmin = matKhauAdmin;
    }

    public String getNgaySinhAdmin() {
        return NgaySinhAdmin;
    }

    public void setNgaySinhAdmin(String ngaySinhAdmin) {
        NgaySinhAdmin = ngaySinhAdmin;
    }

    public String getGioiTinhAdmin() {
        return GioiTinhAdmin;
    }

    public void setGioiTinhAdmin(String gioiTinhAdmin) {
        GioiTinhAdmin = gioiTinhAdmin;
    }

    public String getEmailAdmin() {
        return EmailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        EmailAdmin = emailAdmin;
    }
}
