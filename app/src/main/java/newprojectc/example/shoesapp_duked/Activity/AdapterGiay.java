package newprojectc.example.shoesapp_duked.Activity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import newprojectc.example.shoesapp_duked.R;
import newprojectc.example.shoesapp_duked.model.DonHang;

public class AdapterGiay extends RecyclerView.Adapter<AdapterGiay.GiayViewHolder> {
    ArrayList<ItemGiay> giays;
    Context context;

    public AdapterGiay(ArrayList<ItemGiay> giays,Context context) {
        this.giays = giays;
        this.context = context;
    }
    @NonNull
    @Override
    public GiayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View heroView = inflater.inflate(R.layout.viewholder_pup_list_2, parent, false);
        GiayViewHolder viewHolder = new GiayViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGiay.GiayViewHolder holder, int position) {
        ItemGiay item = giays.get(position);
        ItemGiay giay = new ItemGiay();
        String img111= String.valueOf(giay.getImg());
        int img11=((Activity)context).getResources().getIdentifier(img111,"drawable",((Activity)context).getPackageName());
        holder.imgitem.setImageResource(img11);
        holder.txtnameitem.setText(item.getName());
        holder.txtpriceitem.setText(item.getPrice());

    }

    @Override
    public int getItemCount() {
        return giays.size();
    }

    class GiayViewHolder extends RecyclerView.ViewHolder {
       ImageView imgitem;
       TextView txtnameitem,txtpriceitem;
        public GiayViewHolder(@NonNull View itemView) {
            super(itemView);
            imgitem  = itemView.findViewById(R.id.img_view);
            txtnameitem = itemView.findViewById(R.id.txt_name2);
            txtpriceitem = itemView.findViewById(R.id.txt_price2);

        }
    }
}
