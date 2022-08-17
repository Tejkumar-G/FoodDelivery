package com.example.fooddelivery.db.order;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fooddelivery.db.Food;

import java.util.List;

@Dao
public interface OrderDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFoodData(OrderItem order);

    @Delete
    void deleteUserData(OrderItem order);

    @Update
    void updateUserData(OrderItem order);

    @Query("SELECT * FROM order_table Where transactionId is NULL ORDER BY foodName ASC")
    List<OrderItem> getAllOrderedItems();

    @Query("SELECT * FROM order_table Where transactionId = :transactionId ORDER BY foodName ASC")
    List<OrderItem> getOrderItemBasedOnTransactionID(String transactionId);

}
