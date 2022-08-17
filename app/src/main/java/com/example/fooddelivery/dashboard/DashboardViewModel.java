package com.example.fooddelivery.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fooddelivery.R;
import com.example.fooddelivery.SplashFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//@HiltViewModel
public class DashboardViewModel extends ViewModel {
//    SavedStateHandle savedStateHandle;
//    DashboardViewModel(SavedStateHandle savedStateHandle){
//        this.savedStateHandle = savedStateHandle;
//    }
    LiveData<List<ProductData>> productDataList = new MutableLiveData<>();


    List<CategoryData> categoryDataList = Arrays.asList(
            new CategoryData(R.drawable.burger, "Burger"),
            new CategoryData(R.drawable.burger, "Pizza")
    );

    MutableLiveData<ProductsListAdaptor> productAdaptor = new MutableLiveData<ProductsListAdaptor>();


    void displayProducts(CategoryData categoryData) {
        List<ProductData> productDataList = getProductDataOf(categoryData.categoryName);
        ProductsListAdaptor productsListAdaptor = new ProductsListAdaptor(productDataList, new ProductClickListener(){
            @Override
            public void onClick(ProductData productData) {

            }
        });


        productAdaptor.postValue(productsListAdaptor);
    }

    private List<ProductData> getProductDataOf(String categoryName) {
        return Arrays.asList(
                new ProductData(R.drawable.burger, categoryName + " 1", "$0.09"),
                new ProductData(R.drawable.burger, categoryName + " 2", "$0.1"),
                new ProductData(R.drawable.burger, categoryName + " 3", "$0.1"),
                new ProductData(R.drawable.burger, categoryName + " 4", "$0.1"),
                new ProductData(R.drawable.burger, categoryName + " 5", "$0.1")
        );
    }

    public ItemCategoriesAdaptor getCategoryAdaptor(){
        ItemCategoriesAdaptor categoryAdaptor = new ItemCategoriesAdaptor(categoryDataList, new CategoryListener() {
            @Override
            public void onClick(CategoryData categoryData) {
                displayProducts(categoryData);
            }
        });
        return categoryAdaptor;
    }

}