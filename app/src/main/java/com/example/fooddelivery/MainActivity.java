package com.example.fooddelivery;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.fooddelivery.databinding.ActivityMainBinding;
import com.example.fooddelivery.db.Food;
import com.example.fooddelivery.db.FoodRepository;
import com.example.fooddelivery.db.category.Category;
import com.example.fooddelivery.db.category.CategoryRepository;
import com.example.fooddelivery.db.splash.SplashImageRepository;
import com.example.fooddelivery.db.user.User;
import com.example.fooddelivery.helper.Navigation;
import com.example.fooddelivery.helper.Utills;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FoodRepository foodRepository;
    CategoryRepository categoryRepository;
    SplashImageRepository splashImageRepository;
    ActivityMainBinding activityMainBinding;

    Bitmap foodImage;
    Fragment mFragment = null;
    List<Food> foodList = new ArrayList<>();
    List<Category> categoryList = new ArrayList<>();
    DrawerLayout drawer;
    NavigationView navigationView;
    boolean isDrawerOpened = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        drawer = activityMainBinding.drawerLayout;
        navigationView = activityMainBinding.navView;
        navigationView.getMenu().findItem(R.id.nav_transactions).setOnMenuItemClickListener(menuItem -> {

            return false;
        });
        navigationView.getMenu().findItem(R.id.nav_gallery).setOnMenuItemClickListener(menuItem -> {
            closeDrawer();
            Navigation.replaceFragment(this,new SettingFragment());
            return false;
        });
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        //Items List Creation
        foodList = Utills.getFoodList(getApplicationContext());
        categoryList = Utills.getCategoryList(getApplicationContext());

        //Repository Creation
        foodRepository = new FoodRepository(getApplication());
        splashImageRepository = new SplashImageRepository(getApplication());
        categoryRepository = new CategoryRepository(getApplication());


        List<byte[]> images = splashImageRepository.getAllImageData();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, new SplashFragment(images)).commit();

        if (foodRepository.getAllFoodItem().size() == 0)
            setFoodData();
        configDrawerManu();
    }

    @Override
    public void onBackPressed() {
        if(isDrawerOpened){
            closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    public void openDrawer(){
        drawer.open();
    }

    public void closeDrawer(){
        drawer.closeDrawers();
    }

    private void configDrawerManu() {
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,  /* host Activity */
                drawer,  /* DrawerLayout object */
                R.mipmap.ic_menu,  /* nav drawer image to replace 'Up' caret */
                R.mipmap.ic_menu /* "open drawer" description for accessibility */
        ) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                isDrawerOpened = true;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                isDrawerOpened = false;
            }
        };
        drawer.setDrawerListener(mDrawerToggle);
    }

    public void configureUserInfo(User user, int image){
        View headerView = navigationView.getHeaderView(0);
        ((ImageView)headerView.findViewById(R.id.user_image)).setImageResource(image);
        ((TextView)headerView.findViewById(R.id.name)).setText(user.getUserName());
        ((TextView)headerView.findViewById(R.id.role)).setText(user.getUserRole());
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