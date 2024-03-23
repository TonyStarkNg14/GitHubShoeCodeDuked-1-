package newprojectc.example.shoesapp_duked.popular;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import newprojectc.example.shoesapp_duked.R;
import newprojectc.example.shoesapp_duked.RecyclerViewInterface;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.popularViewHolder> {
    private RecyclerViewInterface recyclerViewInterface;
    public void setRecyclerViewInterface(RecyclerViewInterface recyclerViewInterface) {
        this.recyclerViewInterface = recyclerViewInterface;
    }



    private List<Popular_items> mpop;
    public PopularAdapter() {
    }

    public void setData (List<Popular_items> popularItemsList){
        this.mpop = popularItemsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public popularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pup_list,parent, false);
        return new popularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull popularViewHolder holder, int position) {
        Popular_items popularItems = mpop.get(position);
        if (popularItems == null){
            return;
        }
        holder.title.setText(String.valueOf(popularItems.getScore()));
        holder.img.setImageResource(popularItems.getPicURl());
        holder.cmt.setText(String.valueOf(popularItems.getReview()));
        holder.star.setText(String.valueOf(popularItems.getScore()));
        holder.price.setText(String.valueOf(popularItems.getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition();
                if (recyclerViewInterface != null && clickedPosition != RecyclerView.NO_POSITION) {
                    recyclerViewInterface.onItemClick(clickedPosition);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        if(mpop != null){
            return mpop.size();
        }
        return 0;
    }

    public class popularViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView star, cmt, title, price;
        public popularViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txt_name2);
            img = itemView.findViewById(R.id.img_view);
            cmt = itemView.findViewById(R.id.txt_cmt);
            star = itemView.findViewById(R.id.txt_Star);
            price = itemView.findViewById(R.id.txt_price2);
        }
    }




}



