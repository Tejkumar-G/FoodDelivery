package com.example.fooddelivery.db.category;

import android.content.Context;
import android.os.AsyncTask;

import com.example.fooddelivery.db.FoodDatabase;
import com.example.fooddelivery.db.user.User;

import java.util.List;

public class CategoryRepository {


    public CategoryDao categoryDao;
    private List<Category> userList;

    public CategoryRepository(Context application) {
        FoodDatabase db = FoodDatabase.getInstance(application);
        categoryDao = db.categoryDao();
    }

    public List<User> getAllCategoryItems() {
        return categoryDao.getAllCategoryItems();
    }

    public void addCategoryData(Category category) {

        new InsertCategoryData(categoryDao).execute(category);

    }

    private static class InsertCategoryData extends AsyncTask<Category, Void, Void> {

        private final CategoryDao mAsyncTaskDao;

        public InsertCategoryData(CategoryDao categoryDao) {
            this.mAsyncTaskDao = categoryDao;
        }


        @Override
        protected Void doInBackground(Category... params) {
            Category member = params[0];
            mAsyncTaskDao.insertCategoryData(member);
            return null;
        }
    }

}
