package com.example.fooddelivery.helper;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ValueObservable<T> extends BaseObservable {
    public T value;

    @Bindable
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
