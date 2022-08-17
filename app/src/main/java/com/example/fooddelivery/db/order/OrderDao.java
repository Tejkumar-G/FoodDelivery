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

//    @Delete
//    void deleteUserData(OrderItem order);

    @Query("DELETE FROM order_table Where id = :id")
    void deleteFoodData(int id);

    @Query("DELETE FROM order_table Where transactionId = :txId")
    void deleteByTx(String txId);


    @Update
    void updateFoodData(OrderItem order);

    @Query("Update order_table SET transactionId = :transactionId where transactionId = :id")
    void updateTxIDBasedOnOrderId(String transactionId,String id);

    @Query("SELECT * FROM order_table Where transactionId = :id ORDER BY foodName ASC")
    List<OrderItem> getAllOrderedItems(String id);

    @Query("SELECT * FROM order_table Where transactionId = :transactionId ORDER BY foodName ASC")
    List<OrderItem> getOrderItemBasedOnTransactionID(String transactionId);

    @Query("SELECT * FROM order_table Where transactionId = :transactionId AND foodId = :foodId ORDER BY foodName ASC")
    List<OrderItem> getOrderItemBasedOnFoodIdAndtxid(int foodId,String transactionId);

}
