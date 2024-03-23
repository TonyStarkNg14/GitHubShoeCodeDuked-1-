package newprojectc.example.shoesapp_duked.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import newprojectc.example.shoesapp_duked.R;
import newprojectc.example.shoesapp_duked.RecyclerViewInterface;
import newprojectc.example.shoesapp_duked.popular.PopularAdapter;
import newprojectc.example.shoesapp_duked.popular.Popular_items;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {


    ImageButton BtnCart;

    //*****
    ImageButton ibtnGiayTheThao, ibtnGiayTapGym, ibtnGiayBongDa, ibtnGiayChayBo;
    ImageButton ibtnWishList, ibtnUser;
    Button btnBuy;
    MyArrayAdapter arrayAdapter;
    QuanLyGiay quanLyGiay;
    List<ItemGiay> list = new ArrayList<>();



    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //*****
        gv = findViewById(R.id.itemshowinmain);
        ibtnGiayTheThao = findViewById(R.id.ibtnGiayTheThao);
        ibtnGiayBongDa = findViewById(R.id.ibtnGiayBongDa);
        ibtnGiayChayBo = findViewById(R.id.ibtnGiayChayBo);
        ibtnGiayTapGym = findViewById(R.id.ibtnGiayTapGym);
        ibtnWishList = findViewById(R.id.ibtnWishList);

        ibtnUser = findViewById(R.id.ibtnUser);
        btnBuy = findViewById(R.id.btnBuy);
        //*****
        showall();
        BtnCart = (ImageButton) findViewById(R.id.btnCartMain);

        BtnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(i);
            }
        });

        ibtnGiayTheThao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListView.class);
                startActivity(i);
            }
        });
        ibtnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(i);
            }
        });
        ibtnWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LichSuMuaHangActivity.class);
                startActivity(i);
            }
        });
        ibtnGiayTapGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListViewGym.class);
                startActivity(intent);
            }
        });
        ibtnGiayBongDa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListViewBongDa.class);
                startActivity(intent);
            }
        });
        ibtnGiayChayBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListViewRunning.class);
                startActivity(intent);
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListViewAll.class);
                startActivity(intent);
            }
        });
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this, DetailActivity.class);

                ItemGiay giay = new ItemGiay();
                intent.putExtra("name", String.valueOf(list.get(position).getName()));
                intent.putExtra("price",String.valueOf(list.get(position).getPrice()));
                intent.putExtra("img",String.valueOf(list.get(position).getImg()));

                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(int positon) {
        Intent i = new Intent(getApplicationContext(), DetailActivity.class);
        startActivity(i);
    }

    public void showall() {
        list.clear();
        quanLyGiay = new QuanLyGiay(MainActivity.this);
        list = quanLyGiay.getAllGiay();
        arrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.viewholder_pup_list, list);
        gv.setAdapter(arrayAdapter);
    }
}