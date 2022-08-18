package com.example.fooddelivery.fragments.checkout;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.databinding.CheckoutItemBinding;
import com.example.fooddelivery.db.order.OrderItem;

import java.util.List;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.ViewHolder> {
    List<OrderItem> list;

    public CheckoutAdapter(List<OrderItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CheckoutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CheckoutItemBinding binding = CheckoutItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CheckoutAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final CheckoutAdapter.ViewHolder viewHolder,
                                 final int position) {
        viewHolder.binding.setOrderItem(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        CheckoutItemBinding binding;
        ViewHolder(CheckoutItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}