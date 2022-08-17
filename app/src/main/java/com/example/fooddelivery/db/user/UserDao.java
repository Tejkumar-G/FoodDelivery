package com.example.fooddelivery.db.user;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUserData(User user);

    @Delete
    void deleteUserData(User user);

    @Update
    void updateUserData(User user);

    @Query("SELECT * FROM user_table ORDER BY userName ASC")
    List<User> getAllUsers();


}
