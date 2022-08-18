package com.example.fooddelivery.fragments.dashboard;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fooddelivery.db.Food;
import com.example.fooddelivery.db.FoodRepository;
import com.example.fooddelivery.db.category.Category;
import com.example.fooddelivery.db.category.CategoryRepository;

import java.util.List;


public class DashboardViewModel extends ViewModel {

    public MutableLiveData<List<Category>> categories = new MutableLiveData<>();
    public MutableLiveData<List<Food>> foodList = new MutableLiveData<>();

    public void loadCategories(Context context) {
        CategoryRepository categoryRepository = new CategoryRepository(context);
        categories.postValue(categoryRepository.getAllCategoryItems());

    }

    public void loadProducts(Category category,Context context) {
        foodList.postValue(getProductDataOf(category, context));
    }


    private List<Food> getProductDataOf(Category category, Context context) {
        FoodRepository foodRepository = new FoodRepository(context);
        return foodRepository.getFoodDataBasedOnCategory(category.getFoodName());

    }

}