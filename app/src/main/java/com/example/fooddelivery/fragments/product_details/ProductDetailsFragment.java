package com.example.fooddelivery.fragments.product_details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentProductDetailsBinding;
import com.example.fooddelivery.db.Food;

public class ProductDetailsFragment extends Fragment {
    Food food;
//    TextView total;
//    TextView value;
//    int totalItems = 0;


    public ProductDetailsFragment(Food food) {
        this.food = food;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentProductDetailsBinding binding = FragmentProductDetailsBinding.inflate(inflater, container, false);
        binding.setModel(new ProductDetailsViewModel(food));
        binding.getModel().checkForItemDetails(requireContext());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



//        total = view.findViewById(R.id.price);
//        TextView deleteValue = view.findViewById(R.id.left_rectangle);
//        value = view.findViewById(R.id.center_rectangle);
//        TextView addValue = view.findViewById(R.id.right_rectangle);
//        TextView crossMark = view.findViewById(R.id.cross_mark);
//
//        Button addItem = view.findViewById(R.id.add_product);

//        checkForItemDetails();






    }






}