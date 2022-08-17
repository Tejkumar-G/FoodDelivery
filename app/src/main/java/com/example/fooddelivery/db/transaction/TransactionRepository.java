package com.example.fooddelivery.db.transaction;

import android.content.Context;
import android.os.AsyncTask;
import com.example.fooddelivery.db.FoodDatabase;
import java.util.List;

public class TransactionRepository {


    public TransactionDao transactionDao;
    private List<Transaction> transactionList;

    public TransactionRepository(Context application) {
        FoodDatabase db = FoodDatabase.getInstance(application);
        transactionDao = db.transactionDao();
    }

    public List<Transaction> getAllFoodItem() {
        return transactionDao.getAllTransactionItem();
    }

    public void addImageData(Transaction transaction) {

        new InsertTransactionData(transactionDao).execute(transaction);

    }

    private static class InsertTransactionData extends AsyncTask<Transaction, Void, Void> {

        private final TransactionDao mAsyncTaskDao;

        public InsertTransactionData(TransactionDao transactionDao) {
            this.mAsyncTaskDao = transactionDao;
        }


        @Override
        protected Void doInBackground(Transaction... params) {
            Transaction member = params[0];
            mAsyncTaskDao.insertTransactionData(member);
            return null;
        }
    }


}
