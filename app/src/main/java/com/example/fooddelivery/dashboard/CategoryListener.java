package com.example.fooddelivery.dashboard;

import android.view.View;

import com.example.fooddelivery.db.category.Category;

public interface CategoryListener {
    default void onClick(Category category, View view) {

    }
}
