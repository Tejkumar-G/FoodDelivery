package com.example.fooddelivery.dashboard;

import android.content.Context;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.db.Food;
import com.example.fooddelivery.db.FoodRepository;
import com.example.fooddelivery.db.category.Category;
import com.example.fooddelivery.db.category.CategoryRepository;
import com.example.fooddelivery.db.order.OrderRepository;
import com.example.fooddelivery.helper.BindingAdapters;
import com.example.fooddelivery.helper.ValueObservable;

import java.util.Arrays;
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

    public void openFoodPage(){

    }

    private List<Food> getProductDataOf(Category category, Context context) {
        FoodRepository foodRepository = new FoodRepository(context);
        return foodRepository.getFoodDataBasedOnCategory(category.getFoodName());


//        return Arrays.asList(
//                new ProductData(
//                        "https://i.insider.com/5d0a8eb69c51013537012b32?width=1000&format=jpeg&auto=webp", categoryName + " 1", "$0.09"),
//                new ProductData("https://burst.shopifycdn.com/photos/pepperoni-pizza-in-box.jpg?width=1200&format=pjpg&exif=1&iptc=1", categoryName + " 2", "$0.1"),
//                new ProductData("https://www.businessinsider.in/thumb/msid-55047679,width-700,height-525/The-famous-McDonalds-Big-Mac-looks-like-everything-a-burger-should-be-with-a-thick-fluffy-bun-and-juicy-beef-patties-.jpg", categoryName + " 3", "$0.1"),
//                new ProductData("", categoryName + " 4", "$0.1"),
//                new ProductData("", categoryName + " 5", "$0.1")
//        );
    }

}