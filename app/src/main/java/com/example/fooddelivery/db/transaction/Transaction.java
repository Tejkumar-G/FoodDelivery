package com.example.fooddelivery.db.transaction;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transaction_table")
public class Transaction {

    @PrimaryKey(autoGenerate = true)
    int id;

    String userName;

    String userRole;

    int totalPrice;

    String date;

    int transactionId;


    public Transaction(
            String userName,
            String userRole,
            int totalPrice,
            String date,
            int transactionId
    ) {

        this.userName = userName;
        this.userRole = userRole;
        this.totalPrice = totalPrice;
        this.date = date;
        this.transactionId = transactionId;
    }

    public Transaction() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}



