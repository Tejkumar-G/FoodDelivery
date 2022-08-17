package com.example.fooddelivery.db.transaction;

import android.content.Context;
import android.os.AsyncTask;
import com.example.fooddelivery.db.FoodDatabase;
import java.util.List;

public class TransactionRepository {


    public TransactionDao transactionDao;

    public TransactionRepository(Context application) {
        FoodDatabase db = FoodDatabase.getInstance(application);
        transactionDao = db.transactionDao();
    }

    public List<Transaction> getAllTransactionItems() {
        return transactionDao.getAllTransactionItem();
    }

    public List<Transaction> getAllTransactionItemsBasedOnTransactionId(String transactionId) {
        return transactionDao.getTransactionDataBasedOnTransactionId(transactionId);
    }

    public void addTransactionData(Transaction transaction) {

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
