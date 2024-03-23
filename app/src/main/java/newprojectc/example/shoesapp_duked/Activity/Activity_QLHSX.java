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

public class Activity_QLHSX extends AppCompatActivity {

    QuanLyGiay db;
    ArrayList<String> ID, TenHSX;
    ArrayAdapter adapter;
    Button hangsanxuat;
    EditText MaNSX,tenNSX,DiaChiNSX,DienThoaiNSX;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlhsx);





        hangsanxuat = (Button) findViewById(R.id.btnXacNhanHang);
        MaNSX = (EditText) findViewById(R.id.txtHSX);
        tenNSX = (EditText) findViewById(R.id.txtHSX1);
        DiaChiNSX = (EditText) findViewById(R.id.txtHSX2);
        DiaChiNSX = (EditText) findViewById(R.id.txtHSX3);
        lv = (ListView) findViewById(R.id.lv);

        db = new QuanLyGiay(this);
        TenHSX = new ArrayList<>();
        ID = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, TenHSX);
        lv.setAdapter(adapter);

        StoreData();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = TenHSX.get(position);
                showCustomDialog(selectedItem);
            }
        });

        hangsanxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuanLyGiay quanLyGiay = new QuanLyGiay(Activity_QLHSX.this);
                NhaSanXuat nsx = new NhaSanXuat();
                nsx.setMaNSX(Integer.parseInt(MaNSX.getText().toString()));
                nsx.setTenNSX(tenNSX.getText().toString());
                nsx.setDiaChi(DiaChiNSX.getText().toString());
                nsx.setDienThoai(Integer.parseInt(DienThoaiNSX.getText().toString()));
                int kq  = quanLyGiay.AddHangSanXuat(nsx);
                if(kq == -1)
                {
                    Toast.makeText(Activity_QLHSX.this,"Khong them duoc",Toast.LENGTH_LONG).show();
                }
                if(kq == 1)
                {
                    Toast.makeText(Activity_QLHSX.this,"Them thanh cong",Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    //CHỨA DỮ LIỆU
    public void  StoreData(){
        Cursor cursor = db.ReadDataHSX();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                ID.add(cursor.getString(0));
                TenHSX.add(cursor.getString(1));
            }
            adapter.notifyDataSetChanged();
        }
    }



    private void showCustomDialog(String selectedItem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Activity_QLHSX.this);
        builder.setTitle("Chỉnh sửa thông tin hãng sản xuất");
        builder.setMessage("Bạn đã chọn: " + selectedItem);

        final EditText input = new EditText(Activity_QLHSX.this);
        builder.setView(input);

        //NÚT ĐỂ SỬA DỮ LIỆU
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                QuanLyGiay quanLyGiay = new QuanLyGiay(Activity_QLHSX.this);
                NhaSanXuat nsx = new NhaSanXuat();
                nsx.setMaNSX(Integer.parseInt(MaNSX.getText().toString()));
                nsx.setTenNSX(tenNSX.getText().toString());
                nsx.setDiaChi(DiaChiNSX.getText().toString());
                nsx.setDienThoai(Integer.parseInt(DienThoaiNSX.getText().toString()));
                int kq  = quanLyGiay.updateHangSanXuat(nsx);
                if(kq == -1)
                {
                    Toast.makeText(Activity_QLHSX.this,"Khong them duoc",Toast.LENGTH_LONG).show();
                }
                if(kq == 1)
                {
                    Toast.makeText(Activity_QLHSX.this,"Them thanh cong",Toast.LENGTH_LONG).show();
                }

            }
        });

        // NÚT ĐỂ XÓA DỮ LIỆU
        builder.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                db.deleteHangSanXuat(selectedItem); // Gọi phương thức xóa khi người dùng xác nhận
                dialog.dismiss(); // Đóng dialog
                TenHSX.remove(selectedItem); // Xóa mục khỏi danh sách và cập nhật ListView
                adapter.notifyDataSetChanged();
            }
        });

        // Nút Hủy
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
}