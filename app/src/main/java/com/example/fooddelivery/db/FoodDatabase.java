package com.example.fooddelivery.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.fooddelivery.db.category.Category;
import com.example.fooddelivery.db.category.CategoryDao;
import com.example.fooddelivery.db.order.OrderDao;
import com.example.fooddelivery.db.order.OrderItem;
import com.example.fooddelivery.db.splash.SplashImage;
import com.example.fooddelivery.db.splash.SplashImageDao;
import com.example.fooddelivery.db.transaction.Transaction;
import com.example.fooddelivery.db.transaction.TransactionDao;
import com.example.fooddelivery.db.user.User;
import com.example.fooddelivery.db.user.UserDao;

@Database(entities = {Food.class, SplashImage.class, User.class, Transaction.class, OrderItem.class, Category.class}, version = 2)
abstract public class FoodDatabase extends RoomDatabase {


    private static FoodDatabase instance;

    // below line is to create
    // abstract variable for dao.
    public abstract FoodDao foodDao();
    public abstract SplashImageDao splashImageDao();

    public abstract UserDao userDao();

    public abstract CategoryDao categoryDao();

    public abstract TransactionDao transactionDao();

    public abstract OrderDao orderDao();

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