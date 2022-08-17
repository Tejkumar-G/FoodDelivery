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

        Food food = new Food("Single Burger", 200, "Burger", "cheeseburger.png","data:image/png;base64,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");
        foodList.add(food);
        Food food1 = new Food("Burger Combo", 150, "Burger", "pizza.png", "data:image/png;base64,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");
        foodList.add(food1);
        Food food2 = new Food("Burger Chicken", 150, "Burger", "pizza.png", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwKEaJRRHGht9s-EccdsLm-KlJ9OHb-jKS6A&usqp=CAU");
        foodList.add(food2);


        Food food3 = new Food("Chocolate MilkShake", 220, "MilkShake", "Chocolate.png", "https://images.unsplash.com/photo-1572490122747-3968b75cc699?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Y2hvY29sYXRlJTIwbWlsa3NoYWtlfGVufDB8fDB8fA%3D%3D&w=1000&q=80");
        foodList.add(food3);
        Food food4 = new Food("Mango MilkShake", 170, "MilkShake", "Mango.png", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoFi5rYsS4t08giHqjSgUpsPByQD3BvloWcw&usqp=CAU");
        foodList.add(food4);
        Food food5 = new Food("Strawberry MilkShake", 190, "MilkShake", "Strawberry.png","https://foodwithfeeling.com/wp-content/uploads/2021/06/strawberry-milkshake-4.jpg");
        foodList.add(food5);

        return foodList;

    }

     public static List<Category> getCategoryList(Context context) {

          List<Category> foodList = new ArrayList<>();

          Category food = new Category( "Burger","https://cdn-icons-png.flaticon.com/512/71/71928.png");
          foodList.add(food);

          Category food3 = new Category( "MilkShake", "https://cdn.iconscout.com/icon/premium/png-256-thumb/milkshake-27-986343.png");
          foodList.add(food3);


          return foodList;

     }

}
