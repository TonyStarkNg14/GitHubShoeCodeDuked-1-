package newprojectc.example.shoesapp_duked.Activity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import newprojectc.example.shoesapp_duked.model.DonHang;
import newprojectc.example.shoesapp_duked.model.UserLogin;

public class QuanLyGiay {
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private Context context;

    public QuanLyGiay(Context context) {
        this.context = context;

        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();


    }
    public void saveGiay(ItemGiay giay, Bitmap image) {

        ContentValues cv = new ContentValues();
        cv.put("NAME", giay.getName());
        cv.put("PRICE", giay.getPrice());
        cv.put("price", giay.getPrice());
        cv.put("mota", giay.getDes());
       // cv.put("image", giay.getImg());
        cv.put("category", giay.getCategory());
        cv.put("MaNSX", giay.getMaNSX());
        cv.put("NBan", giay.getNBan());
        cv.put("SoLuongTonKho", giay.getSoLuongTonKho());
        cv.put("gender", giay.getGender());
        cv.put("color", giay.getColor());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imageBytes = baos.toByteArray();

        cv.put("IMAGE", imageBytes);
        db.insert("GIAY", null, cv);
        db.close();
    }
    public int AddGiay(ItemGiay giay)//them
    {
        ContentValues cv = new ContentValues();

        cv.put("name", giay.getName());
        cv.put("price", giay.getPrice());
        cv.put("mota", giay.getDes());
        cv.put("image", giay.getImg());
        cv.put("category", giay.getCategory());
        cv.put("MaNSX", giay.getMaNSX());
        cv.put("NBan", giay.getNBan());
        cv.put("SoLuongTonKho", giay.getSoLuongTonKho());
        cv.put("gender", giay.getGender());
        cv.put("color", giay.getColor());


        long check = db.insert("GIAY", null, cv);
        if (check == -1) {
            return -1;
        }
        return 1;

    }

    public int XoaGiay(String name) {
        int check = db.delete("GIAY", "name=?", new String[]{name});
        if (check <= 0) {
            return -1;
        }
        return 1;
    }

    public int SuaGiay(ItemGiay giay) {
        ContentValues cv = new ContentValues();

        cv.put("name", giay.getName());
        cv.put("price", giay.getPrice());
        cv.put("mota", giay.getDes());
        cv.put("image", giay.getImg());
        cv.put("category", giay.getCategory());
        cv.put("MaNSX", giay.getMaNSX());
        cv.put("NBan", giay.getNBan());
        cv.put("SoLuongTonKho", giay.getSoLuongTonKho());
        cv.put("gender", giay.getGender());
        cv.put("color", giay.getColor());


        long check = db.update("GIAY", cv, "name=?", new String[]{giay.getName()});
        if (check == -1) {
            return -1;
        }
        return 1;

    }

    public ArrayList<ItemGiay> getListGiay() {
        ArrayList<ItemGiay> list = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        try {
            Cursor c = db.rawQuery(" SELECT * FROM GIAY ", null);
            if (c.getCount() > 0) {
                c.moveToFirst();
                do {
                    list.add(new ItemGiay(c.getInt(0), c.getString(1), c.getInt(2), c.getString(3), c.getInt(4), c.getString(5), c.getInt(6), c.getInt(7), c.getInt(8), c.getString(9), c.getString(10)));
                } while (c.moveToNext());
            }
        } catch (Exception e) {


            Log.e("Tag", e.getMessage());

        }
        return list;
    }

    public ArrayList<ItemGiay> getAllGiay() {
        ArrayList<ItemGiay> list = new ArrayList<>();
        Cursor c = db.query("GIAY", null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            ItemGiay giay = new ItemGiay();
            giay.setId(c.getInt(0));
            giay.setName(c.getString(1));
            giay.setPrice(c.getInt(2));
            giay.setDes(c.getString(3));
            giay.setImg(c.getInt(4));
            giay.setCategory(c.getString(5));
            giay.setMaNSX(c.getInt(6));
            giay.setNBan(c.getInt(7));
            giay.setSoLuongTonKho(c.getInt(8));
            giay.setGender(c.getString(9));
            giay.setColor(c.getString(10));


            String chuoi = giay.getId() + "-" + giay.getName() + "-" + giay.getPrice() + "-" + giay.getDes() + "-"
                    + giay.getImg() + "-" + giay.getCategory() + "-" + giay.getMaNSX() + "-" + giay.getNBan() + "-"
                    + giay.getSoLuongTonKho() + "-" + giay.getGender() + "-" + giay.getColor() + "-";
            list.add(giay);
            c.moveToNext();
        }
        c.close();

        return list;

    }


