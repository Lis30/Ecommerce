package com.projects.activity_prodcard.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.projects.activity_prodcard.R;

import java.util.ArrayList;
import java.util.List;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.PicViewHolder>{

    Context context;
    List<String> images;

    public PictureAdapter(Context context) {
        this.context = context;
        this.images = new ArrayList<>();
    }


    public void addItems(List<String> items) {
        images.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View PicItem = LayoutInflater.from(context).inflate(R.layout.recyclerview_images, parent, false);

        return new PictureAdapter.PicViewHolder(PicItem);
    }

    @Override
    public void onBindViewHolder(@NonNull PicViewHolder holder, int position) {
        Glide.with(context).load(images.get(position)).into(holder.PhonePicProdcard);
       }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class PicViewHolder extends RecyclerView.ViewHolder{

        ImageView PhonePicProdcard;

    public PicViewHolder(@NonNull View itemView) {
        super(itemView);
        PhonePicProdcard = itemView.findViewById(R.id.PhonePicProdcard);
    }
}

}
