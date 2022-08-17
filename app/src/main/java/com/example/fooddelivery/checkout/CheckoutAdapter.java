package com.example.fooddelivery.checkout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.R;
import com.example.fooddelivery.db.order.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.ViewHolder> {
    List<OrderItem> list;

    public CheckoutAdapter(List<OrderItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CheckoutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkout_item, parent, false);
        return new CheckoutAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CheckoutAdapter.ViewHolder viewHolder,
                                 final int position) {
        Glide.with(viewHolder.view.getContext())
                .load(list.get(position).getImageUrl())
                .dontAnimate()
                .into(viewHolder.categoryImage);

        double price = list.get(position).getFoodPrice();
        AtomicInteger quantity = new AtomicInteger(list.get(position).getQty());

        viewHolder.categoryName.setText(list.get(position).getFoodName());
        addAllDetails(viewHolder, price, quantity.get());
        viewHolder.addItem.setOnClickListener(view -> {
            quantity.addAndGet(1);
            addAllDetails(viewHolder, price, quantity.get());
        });
        viewHolder.removeItem.setOnClickListener(view -> {
            quantity.addAndGet(-1);
            addAllDetails(viewHolder, price, quantity.get());
        });

    }

    private void addAllDetails(ViewHolder viewHolder, double price, int quantity) {
        viewHolder.itemCount.setText("" + quantity);
        viewHolder.itemPrice.setText("$" + price);
//        viewHolder.subTotal.setText("$" + price * quantity);
//        viewHolder.tax.setText("$" + getTax(price, quantity));
//        viewHolder.total.setText("$"+(getTax(price, quantity) + price * quantity));
    }

    @Override
    public int getItemCount() {
        return getSizeBasedOnProductName(list);
    }

    private int getSizeBasedOnProductName(List<OrderItem> list) {
        List<String> productNames = new ArrayList<>();
        for (OrderItem orderItem : list) {
            if (!productNames.contains(orderItem.getFoodName())) {
                productNames.add(orderItem.getFoodName());
            }
        }
        return productNames.size();
    }




    @Override
    public void onAttachedToRecyclerView(
            @NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView categoryImage;
        TextView categoryName;
        TextView addItem;
        TextView itemPrice;
        TextView removeItem;
        TextView itemCount;
//        TextView subTotal;
//        TextView tax;
//        TextView total;
        ViewHolder(View view) {
            super(view);
            this.view = view;
            categoryImage = view.findViewById(R.id.category_image);
            categoryName = view.findViewById(R.id.category_name);
            itemPrice = view.findViewById(R.id.item_price);
            addItem = view.findViewById(R.id.add_item);
            removeItem = view.findViewById(R.id.remove_item);
            itemCount = view.findViewById(R.id.item_count_);
//            subTotal = view.findViewById(R.id.sub_total);
//            tax = view.findViewById(R.id.tax);
//            total = view.findViewById(R.id.total);
        }
    }
}