    public void addUser(UserLogin user) {
        ContentValues values = new ContentValues();
        values.put("NAME", user.getUserName());
        values.put("EMAIL", user.getEmail());
        values.put("PHONE", user.getPassword());
        values.put("ADDRESS", user.getAddress());
        values.put("PASSWORD", user.getPassword());
        values.put("GIOITINH", user.getGioiTinh());
        db.insert("USER", null, values);
        db.close();
    }

    public void updateUser(UserLogin user) {
        //create content values to insert
        ContentValues values = new ContentValues();
        values.put("NAME", user.getUserName());
        values.put("PHONE", user.getPassword());
        values.put("ADDRESS", user.getAddress());
        values.put("PASSWORD", user.getPassword());
        values.put("GIOITINH", user.getGioiTinh());
        db.update("USER", values, "EMAIL" + " = ?", new String[]{user.getEmail()});
        db.close();
    }


    public UserLogin Authenticate(UserLogin user) {
        Cursor cursor = db.query("USER",// Selecting Table
                new String[]{"ID", "NAME", "EMAIL", "PHONE", "ADDRESS", "PASSWORD", "GIOITINH"},//Selecting columns want to query
                "EMAIL" + "=?",
                new String[]{user.getEmail()},//Where clause
                null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            //if cursor has value then in user database there is user associated with this given email
            UserLogin user1 = new UserLogin(
                    cursor.getInt(0)
                    , cursor.getString(1)
                    , cursor.getString(2)
                    , cursor.getString(5)
                    , cursor.getString(3)
                    , cursor.getString(4)
                    , cursor.getInt(6));
            //Match both passwords check they are same or not
            if (user.getPassword().equalsIgnoreCase(user1.getPassword())) {
                return user1;
            }
        }
        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    public boolean isEmailExists(String email) {
        Cursor cursor = db.query("USER",// Selecting Table
                new String[]{"ID", "NAME", "EMAIL", "PASSWORD"},//Selecting columns want to query
                "EMAIL" + "=?",
                new String[]{email},//Where clause
                null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            //if cursor has value then in user database there is user associated with this given email so return true
            return true;
        }
        //if email does not exist return false
        return false;
    }
    public Admin isAdmin(Admin admin) {
        Cursor cursor = db.query("Admin",// Selecting Table
                new String[]{"MaAdmin", "HoTenAdmin", "DiaChiAdmin", "DienThoaiAdmin", "TENDNAdmin", "MatKhauAdmin", "NgaySinhAdmin", "GioiTinhAdmin", "EmailAdmin"},//Selecting columns want to query
                "TENDNAdmin" + "=?",
                new String[]{admin.getTenDNAdmin()},//Where clause
                null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            //if cursor has value then in user database there is user associated with this given email
            Admin admin1 = new Admin(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8));
            //Match both passwords check they are same or not
            if (admin.getMatKhauAdmin().equalsIgnoreCase(admin1.getMatKhauAdmin())) {
                return admin1;
            }
        }
        return null;
    }

    public Boolean checkusername (String TenDangNhap){

        Cursor cursor = db.rawQuery("SELECT * FROM Admin where TENDNAdmin = ?", new String[] {TenDangNhap});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }



