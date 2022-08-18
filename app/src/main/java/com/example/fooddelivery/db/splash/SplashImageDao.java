package com.example.fooddelivery.db.splash;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fooddelivery.db.Food;

import java.util.List;

@Dao
public interface SplashImageDao {

        @Insert
        void insertImageData(SplashImage splashImage);

        @Delete
        void deleteImageData(SplashImage splashImage);

        @Update
        void updateImageData(SplashImage splashImage);

        @Query("SELECT image FROM image_table ORDER BY id ASC")
        List<byte []> getAllImageItem();



}
