package com.example.fooddelivery.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentDashboardBinding;


//@AndroidEntryPoint
public class DashboardFragment extends Fragment {

    private DashboardViewModel mViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(DashboardViewModel.class);
        FragmentDashboardBinding binding = FragmentDashboardBinding.inflate(inflater, container, false);
        binding.setViewModel(mViewModel);
        BindingAdapters.addAdapter(binding.getRoot().findViewById(R.id.category_list), mViewModel.categoryAdaptor);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_dashboard, container, false);


//        FragmentDashboardBinding fragmentDashboardBinding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_dashboard);
//        fragmentDashboardBinding.setViewModel(new DashboardViewModel());
//        fragmentDashboardBinding.executePendingBindings();
//        return fragmentDashboardBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mViewModel.displayProducts(mViewModel.categoryDataList.get(0));

//        RecyclerView categoryView = view.findViewById(R.id.category_list);
        RecyclerView productsView = view.findViewById(R.id.product_list);

//        CardView category = view.findViewById(R.id.category_card);
//
//        category.setOnClickListener(o -> {
//
//        });

//
//        categoryView.setAdapter(mViewModel.categoryAdaptor);
        productsView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        mViewModel.productAdaptor.observe(getViewLifecycleOwner(), new Observer<ProductsListAdaptor>() {
                    @Override
                    public void onChanged(ProductsListAdaptor productsListAdaptor) {
                        productsView.setAdapter(productsListAdaptor);
                    }
                }
        );


    }


}