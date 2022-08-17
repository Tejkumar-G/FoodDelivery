package com.example.fooddelivery.checkout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentCheckoutBinding;
import com.example.fooddelivery.helper.BindingAdapters;

public class CheckoutFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCheckoutBinding fragmentCheckoutBinding = FragmentCheckoutBinding.inflate(inflater,container,false);
        CheckoutViewModel model = new CheckoutViewModel();
        fragmentCheckoutBinding.setModel(model);
        model.getOrderItems(requireContext());
        BindingAdapters.addCheckoutAdapter(fragmentCheckoutBinding.checkoutList,model);
        return fragmentCheckoutBinding.getRoot();
    }




}