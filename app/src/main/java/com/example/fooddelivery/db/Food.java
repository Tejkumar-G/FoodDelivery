package com.example.fooddelivery.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food_table")
public class Food {

    @PrimaryKey(autoGenerate = true)
    int id;

    String foodName;

    String imageName;

    String category;

    public double foodPrice;


    private String imageUrl;

    public Food(
            String fName,
            double fPrice,
            String category,
            String fImageName,
            String imageUrl
    ) {
        this.foodName = fName;
        this.foodPrice = fPrice;
        this.category = category;
        this.imageName = fImageName;
        this.imageUrl = imageUrl;
    }

    public Food() {

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

    public String getFoodPrice() {
        return "$" + foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = Integer.parseInt(foodPrice.replace("$", ""));
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
}
