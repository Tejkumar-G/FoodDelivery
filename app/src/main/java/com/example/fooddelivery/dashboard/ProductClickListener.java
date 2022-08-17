package com.example.fooddelivery.dashboard;

import com.example.fooddelivery.db.Food;

public interface ProductClickListener {
    default void onClick(Food food) {

    }
}
