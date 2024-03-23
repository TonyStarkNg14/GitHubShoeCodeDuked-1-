package newprojectc.example.shoesapp_duked.Activity;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.ByteArrayOutputStream;

import newprojectc.example.shoesapp_duked.R;

public class DBHelper extends SQLiteOpenHelper {


    private Resources resources;
    private Object context;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DBHelper(Context context) {
        super(context, "QLGiay.db", null, 1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE GIAY " + "(" + "ID INTEGER PRIMARY KEY AUTOINCREMENT, " + " NAME TEXT, " +
                "PRICE INT, " + " MOTA TEXT," + " IMAGE BLOB, " + " CATEGORY TEXT,"
                + " NSX INTEGER , " + "NGAYBAN TEXT,  " + " SOLUONGTONKHO INTEGER, " + " GENDER TEXT, " + " COLOR TEXT" + ")";


        String sqlUser = " CREATE TABLE USER " + "(" + "ID INTEGER PRIMARY KEY AUTOINCREMENT, " + " NAME TEXT, " +
                "EMAIL TEXT, " + " PHONE TEXT," + " ADDRESS TEXT, " + " PASSWORD TEXT,"
                + " GIOITINH INTEGER" + ")";


        String sqlDonHang = " CREATE TABLE DONHANG " + "(" + "MADH INTEGER PRIMARY KEY AUTOINCREMENT, " + " MAKH INTEGER, " +
                "NGAYDH INTEGER, " + " TONGTIEN INTEGER," + " TRANGTHAI TEXT, " + " NGAYGIAO INTEGER," + " TENNGUOINHAN TEXT," + " DIACHINGUOINHAN TEXT," + " SODIENTHOAI TEXT,"
                + " MATHANHTOAN TEXT," + " HINHTHUC TEXT," + " HINHTHUCGH TEXT" + ")";

        String sqlComment = " CREATE TABLE Comment " + "(" + " MaComment INTEGER PRIMARY KEY AUTOINCREMENT, " + " MAKH INTEGER, " +
                "NoiDung TEXT, " + " MaSP INTEGER," + " ThoiGian TEXT, " + " Thich INTEGER" + ")";
        String sqlLoaiGiay = " CREATE TABLE LoaiGiay " + "(" + "MaLoai INTEGER PRIMARY KEY , " + " TenLoaiGiay TEXT, " +
                "TenHinh BLOB, " + " TenCot INTEGER" +  ")";
        String sqlLogo = " CREATE TABLE Logo " + "(" + "MaLogo INTEGER PRIMARY KEY , " + " NgayCapphat TEXT, " +
                "Hinh BLOB, " + " TrangThai TEXT," + " TRANGTHAI TEXT " +  ")";
        String sqlMaQr = " CREATE TABLE MaQr " + "(" + "IdMa INTEGER PRIMARY KEY , " + " IdGiay INTEGER "  + ")";
        String sqlNhaSanXuat = " CREATE TABLE NhaSanXuat " + "(" + "MaNSX INTEGER PRIMARY KEY , " + " TeenNSX TEXT, " +
                "DiaChi TEXT, " + " DienThoai INTEGER"  + ")";
        String sqlRate = " CREATE TABLE Rate " + "(" + "MaRate INTEGER PRIMARY KEY , " + " NgayCapNhat TEXT, " +
                "MaKH INTEGER, " + " MaGiay INTEGER," + " SoSao INTEGER, " + " NhanXet TEXT"  + ")";
        String sqlAdmin = " CREATE TABLE Admin " + "(" + "MaAdmin INTEGER PRIMARY KEY AUTOINCREMENT, " + " HoTenAdmin TEXT, " +
                "DiaChiAdmin TEXT, " + " DienThoaiAdmin INTEGER," + " TENDNAdmin TEXT, " + " MatKhauAdmin TEXT," + " NgaySinhAdmin TEXT," +
                " GioiTinhAdmin TEXT," + " EmailAdmin TEXT"
               + ")";
        String insert99 = " INSERT INTO Admin (MaAdmin,HoTenAdmin,DiaChiAdmin,DienThoaiAdmin,TENDNAdmin,MatKhauAdmin,NgaySinhAdmin,GioiTinhAdmin,EmailAdmin) " +
                "VALUES (NULL,'Tony','Great Britain',0888888884,'aaa','aaa',08032004,'Bede','www.admindeptraiqua@gmail.com');";
        String insert991 = " INSERT INTO Admin (MaAdmin,HoTenAdmin,DiaChiAdmin,DienThoaiAdmin,TENDNAdmin,MatKhauAdmin,NgaySinhAdmin,GioiTinhAdmin,EmailAdmin) " +
                "VALUES (NULL,'Tony','Great Britain',0888888884,'222','1',08032004,'Bede','www.admindeptraiqua@gmail.com');";

        db.execSQL(insert991);
        String insert21 = " INSERT INTO DONHANG (MADH,MAKH,NGAYDH,TONGTIEN,TRANGTHAI,NGAYGIAO,TENNGUOINHAN,DIACHINGUOINHAN,SODIENTHOAI,MATHANHTOAN,HINHTHUC,HINHTHUCGH) " +
                "VALUES (NULL,1,20240101,2500,'SUCCESS',20240102,'Hoang AKA','Hue','0345678232','ACBSSD','ONLINE','SHIPPER');";

        String insert22 = " INSERT INTO DONHANG (MADH,MAKH,NGAYDH,TONGTIEN,TRANGTHAI,NGAYGIAO,TENNGUOINHAN,DIACHINGUOINHAN,SODIENTHOAI,MATHANHTOAN,HINHTHUC,HINHTHUCGH) " +
                "VALUES (NULL,1,20240102,2500,'SUCCESS',20240103,'Hoang AKA','Hue','0345678232','ACBSSD','ONLINE','SHIPPER');";

        String insert23 = " INSERT INTO DONHANG (MADH,MAKH,NGAYDH,TONGTIEN,TRANGTHAI,NGAYGIAO,TENNGUOINHAN,DIACHINGUOINHAN,SODIENTHOAI,MATHANHTOAN,HINHTHUC,HINHTHUCGH) " +
                "VALUES (NULL,1,20240103,2500,'SUCCESS',20240104,'Hoang AKA','Hue','0345678232','ACBSSD','ONLINE','SHIPPER');";

        String insert24 = " INSERT INTO DONHANG (MADH,MAKH,NGAYDH,TONGTIEN,TRANGTHAI,NGAYGIAO,TENNGUOINHAN,DIACHINGUOINHAN,SODIENTHOAI,MATHANHTOAN,HINHTHUC,HINHTHUCGH) " +
                "VALUES (NULL,1,20240104,2500,'SUCCESS',20240105,'Hoang AKA','Hue','0345678232','ACBSSD','ONLINE','SHIPPER');";

        String insert25 = " INSERT INTO DONHANG (MADH,MAKH,NGAYDH,TONGTIEN,TRANGTHAI,NGAYGIAO,TENNGUOINHAN,DIACHINGUOINHAN,SODIENTHOAI,MATHANHTOAN,HINHTHUC,HINHTHUCGH) " +
                "VALUES (NULL,1,20240105,2500,'SUCCESS',20240106,'Hoang AKA','Hue','0345678232','ACBSSD','ONLINE','SHIPPER');";

        String insert26 = " INSERT INTO DONHANG (MADH,MAKH,NGAYDH,TONGTIEN,TRANGTHAI,NGAYGIAO,TENNGUOINHAN,DIACHINGUOINHAN,SODIENTHOAI,MATHANHTOAN,HINHTHUC,HINHTHUCGH) " +
                "VALUES (NULL,1,20240106,2500,'SUCCESS',20240107,'Hoang AKA','Hue','0345678232','ACBSSD','ONLINE','SHIPPER');";

        String insert27 = " INSERT INTO DONHANG (MADH,MAKH,NGAYDH,TONGTIEN,TRANGTHAI,NGAYGIAO,TENNGUOINHAN,DIACHINGUOINHAN,SODIENTHOAI,MATHANHTOAN,HINHTHUC,HINHTHUCGH) " +
                "VALUES (NULL,1,20240107,2500,'SUCCESS',20240108,'Hoang AKA','Hue','0345678232','ACBSSD','ONLINE','SHIPPER');";

        String insert28 = " INSERT INTO DONHANG (MADH,MAKH,NGAYDH,TONGTIEN,TRANGTHAI,NGAYGIAO,TENNGUOINHAN,DIACHINGUOINHAN,SODIENTHOAI,MATHANHTOAN,HINHTHUC,HINHTHUCGH) " +
                "VALUES (NULL,1,20240108,2500,'SUCCESS',20240109,'Hoang AKA','Hue','0345678232','ACBSSD','ONLINE','SHIPPER');";

        String insert29 = " INSERT INTO DONHANG (MADH,MAKH,NGAYDH,TONGTIEN,TRANGTHAI,NGAYGIAO,TENNGUOINHAN,DIACHINGUOINHAN,SODIENTHOAI,MATHANHTOAN,HINHTHUC,HINHTHUCGH) " +
                "VALUES (NULL,1,20240109,2500,'SUCCESS',20240110,'Hoang AKA','Hue','0345678232','ACBSSD','ONLINE','SHIPPER');";


        String sqlCTDH = " CREATE TABLE CTDATHANG " + "(" + "MADH INTEGER , " + " MAGIAY INTEGER, " +
                "SOLUONG INTEGER, " + " DONGIA INTEGER," + " TIEN INTEGER " + ")";

        String insert30 = " INSERT INTO CTDATHANG (MADH,MAGIAY,SOLUONG,DONGIA,TIEN) " +
                "VALUES (1,1,1,2500,2500);";

        String insert31 = " INSERT INTO CTDATHANG (MADH,MAGIAY,SOLUONG,DONGIA,TIEN) " +
                "VALUES (2,1,1,2500,2500);";
        String insert32 = " INSERT INTO CTDATHANG (MADH,MAGIAY,SOLUONG,DONGIA,TIEN) " +
                "VALUES (3,1,1,2500,2500);";
        String insert33 = " INSERT INTO CTDATHANG (MADH,MAGIAY,SOLUONG,DONGIA,TIEN) " +
                "VALUES (4,1,1,2500,2500);";
        String insert34 = " INSERT INTO CTDATHANG (MADH,MAGIAY,SOLUONG,DONGIA,TIEN) " +
                "VALUES (5,1,1,2500,2500);";
        String insert35 = " INSERT INTO CTDATHANG (MADH,MAGIAY,SOLUONG,DONGIA,TIEN) " +
                "VALUES (6,1,1,2500,2500);";
        String insert36 = " INSERT INTO CTDATHANG (MADH,MAGIAY,SOLUONG,DONGIA,TIEN) " +
                "VALUES (7,1,1,2500,2500);";
        String insert37 = " INSERT INTO CTDATHANG (MADH,MAGIAY,SOLUONG,DONGIA,TIEN) " +
                "VALUES (8,1,1,2500,2500);";

        String insert38 = " INSERT INTO CTDATHANG (MADH,MAGIAY,SOLUONG,DONGIA,TIEN) " +
                "VALUES (9,1,1,2500,2500);";


     String insert1 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE ARI FORCE 1',2500,NULL,NULL, 'Gym','NIKE',30022024,200,'MALE','BLACK');";

        db.execSQL(insert1);

        String insert2 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE ARI FORCE II',2600,NULL,NULL,'Gym','NIKE',30022024,150,'MALE','GOLD');";

        db.execSQL(insert2);



        String insert3 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE ARI FORCE III',2700,NULL,NULL,'Gym','NIKE',30022024,120,'FEMALE','PINK');";

        db.execSQL(insert3);

        String insert4 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE ARI FORCE IV',1900,NULL,'shoe13','Gym','NIKE',30022024,110,'FEMALE','GRAY');";
        ;

        String insert5 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE LEGEND I',1800,NULL,'shoe12','Sport','NIKE',30022024,200,'MALE','BLACK');";
        ;

        String insert6 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE LEGEND II',2000,NULL,'shoe61','Sport','NIKE',30022024,190,'MALE','GRAY');";
        ;

        String insert7 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE LEGEND III',1500,NULL,'shoe73','Sport','NIKE',30022024,70,'FEMALE','BLUE');";
        ;

        String insert8 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE LEGEND IV',1200,NULL,NULL,'Sport','NIKE',30022024,60,'FEMALE','MITE');";
        ;

        String insert9 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE INFINITY I',1800,NULL,NULL,'Running','NIKE',30022024,270,'MALE','BLACK');";
        ;

        String insert10 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE INFINITY II',1900,NULL,NULL,'Running','NIKE',30022024,10,'MALE','RED');";
        ;

        String insert11 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE INFINITY III',3000,NULL,NULL,'Running','NIKE',30022024,230,'FEMALE','ORANGE');";
        ;

        String insert12 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE INFINITY IV',9500,NULL,NULL,'Running','NIKE',30022024,40,'FEMALE','PURPLE');";
        ;

        String insert13 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE PHANTOM I',1200,NULL,NULL,'Soccer','NIKE',30022024,670,'MALE','WHITE');";
        ;

        String insert14 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE PHANTOM II',2500,NULL,NULL,'Soccer','NIKE',30022024,269,'MALE','YELLOW');";
        ;

        String insert15 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE PHANTOM III',1200,NULL,NULL,'Soccer','NIKE',30022024,69,'FEMALE','BROWN');";
        ;

        String insert16 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE PHANTOM IV',3500,NULL,NULL,'Soccer','NIKE',30022024,6969,'FEMALE','GREEN');";
        ;

        String insert17 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE ARI MAX I',600,NULL,NULL,'Walking','NIKE',30022024,50,'MALE','VIOLET');";
        ;

        String insert18 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE ARI MAX II',800,NULL,NULL,'Walking','NIKE',30022024,15,'MALE','INOX');";
        ;

        String insert19 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE ARI MAX III',400,NULL,NULL,'Walking','NIKE',30022024,60,'FEMALE','DRAX');";
        ;

        String insert20 = " INSERT INTO GIAY (ID,NAME,PRICE,MOTA,IMAGE,CATEGORY,NSX,NGAYBAN,SOLUONGTONKHO,GENDER,COLOR) " +
                "VALUES (NULL,'NIKE ARI MAX IV',700,NULL,NULL,'Walking','NIKE',30022024,80,'FEMALE','IRON');";
        ;
        db.execSQL(sql);
        db.execSQL(sqlUser);
        db.execSQL(sqlDonHang);
        db.execSQL(sqlCTDH);
       // db.execSQL(insert1);
        //db.execSQL(insert2);
        //db.execSQL(insert3);
        db.execSQL(insert4);
        db.execSQL(insert5);
        db.execSQL(insert6);
        db.execSQL(insert7);
        db.execSQL(insert8);
        db.execSQL(insert9);
        db.execSQL(insert10);
        db.execSQL(insert11);
        db.execSQL(insert12);
        db.execSQL(insert13);
        db.execSQL(insert14);
        db.execSQL(insert15);
        db.execSQL(insert16);
        db.execSQL(insert17);
        db.execSQL(insert18);
        db.execSQL(insert19);
        db.execSQL(insert20);

        db.execSQL(insert21);
        db.execSQL(insert22);
        db.execSQL(insert23);
        db.execSQL(insert24);
        db.execSQL(insert25);
        db.execSQL(insert26);
        db.execSQL(insert27);
        db.execSQL(insert28);
        db.execSQL(insert29);

        db.execSQL(insert30);
        db.execSQL(insert31);
        db.execSQL(insert32);
        db.execSQL(insert33);
        db.execSQL(insert34);
        db.execSQL(insert35);
        db.execSQL(insert36);
        db.execSQL(insert37);
        db.execSQL(insert38);
        db.execSQL(sqlComment);
        db.execSQL(sqlLoaiGiay);
        db.execSQL(sqlNhaSanXuat);
        db.execSQL(sqlRate);
        db.execSQL(sqlAdmin);
        db.execSQL(sqlLogo);
        db.execSQL(sqlMaQr);
        db.execSQL(insert99);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS GIAY ");
        db.execSQL(" DROP TABLE IF EXISTS USER ");
        db.execSQL(" DROP TABLE IF EXISTS DONHANG ");
        db.execSQL(" DROP TABLE IF EXISTS CTDATHANG ");
        db.execSQL(" DROP TABLE IF EXISTS  Comment");
        db.execSQL(" DROP TABLE IF EXISTS LoaiGiay ");
        db.execSQL(" DROP TABLE IF EXISTS Logo ");
        db.execSQL(" DROP TABLE IF EXISTS MaQr ");
        db.execSQL(" DROP TABLE IF EXISTS NhaSanXuat ");
        db.execSQL(" DROP TABLE IF EXISTS Rate ");
        db.execSQL(" DROP TABLE IF EXISTS Admin ");
        onCreate(db);
    }


    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }
}
