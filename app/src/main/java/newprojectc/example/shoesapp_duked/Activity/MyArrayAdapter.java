package newprojectc.example.shoesapp_duked.Activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import newprojectc.example.shoesapp_duked.R;

public class MyArrayAdapter extends ArrayAdapter<ItemGiay> {
    Activity context;
    int idLayout;
    List<ItemGiay> mylist;

    public MyArrayAdapter(Activity context, int idLayout, List<ItemGiay> mylist) {
        super(context, idLayout, mylist);
        this.context = context;
        this.idLayout = idLayout;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //chua layout
        LayoutInflater layoutInflater = context.getLayoutInflater();
        //dat layout id len de chua view
        convertView = layoutInflater.inflate(idLayout, null);

        ItemGiay giay = mylist.get(position);
        ImageView img_item = convertView.findViewById(R.id.img_view);



                 if (giay.getImg() > 0) {
                    img_item.setImageResource(giay.getImg());
                  }
                else
                   {
                    img_item.setImageResource(R.drawable.adidas_white);
                 }

        TextView txt_tensp = convertView.findViewById(R.id.txt_name2);
        txt_tensp.setText(giay.getName());
        TextView txt_giasp = convertView.findViewById(R.id.txt_price2);
        txt_giasp.setText("Price:" + giay.getPrice());
        return convertView;

        }
    }
