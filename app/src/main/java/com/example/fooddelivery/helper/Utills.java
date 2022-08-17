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
        Bitmap singleBurger = BitmapFactory.decodeResource(context.getResources(), R.mipmap.singleburger);
        Bitmap bugerCombo = BitmapFactory.decodeResource(context.getResources(), R.mipmap.comboburger);
        Bitmap hamBuger = BitmapFactory.decodeResource(context.getResources(), R.mipmap.hamburger);
        Food food = new Food("Single Burger", 200, "Burger", "cheeseburger.png", ImageConvertor.convertPNGBitmapToByteArray(singleBurger));
        foodList.add(food);
        Food food1 = new Food("Burger Combo", 150, "Burger", "pizza.png", ImageConvertor.convertPNGBitmapToByteArray(bugerCombo));
        foodList.add(food1);
        Food food2 = new Food("Burger Chicken", 150, "Burger", "pizza.png", ImageConvertor.convertPNGBitmapToByteArray(hamBuger));
        foodList.add(food2);

        Bitmap chocolateMs = BitmapFactory.decodeResource(context.getResources(), R.mipmap.chocolate_ms);
        Bitmap mangoMs = BitmapFactory.decodeResource(context.getResources(), R.mipmap.mango_ms);
        Bitmap strawberry = BitmapFactory.decodeResource(context.getResources(), R.mipmap.staberry_ms);
        Food food3 = new Food("Chocolate MilkShake", 220, "MilkShake", "Chocolate.png", ImageConvertor.convertPNGBitmapToByteArray(chocolateMs));
        foodList.add(food3);
        Food food4 = new Food("Mango MilkShake", 170, "MilkShake", "Mango.png", ImageConvertor.convertPNGBitmapToByteArray(mangoMs));
        foodList.add(food4);
        Food food5 = new Food("Strawberry MilkShake", 190, "MilkShake", "Strawberry.png", ImageConvertor.convertPNGBitmapToByteArray(strawberry));
        foodList.add(food5);

        return foodList;

    }

     public static List<Category> getCategoryList(Context context) {

          List<Category> foodList = new ArrayList<>();
          Bitmap singleBurger = BitmapFactory.decodeResource(context.getResources(), R.mipmap.singleburger);
          Category food = new Category( "Burger", ImageConvertor.convertPNGBitmapToByteArray(singleBurger));
          foodList.add(food);


          Bitmap chocolateMs = BitmapFactory.decodeResource(context.getResources(), R.mipmap.chocolate_ms);
          Category food3 = new Category( "MilkShake", ImageConvertor.convertPNGBitmapToByteArray(chocolateMs));
          foodList.add(food3);


          return foodList;

     }

}
