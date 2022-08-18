package com.example.fooddelivery.fragments.dashboard;

import com.example.fooddelivery.db.Food;

public interface ProductClickListener {
    default void onClick(Food food) {

    }
}
