package com.example.fooddelivery.db.transaction;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transaction_table")
public class Transaction {

    @PrimaryKey(autoGenerate = true)
    int id;

    String userName;

    String userRole;

    double totalPrice;

    int totalItems = 0;

    String date;


    public Transaction(
            String userName,
            String userRole,
            double totalPrice,
            String date,
            int totalItems
    ) {

        this.userName = userName;
        this.userRole = userRole;
        this.totalPrice = totalPrice;
        this.date = date;
        this.totalItems = totalItems;
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

    public String getTotalPrice() {
        return "$"+totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = Integer.parseInt(totalPrice.replace("$", ""));
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}



