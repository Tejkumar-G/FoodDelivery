package com.example.fooddelivery.fragments.product_details;

import android.content.Context;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.fooddelivery.BR;
import com.example.fooddelivery.db.Food;
import com.example.fooddelivery.db.order.OrderItem;
import com.example.fooddelivery.db.order.OrderRepository;
import com.example.fooddelivery.helper.Navigation;
import com.example.fooddelivery.helper.Utills;
import com.example.fooddelivery.helper.ValueObservable;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class ProductDetailsViewModel extends BaseObservable {

    Food food;
    String totalItems = "";
    String price = "";
    String imageUrl;

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductDetailsViewModel(Food food) {
        this.food = food;
        imageUrl = food.getImageUrl();
    }

    public void goBackScreen(View view) {
        Navigation.goBackScreen(Objects.requireNonNull(Navigation.getActivity(view)));
    }

    public void addItemToDB(View view) {
        addItem(view.getContext());
        Utills.showToast("Item added to cart.", view.getContext());
    }

    public void addItem() {
        updateValue(true);
    }

    public void deleteItem() {
        if (Integer.parseInt(totalItems) == 0)
            return;
        updateValue(false);
    }



    void checkForItemDetails(Context context) {
        OrderRepository orderRepository = new OrderRepository(context);
        int items = 0;
        for (OrderItem orderItem : orderRepository.getAllOrderedItems()) {
            if (orderItem.getFoodName().equals(food.getFoodName())) {
                items++;
            }
        }
        totalItems = items + "";
        updatePrice();
    }

    void updateValue(Boolean increment) {
        totalItems = increment ? Integer.parseInt(totalItems) + 1 + "" : Integer.parseInt(totalItems) - 1 + "";
        updatePrice();
        notifyPropertyChanged(BR._all);
    }

    void updatePrice() {
        price = Integer.parseInt(totalItems) * food.getFoodPrice() + "";
    }

    void addItem(Context context) {
        OrderRepository orderRepository = new OrderRepository(context);


        OrderItem orderItem = new OrderItem(food.getFoodName(), food.getFoodPrice(), food.getCategory(), food.getImageName(), "", food.getImageUrl(), Integer.parseInt(totalItems));

        orderRepository.deleteORDER(orderItem);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                orderRepository.addOrderedItem(orderItem);
            }
        }, 2000);

    }
}