    public Boolean checkpassword (String password){

        Cursor cursor = db.rawQuery("SELECT * FROM Admin where MatKhauAdmin = ?", new String[] {password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public ArrayList<DonHang> getLichSuMuaHang() {
        ArrayList<DonHang> donHangs = new ArrayList<>();
        //String query = "SELECT * FROM DONHANG  WHERE "+ SONG_KEY_TYPE +" LIKE '%" + querySeach +"%'" ;
        String query = "SELECT * FROM DONHANG ORDER BY NGAYDH ASC";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            DonHang donHang = new DonHang(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11));
            donHangs.add(donHang);
            cursor.moveToNext();
        }
        return donHangs;
    }

    public ArrayList<ItemGiay> getGiaySport() {
        ArrayList<ItemGiay> giay = new ArrayList<>();
        //String query = "SELECT * FROM DONHANG  WHERE "+ SONG_KEY_TYPE +" LIKE '%" + querySeach +"%'" ;
        String query = "SELECT * From GIAY WHERE CATEGORY = 'Sport' ORDER BY PRICE ASC";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            ItemGiay giays = new ItemGiay(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(5),
                    cursor.getInt(6),
                    cursor.getInt(7),
                    cursor.getInt(8),
                    cursor.getString(9),
                    cursor.getString(10));
            giay.add(giays);
            cursor.moveToNext();
        }
        return giay;
    }

