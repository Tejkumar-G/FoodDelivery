package com.example.fooddelivery.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.R;
import com.example.fooddelivery.helper.Navigation;
import com.example.fooddelivery.product_details.ProductDetailsFragment;

import java.util.List;

public class ProductsListAdaptor extends RecyclerView.Adapter<ProductsListAdaptor.ViewHolder> {
    List<ProductData> list;

    public ProductsListAdaptor(List<ProductData> list, ProductClickListener listener) {
        this.list = list;
    }

    @NonNull
    @Override
    public ProductsListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ProductsListAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductsListAdaptor.ViewHolder viewHolder,
                                 final int position) {

        Glide.with(viewHolder.view.getContext())
                .load(list.get(position).imageUrl)
                .dontAnimate()
                .into(viewHolder.productImage);

        viewHolder.productName.setText(list.get(position).productName);
        viewHolder.productPrice.setText(list.get(position).productPrice);
        viewHolder.itemView.setOnClickListener(view -> {
            Navigation.replaceFragment(Navigation.getActivity(view),new ProductDetailsFragment());
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
        ImageView productImage;
        TextView productName;
        TextView productPrice;
        ViewHolder(View view) {
            super(view);
            this.view = view;

            productImage = view.findViewById(R.id.product_image);
            productName = view.findViewById(R.id.product_name);
            productPrice = view.findViewById(R.id.product_price);
        }

    }
}