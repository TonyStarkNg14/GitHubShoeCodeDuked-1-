package newprojectc.example.shoesapp_duked.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import newprojectc.example.shoesapp_duked.R;

public class Activity_Admin extends AppCompatActivity {

    android.widget.ListView lv;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        lv = (ListView) findViewById(R.id.lvAd);
        arrayList = new ArrayList<>();
        AddArrayName();

        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, arrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Kiểm tra mục được chọn và chuyển sang Activity mới tương ứng
                switch(selectedItem) {
                    case "Quản lý danh mục sản phẩm":
                        // Chuyển sang Activity quản lý sản phẩm
                        Intent intentProductManagement = new Intent(Activity_Admin.this, Activity_QuanLyDanhMuc.class);
                        startActivity(intentProductManagement);
                        break;

                    case "Quản lý sản phẩm":
                        // Chuyển sang Activity quản lý sản phẩm
                        Intent intent = new Intent(Activity_Admin.this, Activity_QuanLySanPham.class);
                        startActivity(intent);
                        break;

                    case "Quản lý hãng sản xuất":
                        // Chuyển sang Activity quản lý sản phẩm
                        Intent intent2 = new Intent(Activity_Admin.this, Activity_QLHSX.class);
                        startActivity(intent2);
                        break;
                }
            }
        });
    }


    //PHẦN TỬ TRÊN LIST VIEW ADMIN
    private void AddArrayName(){
        arrayList.add("Quản lý sản phẩm");
        arrayList.add("Quản lý người dùng");
        arrayList.add("Quản lý danh mục sản phẩm");
        arrayList.add("Quản lý đơn hàng");
        arrayList.add("Quản lý hãng sản xuất");
    }
}