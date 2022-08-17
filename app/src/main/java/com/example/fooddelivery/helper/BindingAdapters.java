package com.example.fooddelivery.helper;


import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.checkout.CheckoutAdapter;
import com.example.fooddelivery.checkout.CheckoutViewModel;
import com.example.fooddelivery.dashboard.ItemCategoriesAdaptor;
import com.example.fooddelivery.db.order.OrderItem;

import java.util.List;


public class BindingAdapters {
    @BindingAdapter({"addAdapter"})
    public static void addAdapter(RecyclerView recyclerView, ItemCategoriesAdaptor adapter) {
        recyclerView.setAdapter(adapter);
    }


    @BindingAdapter({"addImageFromGlide"})
    public static void addImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .dontAnimate()
                .into(imageView);
    }

    @BindingAdapter({"addCheckoutAdapter"})
    public static void addCheckoutAdapter(RecyclerView recyclerView, CheckoutViewModel checkoutViewModel) {
        if (recyclerView.getAdapter()!=null)
            recyclerView.setAdapter(new CheckoutAdapter(checkoutViewModel.orderItemList));
    }

}