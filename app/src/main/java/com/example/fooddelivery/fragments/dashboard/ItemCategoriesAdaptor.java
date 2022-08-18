package com.example.fooddelivery.fragments.dashboard;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.CategoryItemBinding;
import com.example.fooddelivery.db.category.Category;

import java.util.List;

public class ItemCategoriesAdaptor extends RecyclerView.Adapter<ItemCategoriesAdaptor.ViewHolder> {
    List<Category> list;
    CategoryListener categoryListener;
    public int selected  = 0;

    public ItemCategoriesAdaptor(List<Category> list, CategoryListener listener) {
        this.list = list;
        this.categoryListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryItemBinding binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder,
                                 final int position) {
        viewHolder.binding.setCategory(list.get(position));
        viewHolder.binding.setListener(new CategoryListener() {
            @Override
            public void onClick(Category category, View view) {
                selected = viewHolder.getAdapterPosition();
                categoryListener.onClick(category,view);
                notifyDataSetChanged();
            }
        });
        if(position == selected){
            viewHolder.binding.categoryCard.setCardBackgroundColor(ColorStateList.valueOf(viewHolder.itemView.getContext().getColor(R.color.purple_700)));
        } else {
            viewHolder.binding.categoryCard.setCardBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        CategoryItemBinding binding;

        ViewHolder(CategoryItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

