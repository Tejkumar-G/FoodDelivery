package com.example.fooddelivery.db.user;

import android.content.Context;
import android.os.AsyncTask;

import com.example.fooddelivery.db.FoodDatabase;

import java.util.List;

public class UserRepository {


    public UserDao userDao;
    private List<User> userList;

    public UserRepository(Context application) {
        FoodDatabase db = FoodDatabase.getInstance(application);
        userDao = db.userDao();
    }

    public List<User> getAllFoodItem() {
        return userDao.getAllUsers();
    }

    public void addImageData(User user) {

        new InsertUserData(userDao).execute(user);

    }

    private static class InsertUserData extends AsyncTask<User, Void, Void> {

        private final UserDao mAsyncTaskDao;

        public InsertUserData(UserDao userDao) {
            this.mAsyncTaskDao = userDao;
        }


        @Override
        protected Void doInBackground(User... params) {
            User member = params[0];
            mAsyncTaskDao.insertUserData(member);
            return null;
        }
    }


}
