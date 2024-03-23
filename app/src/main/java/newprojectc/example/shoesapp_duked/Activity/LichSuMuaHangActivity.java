package newprojectc.example.shoesapp_duked.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

import newprojectc.example.shoesapp_duked.R;
import newprojectc.example.shoesapp_duked.model.DonHang;

public class LichSuMuaHangActivity extends AppCompatActivity {
    private AdapterDonHang adapterDonHang;
    private RecyclerView recyclerView;
    private ImageView imgback;

    QuanLyGiay quanLyGiay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_mua_hang);
        quanLyGiay = new QuanLyGiay(LichSuMuaHangActivity.this);
        adapterDonHang = new AdapterDonHang( quanLyGiay.getLichSuMuaHang(),this);

        recyclerView = findViewById(R.id.rvdonhang);
        imgback = findViewById(R.id.imgLogout);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterDonHang);

        imgback.setOnClickListener(view -> finish());
    }
}