package com.example.fooddelivery.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.R;

import java.util.List;

public class ItemCategoriesAdaptor extends RecyclerView.Adapter<ItemCategoriesAdaptor.ViewHolder> {
    List<CategoryData> list;
    CategoryListener categoryListener;

    public ItemCategoriesAdaptor(List<CategoryData> list, CategoryListener listener) {
        this.list = list;
        this.categoryListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder,
                     final int position) {
        Glide.with(viewHolder.view.getContext())
                .load(list.get(position).imageUrl)
                .dontAnimate()
                .into(viewHolder.categoryImage);

        viewHolder.categoryName.setText(list.get(position).categoryName);
        viewHolder.cardView.setOnClickListener(view -> {
            categoryListener.onClick(list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView categoryImage;
        TextView categoryName;
        CardView cardView;
        ViewHolder(View view) {
            super(view);
            this.view = view;
            categoryImage = view.findViewById(R.id.category_image);
            categoryName = view.findViewById(R.id.category_name);
            cardView = view.findViewById(R.id.category_card);
        }
    }
}

