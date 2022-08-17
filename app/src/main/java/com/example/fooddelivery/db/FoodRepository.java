package com.example.fooddelivery.db;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class FoodRepository {

    public FoodDao foodDao;
    private List<Food> food;

    public FoodRepository(Context application) {
        FoodDatabase db = FoodDatabase.getInstance(application);
        foodDao = db.foodDao();
    }

    public List<Food> getAllFoodItem() {
        return foodDao.getAllFoodItem();
    }

    public List<Food> getFoodDataBasedOnCategory(String category) {
        return foodDao.getFoodDataBasedOnCategory(category);
    }

    public void addFoodData(Food food) {

        new InsertFoodData(foodDao).execute(food);

    }

    private static class InsertFoodData extends AsyncTask<Food, Void, Void> {

        private final FoodDao mAsyncTaskDao;

        public InsertFoodData(FoodDao foodDao) {
            this.mAsyncTaskDao = foodDao;
        }


        @Override
        protected Void doInBackground(Food... params) {
            Food member = params[0];
            mAsyncTaskDao.insertFoodData(member);
            return null;
        }
    }

}
