package com.example.fooddelivery.checkout;

import android.content.Context;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.fooddelivery.db.order.OrderItem;
import com.example.fooddelivery.db.order.OrderRepository;
import com.example.fooddelivery.helper.Constant;
import com.example.fooddelivery.helper.Navigation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CheckoutViewModel extends BaseObservable {
    String subTotal;
    String tax;
    String total;
    public List<OrderItem> orderItemList = new ArrayList<>();

    Boolean isManager = Constant.userRole.equals("Manager");

    public Boolean getManager() {
        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }

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

    public void goToBackScreen(View view) {
        Navigation.goBackScreen(Navigation.getActivity(view));
    }



    public void getOrderItems(Context context) {
        OrderRepository orderRepository = new OrderRepository(context);
        orderItemList = orderRepository.getAllOrderedItems();
        setValues(orderItemList);
    }

    private void setValues(List<OrderItem> orderItemList) {
        double subtotalInteger = 0;
        for (OrderItem orderItem : orderItemList) {
            subtotalInteger += (orderItem.getFoodPrice()*orderItem.getQty());
        }
        subTotal = subtotalInteger + "";
        DecimalFormat df = new DecimalFormat("0.00");
        tax = df.format(subtotalInteger / 100 * 8.25);

        total = df.format(subtotalInteger + subtotalInteger / 100 * 8.25);
    }

}
