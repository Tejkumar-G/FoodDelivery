package com.example.fooddelivery.helper;


import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.fragments.checkout.CheckoutAdapter;
import com.example.fooddelivery.fragments.checkout.CheckoutViewModel;
import com.example.fooddelivery.fragments.dashboard.CategoryListener;
import com.example.fooddelivery.fragments.dashboard.DashboardViewModel;
import com.example.fooddelivery.fragments.dashboard.ItemCategoriesAdaptor;
import com.example.fooddelivery.fragments.dashboard.ProductsListAdaptor;
import com.example.fooddelivery.db.Food;
import com.example.fooddelivery.db.category.Category;

import java.util.List;


public class BindingAdapters {
    @BindingAdapter({"addAdapter"})
    public static void addAdapter(RecyclerView recyclerView, ItemCategoriesAdaptor adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({"categories"})
    public static void setCategories(RecyclerView recyclerView, DashboardViewModel viewModel){
        ItemCategoriesAdaptor adaptor = new ItemCategoriesAdaptor(viewModel.categories.getValue(), new CategoryListener() {
            @Override
            public void onClick(Category category, View view) {
                viewModel.loadProducts(category,view.getContext());
            }
        });
        recyclerView.setAdapter(adaptor);
    }

    @BindingAdapter({"foods"})
    public static void setFoods(RecyclerView recyclerView, List<Food> foods){
        ProductsListAdaptor productsListAdaptor = new ProductsListAdaptor(foods);
        recyclerView.setAdapter(productsListAdaptor);
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
        if (recyclerView.getAdapter()==null)
            recyclerView.setAdapter(new CheckoutAdapter(checkoutViewModel.orderItemList));
    }

}