package com.example.fooddelivery.transactions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new TransactionAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TransactionAdaptor.ViewHolder viewHolder,
                                 final int position) {

        viewHolder.userName.setText(list.get(position).getUserName());
        viewHolder.price.setText(list.get(position).getTotalPrice());
        viewHolder.time.setText(list.get(position).getDate());
        viewHolder.number.setText(list.get(position).getTransactionId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public void onAttachedToRecyclerView(
            @NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView price;
        TextView time;
        TextView number;
        ViewHolder(View view) {
            super(view);
            userName = view.findViewById(R.id.user_name);
            price = view.findViewById(R.id.price);
            time = view.findViewById(R.id.time);
            number = view.findViewById(R.id.number);
        }
    }
}