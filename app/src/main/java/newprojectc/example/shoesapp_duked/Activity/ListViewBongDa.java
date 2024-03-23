package newprojectc.example.shoesapp_duked.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import newprojectc.example.shoesapp_duked.R;

public class ListViewBongDa extends AppCompatActivity {
    QuanLyGiay quanLyGiay;
    GridView gridView;

    MyArrayAdapter arrayAdapter;

    List<ItemGiay> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_bong_da);


       gridView =findViewById(R.id.rvgiaysoccer1);
        list.clear();
        quanLyGiay = new QuanLyGiay(ListViewBongDa.this);
        list = quanLyGiay.getGiayBongDa();
        arrayAdapter = new MyArrayAdapter(ListViewBongDa.this, R.layout.viewholder_pup_list_2, list);
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(ListViewBongDa.this, DetailActivity.class);

                ItemGiay giay = new ItemGiay();
                intent.putExtra("name", String.valueOf(list.get(position).getName()));
                intent.putExtra("price",String.valueOf(list.get(position).getPrice()));
                intent.putExtra("img",String.valueOf(list.get(position).getImg()));

                startActivity(intent);
            }
        });
    }
}