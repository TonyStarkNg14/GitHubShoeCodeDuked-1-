package newprojectc.example.shoesapp_duked.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import newprojectc.example.shoesapp_duked.R;

public class Activity_QuanLySanPham extends AppCompatActivity {

    QuanLyGiay db;
    ArrayList<String> TenLoai;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapter;
    private static final int GALLERY_REQUEST_CODE = 100;
    private static final int PICK_IMAGE_REQUEST = 1;
    Button XacNhan, ThemHinhAnh;
    EditText TenGiay, Gia, Mota, NSX, SoLuong, MauSac, SizeGiay,gioitinh;
    private Bitmap selectedImageBitmap;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_san_pham);


        ThemHinhAnh = (Button) findViewById(R.id.btnHinhAnh);
        XacNhan = (Button) findViewById(R.id.btnXacNhanThemSP);
        imageView = (ImageView) findViewById(R.id.imageView2);

    gioitinh =findViewById(R.id.txtgioitinh);
        TenGiay = (EditText) findViewById(R.id.txtTenGiay);
        Gia = (EditText) findViewById(R.id.txtGiaBan);
        Mota = (EditText) findViewById(R.id.txtMoTa);
        NSX = (EditText) findViewById(R.id.txtNhaSanXuat);
        SoLuong = (EditText) findViewById(R.id.txtSoLuong);
        MauSac = (EditText) findViewById(R.id.txtMauSac);
        SizeGiay = (EditText) findViewById(R.id.txtSize);
        autoCompleteTextView = findViewById(R.id.aaaaa);


        db = new QuanLyGiay(Activity_QuanLySanPham.this);
        TenLoai = new ArrayList<>();
        StoreData();

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, TenLoai);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
            }
        });


        //NÚT XÁC NHẬN ĐỂ TẢI HÌNH ẢNH LÊN IMAGE VIEW
        ThemHinhAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });


        //NÚT THÊM SẢN PHẨM
        XacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                ItemGiay giay = new ItemGiay();

                QuanLyGiay quanLyGiay = new QuanLyGiay(Activity_QuanLySanPham.this);
                giay.setName(TenGiay.getText().toString());
                giay.setPrice(Integer.parseInt(Gia.getText().toString()));
                giay.setDes(Mota.getText().toString());
               // giay.setImg(bitmap.getPixel(300,300));
              //  Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                giay.setCategory(autoCompleteTextView.getText().toString());
                giay.setMaNSX(Integer.parseInt(NSX.getText().toString()));
                giay.setNBan(Integer.parseInt(SizeGiay.getText().toString()));
                giay.setSoLuongTonKho(Integer.parseInt(SoLuong.getText().toString()));
                giay.setGender(gioitinh.getText().toString());
                giay.setColor(MauSac.getText().toString());

                int kq  = quanLyGiay.AddGiay(giay);
                if(kq == -1)
                {
                    Toast.makeText(Activity_QuanLySanPham.this,"Khong them duoc",Toast.LENGTH_LONG).show();
                }
                if(kq == 1)
                {
                    Toast.makeText(Activity_QuanLySanPham.this,"Them thanh cong",Toast.LENGTH_LONG).show();
                }

            }
        });
    }



    //CHỨA DỮ LIỆU LOẠI
    public void  StoreData(){
        Cursor cursor = db.ReadDataLoai();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                TenLoai.add(cursor.getString(1));
            }
        }
    }



    //MỞ THƯ VIỆN CỦA ĐIỆN THOẠI
    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }



    //SET HÌNH ẢNH LÊN IMAGE VIEW
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            try {
                selectedImageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                // Resize bitmap to desired dimensions
                int newWidth = 300; // Example width
                int newHeight = 300; // Example height
                selectedImageBitmap = resizeBitmap(selectedImageBitmap, newWidth, newHeight);
                imageView.setImageBitmap(selectedImageBitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    //SET SIZE CHO HÌNH ẢNH
    private Bitmap resizeBitmap(Bitmap originalBitmap, int newWidth, int newHeight) {
        return Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, false);
    }


}