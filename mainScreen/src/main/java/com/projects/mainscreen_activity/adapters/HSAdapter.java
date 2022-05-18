package com.projects.mainscreen_activity.adapters;

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
import com.projects.mainscreen_activity.model.HotSales;

import java.util.ArrayList;
import java.util.List;

public class HSAdapter extends RecyclerView.Adapter<HSAdapter.HSViewHolder> {

    Context context;
    List<HotSales> hotSales;

    public HSAdapter(Context context) {
        this.context = context;
        this.hotSales = new ArrayList<>();
    }

    public void addItems(List<HotSales> items) {
        hotSales.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View HSItem = LayoutInflater.from(context).inflate(R.layout.viewholder_commercial, parent, false);
        return new HSAdapter.HSViewHolder(HSItem);
    }

    @Override
    public void onBindViewHolder(@NonNull HSViewHolder holder, int position) {

        holder.title.setText(hotSales.get(position).getTitle());
        holder.subtitle.setText(hotSales.get(position).getSubtitle());
        Glide.with(context).load(hotSales.get(position).getPicture()).into(holder.picture);
        boolean new_item = hotSales.get(position).get_is_new();
        if (new_item == true){

        }else {
            holder.isNew.setText("");
            holder.isNew.setBackground(null);

        }



    }

    @Override
    public int getItemCount() {
        return hotSales.size();
    }

    public static class HSViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView subtitle;
        ImageView picture;
        TextView isNew;

        public HSViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.phoneName);
            subtitle = itemView.findViewById(R.id.phoneChar);
            picture = itemView.findViewById(R.id.phonePic);
            isNew = itemView.findViewById(R.id.newPoint);
        }
    }


}
