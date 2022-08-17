package com.example.fooddelivery.db.order;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import com.example.fooddelivery.db.FoodDatabase;
import com.example.fooddelivery.helper.Constant;

import java.util.List;

public class OrderRepository {

    public OrderDao orderDao;
    private List<OrderItem> orderItemList;

    public OrderRepository(Context application) {
        FoodDatabase db = FoodDatabase.getInstance(application);
        orderDao = db.orderDao();
    }

    public List<OrderItem> getAllOrderedItems() {
        return orderDao.getAllOrderedItems(Constant.userName);
    }

    public void deleteORDER(OrderItem orderItem) {
        orderDao.deleteFoodData(orderItem.id);
    }

    public void clearCart(){
        orderDao.deleteByTx(Constant.userName);
    }

    public void updateTxIDBasedOnOrderId(String transactionId) { orderDao.updateTxIDBasedOnOrderId(transactionId,"");}

    public List<OrderItem> getOrderedItemsBasedOnTransactionId(String transactionId) {
        return orderDao.getOrderItemBasedOnTransactionID(transactionId);
    }

    public List<OrderItem> getOrderedItemsBasedOnFoodIdAndTransactionId(int foodId,String transactionId) {
        return orderDao.getOrderItemBasedOnFoodIdAndtxid(foodId,transactionId);
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
