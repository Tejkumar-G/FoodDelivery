package com.example.fooddelivery;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.fooddelivery.db.FoodRepository;
import com.example.fooddelivery.db.splash.SplashImageRepository;

import java.util.List;

import com.example.fooddelivery.dashboard.DashboardFragment;
import com.example.fooddelivery.product_details.ProductDetailsFragment;



//@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

//    FoodRepository fr;
    SplashImageRepository splashImageRepository;

    Bitmap foodImage;
    Fragment mFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Bitmap burger = BitmapFactory.decodeResource(getApplication().getResources(),R.mipmap.cheeseburger);
//        Bitmap pizza = BitmapFactory.decodeResource(getApplication().getResources(),R.mipmap.pizza);
//        Food food = new Food(1,"Burger",200,"cheeseburger.png", ImageConvertor.convertBitmapToByteArray(burger));
//        Food food1 = new Food(2,"Pizza",150,"pizza.png",ImageConvertor.convertBitmapToByteArray(pizza));
//        fr = new FoodRepository(getApplication());

        splashImageRepository = new SplashImageRepository(getApplication());
        List<byte[]> images = splashImageRepository.getAllFoodItem();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, new SplashFragment(images)).commit();
    }
}