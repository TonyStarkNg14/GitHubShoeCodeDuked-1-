package newprojectc.example.shoesapp_duked.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import newprojectc.example.shoesapp_duked.R;

public class CartActivity extends AppCompatActivity {
DBHelper dbHelper;
QuanLyGiay quanLyGiay;

ItemGiay itemGiay =new ItemGiay();
    MyArrayAdapter arrayAdapter;

    List<ItemGiay> list = new ArrayList<>();
    GridView gridView;
    AppCompatButton btnmua;
    ImageView imgDiaChi,imgTienMat;
    TextView txtTongCong,txtPhiGiaoHang,txtTongThue,txtTongGiaTien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        gridView =findViewById(R.id.gridviewcart);
        btnmua=findViewById(R.id.btnDatHang);
        imgDiaChi=findViewById(R.id.imgViewDiaChi);
        txtTongCong=findViewById(R.id.txtTongCong);
        txtPhiGiaoHang=findViewById(R.id.txtPhiGiaoHang);
        txtTongGiaTien=findViewById(R.id.txtTongTien);
        txtTongThue=findViewById(R.id.txtTongThue);



        list.clear();
        quanLyGiay = new QuanLyGiay(CartActivity.this);
        list = quanLyGiay.getAllGiay();
        arrayAdapter = new MyArrayAdapter(CartActivity.this, R.layout.viewholder_pup_list_2, list);
        gridView.setAdapter(arrayAdapter);








    }
}