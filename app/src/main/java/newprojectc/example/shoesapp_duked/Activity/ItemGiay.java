package newprojectc.example.shoesapp_duked.Activity;

import android.graphics.Bitmap;

public class ItemGiay {
    private int id;
    private String name;
    private int price;
    private String des;
    private int img;
    private String category;
    private int MaNSX;
    private int NBan;
    private int SoLuongTonKho;
    private String gender;
    private String color;

    public ItemGiay(int id, String name, int price, String des, int img, String category, int maNSX, int NBan, int soLuongTonKho, String gender, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.des = des;
        this.img = img;
        this.category = category;
        MaNSX = maNSX;
        this.NBan = NBan;
        SoLuongTonKho = soLuongTonKho;
        this.gender = gender;
        this.color = color;
    }

    public ItemGiay() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
       this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMaNSX() {
        return MaNSX;
    }

    public void setMaNSX(int maNSX) {
        MaNSX = maNSX;
    }

    public int getNBan() {
        return NBan;
    }

    public void setNBan(int NBan) {
        this.NBan = NBan;
    }

    public int getSoLuongTonKho() {
        return SoLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        SoLuongTonKho = soLuongTonKho;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ItemGiay{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", des='" + des + '\'' +
                ", img=" + img +
                ", category='" + category + '\'' +
                ", MaNSX=" + MaNSX +
                ", NBan=" + NBan +
                ", SoLuongTonKho=" + SoLuongTonKho +
                ", gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
