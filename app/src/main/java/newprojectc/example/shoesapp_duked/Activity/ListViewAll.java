package newprojectc.example.shoesapp_duked.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import newprojectc.example.shoesapp_duked.R;

public class ListViewAll extends AppCompatActivity {
    QuanLyGiay quanLyGiay;
    GridView gridView;

    MyArrayAdapter arrayAdapter;

    List<ItemGiay> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_all);
        gridView =findViewById(R.id.rvgiayAll);

        list.clear();
        quanLyGiay = new QuanLyGiay(ListViewAll.this);
        list = quanLyGiay.getAllGiay();
        arrayAdapter = new MyArrayAdapter(ListViewAll.this, R.layout.viewholder_pup_list_2, list);
        gridView.setAdapter(arrayAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(ListViewAll.this, DetailActivity.class);

                ItemGiay giay = new ItemGiay();
                intent.putExtra("name", String.valueOf(list.get(position).getName()));
                intent.putExtra("price",String.valueOf(list.get(position).getPrice()));
                intent.putExtra("img",String.valueOf(list.get(position).getImg()));

                startActivity(intent);
            }
        });
    }
}