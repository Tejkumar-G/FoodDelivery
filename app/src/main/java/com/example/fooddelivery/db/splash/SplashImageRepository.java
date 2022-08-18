package com.example.fooddelivery.db.splash;

import android.content.Context;
import android.os.AsyncTask;

import com.example.fooddelivery.db.FoodDatabase;

import java.util.List;

public class SplashImageRepository {

    public SplashImageDao splashImageDao;
    private List<SplashImage> splashImages;

    public SplashImageRepository(Context application) {
        FoodDatabase db = FoodDatabase.getInstance(application);
        splashImageDao = db.splashImageDao();
    }

    public List<byte []> getAllImageData() {
        return splashImageDao.getAllImageItem();
    }

    public void addImageData(SplashImage splashImage) {

        new InsertImageData(splashImageDao).execute(splashImage);

    }

    private static class InsertImageData extends AsyncTask<SplashImage, Void, Void> {

        private final SplashImageDao mAsyncTaskDao;

        public InsertImageData(SplashImageDao splashImageDao) {
            this.mAsyncTaskDao = splashImageDao;
        }


        @Override
        protected Void doInBackground(SplashImage... params) {
            SplashImage member = params[0];
            mAsyncTaskDao.insertImageData(member);
            return null;
        }
    }

}


