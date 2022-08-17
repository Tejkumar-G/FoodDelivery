package com.example.fooddelivery.product_details;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.R;
import com.example.fooddelivery.db.Food;
import com.example.fooddelivery.db.order.OrderRepository;
import com.example.fooddelivery.helper.Navigation;

public class ProductDetailsFragment extends Fragment {
    Food food;
    TextView total;
    TextView value;
    int totalItems = 0;


    public ProductDetailsFragment(Food food) {
        this.food = food;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = view.findViewById(R.id.product_image);
        Glide.with(requireContext())
                .load(food.getImageUrl())
                .dontAnimate()
                .into(imageView);

        total = view.findViewById(R.id.price);
        TextView deleteValue = view.findViewById(R.id.left_rectangle);
        value = view.findViewById(R.id.center_rectangle);
        TextView addValue = view.findViewById(R.id.right_rectangle);
        TextView crossMark = view.findViewById(R.id.cross_mark);

        addValue.setOnClickListener(v -> {
            updateValue(true);
        });

        deleteValue.setOnClickListener(v -> {
            if (totalItems == 0)
                return;
            updateValue(false);
        });

        crossMark.setOnClickListener(v -> {
//            Navigation.goBackScreen(requireActivity(), this);
        });
    }

    void updateValue(Boolean increment) {
        totalItems = increment ? totalItems+1 : totalItems-1;
        value.setText(""+totalItems);
        total.setText("$"+ (totalItems*food.getFoodPrice()));
    }
}