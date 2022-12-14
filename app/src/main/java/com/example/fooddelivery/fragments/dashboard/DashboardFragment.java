package com.example.fooddelivery.fragments.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.fooddelivery.MainActivity;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentDashboardBinding;
import com.example.fooddelivery.fragments.checkout.CheckoutFragment;
import com.example.fooddelivery.db.order.OrderItem;
import com.example.fooddelivery.db.order.OrderRepository;
import com.example.fooddelivery.helper.BindingAdapters;
import com.example.fooddelivery.helper.Navigation;

import java.util.List;


public class DashboardFragment extends Fragment {

    private DashboardViewModel mViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(DashboardViewModel.class);
        FragmentDashboardBinding binding = FragmentDashboardBinding.inflate(inflater, container, false);
        binding.setViewModel(mViewModel);
        binding.setLifecycleOwner(this);
        binding.ivMenu.setOnClickListener(v->{
            ((MainActivity)getActivity()).openDrawer();
        });
        subScribeUI(binding);
        return binding.getRoot();
    }

    private void subScribeUI(FragmentDashboardBinding binding){
        mViewModel.loadCategories(requireContext());
        binding.productList.setLayoutManager(new GridLayoutManager(getContext(),2));
        mViewModel.categories.observe(getViewLifecycleOwner(), categories -> {
            BindingAdapters.setCategories(binding.categoryList,mViewModel);
            mViewModel.loadProducts(categories.get(0), requireContext());
        });
        mViewModel.foodList.observe(getViewLifecycleOwner(), foods ->{
            BindingAdapters.setFoods(binding.productList, foods);
        });
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ConstraintLayout layout = view.findViewById(R.id.bottom_layout);
        layout.setVisibility(checkForItems(view)?View.VISIBLE:View.INVISIBLE);
        CardView checkOut = view.findViewById(R.id.check_out);
        checkOut.setOnClickListener(v -> {
            Navigation.replaceFragment(requireActivity(), new CheckoutFragment());
        });

    }

    private boolean checkForItems(View view) {
        OrderRepository orderRepository = new OrderRepository(view.getContext());
        TextView noOfItemsTV = view.findViewById(R.id.no_of_items);
        TextView priceTV = view.findViewById(R.id.price);
        List<OrderItem> orderItemList = orderRepository.getAllOrderedItems();
        noOfItemsTV.setText( orderItemList.size()+ " Items");
        double price = 0;
        for (OrderItem orderItem : orderItemList) {
            price += (orderItem.getFoodPrice()*orderItem.getQty());
        }
        priceTV.setText("$" + price);
        return orderItemList.size() != 0;
    }


}