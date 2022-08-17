package com.example.fooddelivery;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.fooddelivery.db.Food;
import com.example.fooddelivery.db.FoodRepository;
import com.example.fooddelivery.db.category.Category;
import com.example.fooddelivery.db.category.CategoryRepository;
import com.example.fooddelivery.db.splash.SplashImageRepository;
import com.example.fooddelivery.helper.Utills;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FoodRepository foodRepository;
    CategoryRepository categoryRepository;
    SplashImageRepository splashImageRepository;

    Bitmap foodImage;
    Fragment mFragment = null;
    List<Food> foodList = new ArrayList<>();
    List<Category> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Items List Creation
        foodList = Utills.getFoodList(getApplicationContext());
        categoryList = Utills.getCategoryList(getApplicationContext());

        //Repository Creation
        foodRepository = new FoodRepository(getApplication());
        splashImageRepository = new SplashImageRepository(getApplication());
        categoryRepository = new CategoryRepository(getApplication());


        List<byte[]> images = splashImageRepository.getAllFoodItem();
        if (images.size() > 0) {
            mFragment = new SplashFragment(images);
        } else {
            mFragment = new SettingFragment();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, mFragment).commit();
        if (foodRepository.getAllFoodItem().size() == 0)
            setFoodData();
        else {

        }
    }

    void setFoodData() {
        for (int i = 0; i < foodList.size(); i++) {
            foodRepository.addFoodData(foodList.get(i));
        }
        for (int i = 0; i < categoryList.size(); i++) {
            categoryRepository.addCategoryData(categoryList.get(i));
        }
    }
}