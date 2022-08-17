package com.example.fooddelivery.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.fooddelivery.db.splash.SplashImage;
import com.example.fooddelivery.db.splash.SplashImageDao;

@Database(entities = {Food.class, SplashImage.class}, version = 1)
abstract public class FoodDatabase extends RoomDatabase {


    private static FoodDatabase instance;

    // below line is to create
    // abstract variable for dao.
    public abstract FoodDao foodDao();
    public abstract SplashImageDao splashImageDao();

    // on below line we are getting instance for our database.
    public static synchronized FoodDatabase getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext(), FoodDatabase.class, "food_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}