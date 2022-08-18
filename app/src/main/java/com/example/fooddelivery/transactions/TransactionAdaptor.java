package com.example.fooddelivery.transactions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.TransactionItemBinding;
import com.example.fooddelivery.db.transaction.Transaction;

import java.util.List;

public class TransactionAdaptor extends RecyclerView.Adapter<TransactionAdaptor.ViewHolder> {
    List<Transaction> list;

    public TransactionAdaptor(List<Transaction> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TransactionAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TransactionItemBinding binding = TransactionItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final TransactionAdaptor.ViewHolder viewHolder,
                                 final int position) {
        viewHolder.binding.setTransaction(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TransactionItemBinding binding;

        ViewHolder(TransactionItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}