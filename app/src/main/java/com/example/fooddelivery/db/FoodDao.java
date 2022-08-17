package com.example.fooddelivery.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface FoodDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFoodData(Food food);

    @Delete
    void deleteUserData(Food food);

    @Update
    void updateUserData(Food food);

    @Query("SELECT * FROM food_table ORDER BY foodName ASC")
    List<Food> getAllFoodItem();

}
