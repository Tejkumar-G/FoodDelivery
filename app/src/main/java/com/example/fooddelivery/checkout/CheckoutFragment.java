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

public class CheckoutFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCheckoutBinding fragmentCheckoutBinding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_checkout);
        fragmentCheckoutBinding.setModel(new CheckoutViewModel());
        fragmentCheckoutBinding.getModel().getOrderItems(requireContext());
        return fragmentCheckoutBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }




}