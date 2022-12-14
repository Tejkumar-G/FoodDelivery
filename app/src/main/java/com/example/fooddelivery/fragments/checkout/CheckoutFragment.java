package com.example.fooddelivery.fragments.checkout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentCheckoutBinding;
import com.example.fooddelivery.helper.BindingAdapters;

public class CheckoutFragment extends Fragment {
    CheckoutViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCheckoutBinding fragmentCheckoutBinding = FragmentCheckoutBinding.inflate(inflater,container,false);
        viewModel = new CheckoutViewModel();
        fragmentCheckoutBinding.setModel(viewModel);
        viewModel.getOrderItems(requireContext());
        BindingAdapters.addCheckoutAdapter(fragmentCheckoutBinding.checkoutList,viewModel);
        return fragmentCheckoutBinding.getRoot();
    }



}