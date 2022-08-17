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


    List<CategoryData> categoryDataList = getCategories();

    private List<CategoryData> getCategories() {

        return Arrays.asList(
                new CategoryData("", "Burger"),
                new CategoryData("", "Pizza")
        );
    }

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
                new ProductData(
                        "https://i.insider.com/5d0a8eb69c51013537012b32?width=1000&format=jpeg&auto=webp", categoryName + " 1", "$0.09"),
                new ProductData("https://burst.shopifycdn.com/photos/pepperoni-pizza-in-box.jpg?width=1200&format=pjpg&exif=1&iptc=1", categoryName + " 2", "$0.1"),
                new ProductData("https://www.businessinsider.in/thumb/msid-55047679,width-700,height-525/The-famous-McDonalds-Big-Mac-looks-like-everything-a-burger-should-be-with-a-thick-fluffy-bun-and-juicy-beef-patties-.jpg", categoryName + " 3", "$0.1"),
                new ProductData("", categoryName + " 4", "$0.1"),
                new ProductData("", categoryName + " 5", "$0.1")
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