    public ArrayList<ItemGiay> getGiayGymer() {
        ArrayList<ItemGiay> giay = new ArrayList<>();
        //String query = "SELECT * FROM DONHANG  WHERE "+ SONG_KEY_TYPE +" LIKE '%" + querySeach +"%'" ;
        String query = "SELECT * From GIAY WHERE CATEGORY = 'Gym' ORDER BY PRICE ASC";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            ItemGiay giays = new ItemGiay(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(5),
                    cursor.getInt(6),
                    cursor.getInt(7),
                    cursor.getInt(8),
                    cursor.getString(9),
                    cursor.getString(10));
            giay.add(giays);
            cursor.moveToNext();
        }
        return giay;
    }

    public ArrayList<ItemGiay> getGiayRunning() {
        ArrayList<ItemGiay> giay = new ArrayList<>();
        //String query = "SELECT * FROM DONHANG  WHERE "+ SONG_KEY_TYPE +" LIKE '%" + querySeach +"%'" ;
        String query = "SELECT * From GIAY WHERE CATEGORY = 'Running' ORDER BY PRICE ASC";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            ItemGiay giays = new ItemGiay(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(5),
                    cursor.getInt(6),
                    cursor.getInt(7),
                    cursor.getInt(8),
                    cursor.getString(9),
                    cursor.getString(10));
            giay.add(giays);
            cursor.moveToNext();
        }
        return giay;
    }

    public ArrayList<ItemGiay> getGiayBongDa() {
        ArrayList<ItemGiay> giay = new ArrayList<>();
        //String query = "SELECT * FROM DONHANG  WHERE "+ SONG_KEY_TYPE +" LIKE '%" + querySeach +"%'" ;
        String query = "SELECT * From GIAY WHERE CATEGORY = 'Soccer' ORDER BY PRICE ASC";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            ItemGiay giays = new ItemGiay(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(5),
                    cursor.getInt(6),
                    cursor.getInt(7),
                    cursor.getInt(8),
                    cursor.getString(9),
                    cursor.getString(10));
            giay.add(giays);
            cursor.moveToNext();
        }
        return giay;
    }

    public void setDonHang(ItemGiay giay)//them
    {
        ContentValues cv = new ContentValues();
        int quantity = 1;
        cv.put("id", giay.getId());


        cv.put("quantity", quantity);

        cv.put("price", giay.getPrice());
        db.insert("CTDATHANG", null, cv);
        db.close();
    //MADH,MAGIAY,SOLUONG,DONGIA,TIEN
    }

    public ArrayList<ItemGiay> getCTDonHang() {
        ArrayList<ItemGiay> giay = new ArrayList<>();
        //String query = "SELECT * FROM DONHANG  WHERE "+ SONG_KEY_TYPE +" LIKE '%" + querySeach +"%'" ;
        String query = "SELECT * From CTDATHANG ORDER BY PRICE ASC";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            ItemGiay giays = new ItemGiay(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(5),
                    cursor.getInt(6),
                    cursor.getInt(7),
                    cursor.getInt(8),
                    cursor.getString(9),
                    cursor.getString(10));
            giay.add(giays);
            cursor.moveToNext();
        }
        return giay;
    }



    //----------------------------------XỬ LÝ DỮ LIỆU BẢNG LOẠI----------------------------------------------------
    //HÀM ADD TÊN LOẠI
    public int AddLoai(LoaiGiay loaiGiay){

        ContentValues cv = new ContentValues();
        cv.put("MaLoai", loaiGiay.getMaLoai());
        cv.put("TenLoaiGiay", loaiGiay.getTenLoaiGiay());
        cv.put("TenHinh", loaiGiay.getTenHinh());
        cv.put("TenCot", loaiGiay.getTenCot());
        long result =  db.insert("LoaiGiay", null, cv);
        if(result == -1){
            Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
        }
        return 1;
    }
    //HÀM UPDATE TÊN LOẠI
    public int updateLoai(String MaLoai) {
       LoaiGiay loaiGiay = new LoaiGiay();
        ContentValues cv = new ContentValues();
        cv.put("MaLoai", loaiGiay.getMaLoai());
        cv.put("TenLoaiGiay", loaiGiay.getTenLoaiGiay());
        cv.put("TenHinh", loaiGiay.getTenHinh());
        cv.put("TenCot", loaiGiay.getTenCot());
        int rowsAffected = db.update("LoaiGiay", cv, "MaLoai" + "=?", new String[]{String.valueOf(loaiGiay.getMaLoai())});
        if (rowsAffected > 0) {
            Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
        }
        return rowsAffected;
    }


    //HÀM XÓA TENLOAI
    public void deleteLoai(String MaLoai) {
        LoaiGiay loaiGiay = new LoaiGiay();
        int rowsAffected = db.delete("LoaiGiay", "MaLoai" + "=?", new String[]{String.valueOf(loaiGiay.getMaLoai())});
        if (rowsAffected > 0) {
            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
        }
    }



    //ĐỌC DỮ LIỆU BẢNG LOẠI
    public Cursor ReadDataLoai(){
        String query = "SELECT * FROM " + "LoaiGiay";

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


    //-----------------------------------XỬ LÝ DỮ LIỆU BẢNG HÃNG SẢN XUẤT----------------------------------
    //HÀM ADD TÊN HÃNG SẢN XUẤT
    public int AddHangSanXuat(NhaSanXuat nhaSanXuat){
        // String sqlNhaSanXuat = " CREATE TABLE NhaSanXuat " + "(" + "MaNSX INTEGER PRIMARY KEY , " + " TeenNSX TEXT, " +
        //                "DiaChi TEXT, " + " DienThoai INTEGER"  + ")";
        ContentValues cv = new ContentValues();
        cv.put("MaNSX", nhaSanXuat.getMaNSX());
        cv.put("TenNSX", nhaSanXuat.getTenNSX());
        cv.put("DiaChi", nhaSanXuat.getDiaChi());
        cv.put("DienThoai", nhaSanXuat.getDiaChi());

        long result =  db.insert("NhaSanXuat", null, cv);
        if(result == -1){
            Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
        }
        return 1;
    }



    //ĐỌC DỮ LIỆU BẢNG HÃNG SẢN XUẤT
    public Cursor ReadDataHSX(){
        String query = "SELECT * FROM " + "NhaSanXuat";


        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }



    //XÓA DỮ LIỆU BẢNG HÃNG SẢN XUẤT
    public void deleteHangSanXuat(String maNSX) {
       NhaSanXuat sanXuat = new NhaSanXuat();
        long result = db.delete("NhaSanXuat", "maNSX" + "=?", new String[]{String.valueOf(sanXuat.getMaNSX())});
        if (result == -1) {
            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }
    }



    //SỬA DỮ LIỆU BẢNG HÃNG SẢN XUẤT
    public int updateHangSanXuat(NhaSanXuat  nhaSanXuat) {

        ContentValues cv = new ContentValues();
        cv.put("MaNSX", nhaSanXuat.getMaNSX());
        cv.put("TenNSX", nhaSanXuat.getTenNSX());
        cv.put("DiaChi", nhaSanXuat.getDiaChi());
        cv.put("DienThoai", nhaSanXuat.getDiaChi());
        long result = db.update("NhaSanXuat", cv, "MaNSX" + "=?", new String[]{String.valueOf(nhaSanXuat.getMaNSX())});
        if (result == -1) {
            Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
        }
        return 1;
    }

}
