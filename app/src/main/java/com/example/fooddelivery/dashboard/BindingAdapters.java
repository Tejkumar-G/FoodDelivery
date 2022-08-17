package com.example.fooddelivery.dashboard;


import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;




public class BindingAdapters {
    @BindingAdapter({"addAdapter"})
    public static void addAdapter(RecyclerView recyclerView, ItemCategoriesAdaptor adapter) {
        recyclerView.setAdapter(adapter);
    }


}