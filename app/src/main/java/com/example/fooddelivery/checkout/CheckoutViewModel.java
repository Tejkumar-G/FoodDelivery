package com.example.fooddelivery.checkout;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.fooddelivery.db.order.OrderItem;
import com.example.fooddelivery.db.order.OrderRepository;

import java.util.List;

public class CheckoutViewModel extends BaseObservable {
    String subTotal;
    String tax;
    String total;
    public List<OrderItem> orderItemList;



    public String getSubTotal() {
        return "$"+subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }


    public String getTax() {
        return "$"+tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    @Bindable
    public String getTotal() {
        return "$"+total;
    }

    public void setTotal(String total) {
        this.total = total;
    }



    public void getOrderItems(Context context) {
        OrderRepository orderRepository = new OrderRepository(context);
        orderItemList = orderRepository.getAllOrderedItems();

        setValues(orderItemList);
    }

    private void setValues(List<OrderItem> orderItemList) {
        double subtotalInteger = 0;
        for (OrderItem orderItem : orderItemList) {
            subtotalInteger += orderItem.getFoodPrice();
        }
        subTotal = subtotalInteger + "";
        tax = subtotalInteger / 100 * 8.25 + "";
        total = (subtotalInteger + subtotalInteger / 100 * 8.25) + "";
    }

}
