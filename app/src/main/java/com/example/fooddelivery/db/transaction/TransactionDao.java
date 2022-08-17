package com.example.fooddelivery.db.transaction;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TransactionDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTransactionData(Transaction transaction);

    @Delete
    void deleteTransactionData(Transaction transaction);

    @Update
    void updateTransactionData(Transaction transaction);

    @Query("SELECT * FROM transaction_table ORDER BY id ASC")
    List<Transaction> getAllTransactionItem();

    //@Query("SELECT * FROM transaction_table Where transactionId = :transactionId")
    //List<Transaction> getTransactionDataBasedOnTransactionId(String transactionId);
}
