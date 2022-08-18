package com.example.fooddelivery.fragments.product_details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.fooddelivery.databinding.FragmentProductDetailsBinding;
import com.example.fooddelivery.db.Food;

public class ProductDetailsFragment extends Fragment {
    Food food;
    public ProductDetailsFragment(Food food) {
        this.food = food;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentProductDetailsBinding binding = FragmentProductDetailsBinding.inflate(inflater, container, false);
        binding.setModel(new ProductDetailsViewModel(food));
        binding.getModel().checkForItemDetails(requireContext());
        return binding.getRoot();
    }
}