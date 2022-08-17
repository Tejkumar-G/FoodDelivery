package com.example.fooddelivery.db.splash;



import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "image_table")
public class SplashImage {

    @PrimaryKey(autoGenerate = true)
    int id;

    String date;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    public SplashImage(
            String currentDate,
            byte[] imageByte
    ) {
        this.date = currentDate;
        this.image = imageByte;
    }

    public SplashImage() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

