package com.example.fooddelivery.db.order;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "order_table")
public class OrderItem {


    @PrimaryKey(autoGenerate = true)
    int id;

    String foodName;

    String imageName;

    String category;

    double foodPrice;

    private String imageUrl;

    String transactionId;

    int qty;

    public OrderItem(
            String fName,
            double fPrice,
            String category,
            String fImageName,
            String transactionId,
            String imageUrl,
            int qty
    ) {
        this.foodName = fName;
        this.foodPrice = fPrice;
        this.category = category;
        this.imageName = fImageName;
        this.imageUrl = imageUrl;
        this.transactionId = transactionId;
        this.qty = qty;
    }

    public OrderItem() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String fImageName) {
        this.imageName = fImageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
