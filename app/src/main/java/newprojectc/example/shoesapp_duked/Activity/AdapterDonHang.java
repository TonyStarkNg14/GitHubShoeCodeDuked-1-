package newprojectc.example.shoesapp_duked.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import newprojectc.example.shoesapp_duked.R;
import newprojectc.example.shoesapp_duked.model.DonHang;

public class AdapterDonHang extends RecyclerView.Adapter<AdapterDonHang.DonHangViewHolder>{

    ArrayList<DonHang> donHangs;
    Context context;

    public AdapterDonHang(ArrayList<DonHang> donHangs,Context context) {
        this.donHangs = donHangs;
        this.context = context;
    }

    @NonNull
    @Override
    public DonHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View heroView = inflater.inflate(R.layout.item_lichsu, parent, false);
        DonHangViewHolder viewHolder = new DonHangViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DonHangViewHolder holder, int position) {
        DonHang item = donHangs.get(position);
        holder.tvMaDon.setText("MÃ ĐƠN :" + item.getMaDh());
        holder.tvNgayGiao.setText("ND :" + item.getNgayGiao());
        holder.tvNgayDat.setText("NG :" + item.getNgayDat());
        holder.tvSodienThoai.setText("SĐT :" + item.getSdt());
        holder.tvTenKh.setText("KH :" + item.getTenNguoiNhan());
        holder.tvTongTien.setText( String.valueOf(item.getTongtien()));
    }

    @Override
    public int getItemCount() {
        return donHangs.size();
    }


    class DonHangViewHolder extends RecyclerView.ViewHolder {
        TextView tvNgayGiao,tvNgayDat,tvSodienThoai,tvTenKh,tvTongTien,tvMaDon;
        public DonHangViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNgayGiao  = itemView.findViewById(R.id.tvNgayGiao);
            tvNgayDat = itemView.findViewById(R.id.tvNgayDat);
            tvSodienThoai = itemView.findViewById(R.id.tvSodienThoai);
            tvTenKh = itemView.findViewById(R.id.tvTenKh);
            tvTongTien = itemView.findViewById(R.id.tvTongTien);
            tvMaDon = itemView.findViewById(R.id.tvMaDon);
        }
    }
}
