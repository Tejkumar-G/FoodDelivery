package com.example.fooddelivery.fragments.dashboard;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.databinding.CategoryItemBinding;
import com.example.fooddelivery.db.category.Category;

import java.util.List;

public class ItemCategoriesAdaptor extends RecyclerView.Adapter<ItemCategoriesAdaptor.ViewHolder> {
    List<Category> list;
    CategoryListener categoryListener;

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
        viewHolder.binding.setListener(categoryListener);
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

