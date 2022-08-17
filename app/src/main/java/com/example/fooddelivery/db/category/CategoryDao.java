package com.example.fooddelivery.db.category;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fooddelivery.db.user.User;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insertCategoryData(Category category);

    @Delete
    void deleteCategoryData(Category category);

    @Update
    void updateCategoryData(Category category);

    @Query("SELECT * FROM category_table ORDER BY foodName ASC")
    List<User> getAllCategoryItems();

}
