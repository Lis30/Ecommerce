package com.projects.mainscreen_activity.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.projects.mainscreen_activity.R;
import com.projects.mainscreen_activity.model.BestSellers;
import java.util.ArrayList;
import java.util.List;

public class BSAdapter extends RecyclerView.Adapter<BSAdapter.BSViewHolder>{

    Context context;
    List<BestSellers> bestSellers;

    public BSAdapter(Context context) {
        this.context = context;
        this.bestSellers = new ArrayList<>();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addItems(List<BestSellers> items) {
        bestSellers.addAll(items);
        notifyDataSetChanged();
    }




    @NonNull
    @Override
    public BSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View BSItem = LayoutInflater.from(context).inflate(R.layout.viewholder_catalog, parent, false);

        return new BSAdapter.BSViewHolder(BSItem);
    }

    @Override
    public void onBindViewHolder(@NonNull BSViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.title.setText(bestSellers.get(position).getTitle());
        holder.price_without_discount.setText(bestSellers.get(position).getPrice_without_discount());
        holder.discount_price.setText(bestSellers.get(position).getDiscount_price());
        Glide.with(context).load(bestSellers.get(position).getPicture()).into(holder.picture);

        int heartId = R.drawable.ic_pushed_heart;
        int heartId2 = R.drawable.ic_orange_heart;

        boolean favor = bestSellers.get(position).get_favorites();

        if (favor){
            holder.favorites.setImageResource(heartId);

        }else {
            holder.favorites.setImageResource(heartId2);
        }

        holder.circle_heart.setOnClickListener(view -> {

            boolean favor1 = bestSellers.get(position).get_favorites();

            if (favor1){
                holder.favorites.setImageResource(heartId2);
                bestSellers.get(position).set_favorites(false);

            }else {
                holder.favorites.setImageResource(heartId);
                bestSellers.get(position).set_favorites(true);
            }
        });


    }

    @Override
    public int getItemCount() {
        return bestSellers.size();
    }

    public static class BSViewHolder extends RecyclerView.ViewHolder{

        TextView title, price_without_discount, discount_price;
        ImageView picture, favorites, circle_heart;


        public BSViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.CatalogName);
            price_without_discount = itemView.findViewById(R.id.oldPrice);
            discount_price = itemView.findViewById(R.id.totalPrice);
            picture = itemView.findViewById(R.id.pic);
            favorites = itemView.findViewById(R.id.heart);
            circle_heart = itemView.findViewById(R.id.circle_heart);
        }
    }

}
