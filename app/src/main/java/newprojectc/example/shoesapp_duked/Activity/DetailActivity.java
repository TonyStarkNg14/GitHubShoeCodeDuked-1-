package newprojectc.example.shoesapp_duked.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileOutputStream;

import newprojectc.example.shoesapp_duked.R;
import newprojectc.example.shoesapp_duked.model.UserLogin;

public class DetailActivity extends AppCompatActivity {
ImageView imageView,imgshare,imaluusanpham;
ImageButton imgbtnBack;
TabLayout tabLayout;
EditText edtSoLuong;
//QuanLyGiay quanLyGiay = new QuanLyGiay(DetailActivity.this);
TextView txtName,txtprice,txtmota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imgshare=findViewById(R.id.imgViewShare);
        imaluusanpham = findViewById(R.id.imageViewLuuSanPham);
        tabLayout = findViewById(R.id.tablayoutitem);
        imageView =findViewById(R.id.img_subview);
        txtName=findViewById(R.id.txt_subten);
        txtprice=findViewById(R.id.txt_subgiasp);
        imgbtnBack=findViewById(R.id.imgbtnBack);
        txtmota=findViewById(R.id.txtmota22);
        edtSoLuong = findViewById(R.id.edtSoluong);
        imgbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Button btnMua;
        btnMua = (Button) findViewById(R.id.btnMua);



        Intent myintent=getIntent();
        int img = myintent.getIntExtra("img",0);
        imageView.setImageResource(img);
        String ten =myintent.getStringExtra("name");
        txtName.setText(ten);
        String gia=myintent.getStringExtra("price");
        txtprice.setText(gia+"$");
        txtmota.setText("");
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int selectedSize = Integer.parseInt(tab.getText().toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        btnMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CartActivity.class);
                ItemGiay giay = new ItemGiay();
                QuanLyGiay  quanLyGiay = new QuanLyGiay(DetailActivity.this);

                int selectedSize = tabLayout.getSelectedTabPosition();
                intent.putExtra("id",giay.getId());
                intent.putExtra("name",giay.getName());
                intent.putExtra("price",giay.getPrice());
                intent.putExtra("color",giay.getColor());
                intent.putExtra("size",selectedSize);
                intent.putExtra("quantity",edtSoLuong.getText().toString());
               // quanLyGiay.setDonHang(giay);
                //int TongTien = Integer.parseInt(edtSoLuong.getText().toString()) * giay.getPrice();
               // quanLyGiay.addDonHang(new CTDonHang( 1,giay.getId(),Integer.parseInt(edtSoLuong.getText().toString()), giay.getPrice(), Integer.parseInt(edtSoLuong.getText().toString()) * giay.getPrice()));

               // quanLyGiay.addDonHang(giay);
                startActivity(intent);
            }
        });
        imgshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareImage();
            }
        });

    }
    private void shareImage()
    {
        StrictMode.VmPolicy.Builder builder=new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        BitmapDrawable drawable = (BitmapDrawable)imageView.getDrawable();
        Bitmap bitmap=drawable.getBitmap();
        File f =new File(getExternalCacheDir()+"/"+getResources().getString(R.string.app_name)+".png");
        Intent share;
        try {
            FileOutputStream outputStream =  new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
            outputStream.flush();
            outputStream.close();
            share = new Intent(Intent.ACTION_SEND);
            share.setType("image/*");
            share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(f));
            share.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        startActivity(Intent.createChooser(share,"share image"));
    }
}