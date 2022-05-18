package com.projects.activity_basket.adapters;

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
import com.projects.activity_basket.R;
import com.projects.activity_basket.model.ProdInBasket;

import java.util.ArrayList;
import java.util.List;

public class ProdInBasketAdapter extends RecyclerView.Adapter<ProdInBasketAdapter.ProdInBasketViewHolder> {

    Context context;
    List<ProdInBasket> prodInBasket;

    public ProdInBasketAdapter(Context context) {
        this.context = context;
        this.prodInBasket = new ArrayList<>();
    }


    public void addItems(List<ProdInBasket> items){
        prodInBasket.addAll(items);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ProdInBasketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View ProdItem = LayoutInflater.from(context).inflate(R.layout.viewholder_basket, parent,false);

        return new ProdInBasketAdapter.ProdInBasketViewHolder(ProdItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdInBasketViewHolder holder, int position) {

        holder.price.setText(prodInBasket.get(position).getPrice());
        holder.title.setText(prodInBasket.get(position).getTitle());
        Glide.with(context).load(prodInBasket.get(position).getImages()).into(holder.images);

//        holder.plusCardBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//          int quantity = Integer.parseInt(String.valueOf(holder.numberItem.getText()));
//          holder.numberItem.setText(quantity + 1);
//
//
//          }
//        });
//
//        holder.minusCardBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int quantity = Integer.parseInt(String.valueOf(holder.numberItem.getText()));
//                if (quantity>0){
//                    holder.numberItem.setText(quantity - 1);
//                } else {holder.numberItem.setText(0);}
//
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return prodInBasket.size();
    }

    public static class ProdInBasketViewHolder extends RecyclerView.ViewHolder{

    ImageView images, plusCardBtn, minusCardBtn;
    TextView price, title, numberItem;


    public ProdInBasketViewHolder(@NonNull View itemView) {
        super(itemView);

        images = itemView.findViewById(R.id.basket_pic);
        price = itemView.findViewById(R.id.prodPrice);
        title = itemView.findViewById(R.id.titleTxt);
        numberItem = itemView.findViewById(R.id.numberItemTxt);
        plusCardBtn = itemView.findViewById(R.id.plusCardBtn);
        minusCardBtn = itemView.findViewById(R.id.minusCardBtn);
    }
}
}
