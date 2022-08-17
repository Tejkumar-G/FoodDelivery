package com.example.fooddelivery.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.fooddelivery.R;
import com.example.fooddelivery.db.Food;
import com.example.fooddelivery.db.category.Category;

import java.util.ArrayList;
import java.util.List;

public class Utills {

   public static List<Food> getFoodList(Context context) {

        List<Food> foodList = new ArrayList<>();

        Food food = new Food("Single Burger", 200, "Burger", "cheeseburger.png","");
        foodList.add(food);
        Food food1 = new Food("Burger Combo", 150, "Burger", "pizza.png", "");
        foodList.add(food1);
        Food food2 = new Food("Burger Chicken", 150, "Burger", "pizza.png", "");
        foodList.add(food2);


        Food food3 = new Food("Chocolate MilkShake", 220, "MilkShake", "Chocolate.png", "");
        foodList.add(food3);
        Food food4 = new Food("Mango MilkShake", 170, "MilkShake", "Mango.png", "");
        foodList.add(food4);
        Food food5 = new Food("Strawberry MilkShake", 190, "MilkShake", "Strawberry.png","");
        foodList.add(food5);

        return foodList;

    }

     public static List<Category> getCategoryList(Context context) {

          List<Category> foodList = new ArrayList<>();

          Category food = new Category( "Burger","");
          foodList.add(food);

          Category food3 = new Category( "MilkShake", "");
          foodList.add(food3);


          return foodList;

     }

}
