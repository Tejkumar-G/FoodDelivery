package com.example.fooddelivery.transactions;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooddelivery.R;
import com.example.fooddelivery.db.transaction.Transaction;
import com.example.fooddelivery.db.transaction.TransactionRepository;

import java.util.Arrays;
import java.util.List;


public class TransactionsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transactions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TransactionRepository transactionRepository = new TransactionRepository(requireContext());
        TransactionAdaptor transactionAdaptor = new TransactionAdaptor(transactionRepository.getAllTransactionItems());


        RecyclerView recyclerView = view.findViewById(R.id.transactions);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        recyclerView.setAdapter(transactionAdaptor);
    }

}