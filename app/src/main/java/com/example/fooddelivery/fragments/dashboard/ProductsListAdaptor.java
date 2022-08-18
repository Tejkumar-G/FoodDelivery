package com.example.fooddelivery.fragments.dashboard;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.databinding.ProductItemBinding;
import com.example.fooddelivery.db.Food;
import com.example.fooddelivery.helper.Navigation;
import com.example.fooddelivery.fragments.product_details.ProductDetailsFragment;

import java.util.List;

public class ProductsListAdaptor extends RecyclerView.Adapter<ProductsListAdaptor.ViewHolder> {
    List<Food> list;

    public ProductsListAdaptor(List<Food> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ProductsListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ProductItemBinding binding = ProductItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ProductsListAdaptor.ViewHolder viewHolder,
                                 final int position) {


        viewHolder.binding.setProductItem(list.get(position));
        viewHolder.binding.getRoot().setOnClickListener(view -> Navigation.replaceFragment(Navigation.getActivity(view),new ProductDetailsFragment(list.get(position))));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    static class ViewHolder extends RecyclerView.ViewHolder {
        ProductItemBinding binding;
        ViewHolder(ProductItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}