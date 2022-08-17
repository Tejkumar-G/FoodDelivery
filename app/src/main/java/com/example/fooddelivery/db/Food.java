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

    double foodPrice;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    public Food(
            String fName,
            double fPrice,
            String category,
            String fImageName,
            byte[] imageByte
    ) {
        this.foodName = fName;
        this.foodPrice = fPrice;
        this.category = category;
        this.imageName = fImageName;
        this.image = imageByte;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
