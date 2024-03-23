package newprojectc.example.shoesapp_duked.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import newprojectc.example.shoesapp_duked.R;

public class Activity_QuanLyDanhMuc extends AppCompatActivity {
    QuanLyGiay db;
    ArrayList<String> ID, TenLoai;
    ArrayAdapter adapter;  EditText MaLoai,tenLoai,tenHinh,tenCot;
    Button XacNhan;
    android.widget.ListView lvdm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_danh_muc);



        MaLoai = (EditText) findViewById(R.id.txtLoai);
        tenLoai = (EditText) findViewById(R.id.txtLoai1);
        tenHinh = (EditText) findViewById(R.id.txtLoai2);
        tenCot = (EditText) findViewById(R.id.txtLoai3);
        XacNhan = (Button) findViewById(R.id.btnXacNhan);
        lvdm = (ListView) findViewById(R.id.lv);

        db = new QuanLyGiay(this);
        ID = new ArrayList<>();
        TenLoai = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, TenLoai);
        lvdm.setAdapter(adapter);

        StoreData();

        lvdm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = TenLoai.get(position);
                showCustomDialog(selectedItem);
            }
        });




        XacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuanLyGiay quanLyGiay = new QuanLyGiay(Activity_QuanLyDanhMuc.this);

                LoaiGiay loaiGiay = new LoaiGiay();
                loaiGiay.setMaLoai(Integer.parseInt(MaLoai.getText().toString()));
                loaiGiay.setTenLoaiGiay(tenLoai.getText().toString());
                loaiGiay.setTenHinh(Integer.parseInt(tenHinh.getText().toString()));
                loaiGiay.setTenCot(Integer.parseInt(tenCot.getText().toString()));
                int kq  = quanLyGiay.AddLoai(loaiGiay);
                if(kq == -1)
                {
                    Toast.makeText(Activity_QuanLyDanhMuc.this,"Khong them duoc",Toast.LENGTH_LONG).show();
                }
                if(kq == 1)
                {
                    Toast.makeText(Activity_QuanLyDanhMuc.this,"Them thanh cong",Toast.LENGTH_LONG).show();
                }
            }
        });

        db = new QuanLyGiay(Activity_QuanLyDanhMuc.this);

        ID = new ArrayList<>();
        TenLoai = new ArrayList<>();

        StoreData();


    }



    private void showCustomDialog(final String selectedItem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Activity_QuanLyDanhMuc.this);
        builder.setTitle("Sửa thông tin hãng sản xuất");
        builder.setMessage("Nhập tên mới cho hãng sản xuất:");

        final EditText input = new EditText(Activity_QuanLyDanhMuc.this);
        builder.setView(input);

        // Nút xác nhận
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                QuanLyGiay quanLyGiay = new QuanLyGiay(Activity_QuanLyDanhMuc.this);
                String newTenHang = input.getText().toString().trim();  LoaiGiay loaiGiay = new LoaiGiay();
                loaiGiay.setMaLoai(Integer.parseInt(MaLoai.getText().toString()));
                loaiGiay.setTenLoaiGiay(tenLoai.getText().toString());
                loaiGiay.setTenHinh(Integer.parseInt(tenHinh.getText().toString()));
                loaiGiay.setTenCot(Integer.parseInt(tenCot.getText().toString()));
                int kq  = quanLyGiay.updateLoai(String.valueOf(loaiGiay));;
                if(kq == -1)
                {
                    Toast.makeText(Activity_QuanLyDanhMuc.this,"Khong them duoc",Toast.LENGTH_LONG).show();
                }
                if(kq == 1)
                {
                    Toast.makeText(Activity_QuanLyDanhMuc.this,"Them thanh cong",Toast.LENGTH_LONG).show();
                }

            }
        });

        // NÚT ĐỂ XÓA DỮ LIỆU
        builder.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                db.deleteLoai(selectedItem); // Gọi phương thức xóa khi người dùng xác nhận
                dialog.dismiss(); // Đóng dialog
                TenLoai.remove(selectedItem); // Xóa mục khỏi danh sách và cập nhật ListView
                adapter.notifyDataSetChanged();
            }
        });

        // NÚT HỦY
        builder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Tạo và hiển thị dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }



    //CHỨA DỮ LIỆU
    public void  StoreData(){
        Cursor cursor = db.ReadDataLoai();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                ID.add(cursor.getString(0));
                TenLoai.add(cursor.getString(1));
            }
            adapter.notifyDataSetChanged();
        }
    }
}