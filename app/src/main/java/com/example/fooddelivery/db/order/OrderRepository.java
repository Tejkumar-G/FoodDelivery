package com.example.fooddelivery.db.order;

import android.app.Application;
import android.os.AsyncTask;

import com.example.fooddelivery.db.FoodDatabase;

import java.util.List;

public class OrderRepository {

    public OrderDao orderDao;
    private List<OrderItem> orderItemList;

    public OrderRepository(Application application) {
        FoodDatabase db = FoodDatabase.getInstance(application);
        orderDao = db.orderDao();
    }

    public List<OrderItem> getAllOrderedItems() {
        return orderDao.getAllOrderedItems();
    }

    public List<OrderItem> getOrderedItemsBasedOnCategory(String transactionId) {
        return orderDao.getOrderItemBasedOnTransactionID(transactionId);
    }

    public void addOrderedItem(OrderItem order) {

        new InsertOrderedData(orderDao).execute(order);

    }

    private static class InsertOrderedData extends AsyncTask<OrderItem, Void, Void> {

        private final OrderDao mAsyncTaskDao;

        public InsertOrderedData(OrderDao orderDao) {
            this.mAsyncTaskDao = orderDao;
        }


        @Override
        protected Void doInBackground(OrderItem... params) {
            OrderItem member = params[0];
            mAsyncTaskDao.insertFoodData(member);
            return null;
        }
    }

}
