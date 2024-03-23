package newprojectc.example.shoesapp_duked.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import newprojectc.example.shoesapp_duked.R;

public class ListView extends AppCompatActivity {
    QuanLyGiay quanLyGiay;
    GridView gridView;

    MyArrayAdapter arrayAdapter;

    List<ItemGiay> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        gridView =findViewById(R.id.rvgiaysport);
        list.clear();
        quanLyGiay = new QuanLyGiay(ListView.this);
        list = quanLyGiay.getGiaySport();
        arrayAdapter = new MyArrayAdapter(ListView.this, R.layout.viewholder_pup_list_2, list);
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(ListView.this, DetailActivity.class);

                ItemGiay giay = new ItemGiay();
                intent.putExtra("name", String.valueOf(list.get(position).getName()));
                intent.putExtra("price",String.valueOf(list.get(position).getPrice()));
                intent.putExtra("img",String.valueOf(list.get(position).getImg()));

                startActivity(intent);
            }
        });
    }

}