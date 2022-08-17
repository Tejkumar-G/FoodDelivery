package com.example.fooddelivery.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.MainActivity;
import com.example.fooddelivery.R;
import com.example.fooddelivery.checkout.CheckoutFragment;
import com.example.fooddelivery.databinding.FragmentDashboardBinding;
import com.example.fooddelivery.db.order.OrderItem;
import com.example.fooddelivery.db.order.OrderRepository;
import com.example.fooddelivery.helper.Navigation;

import java.util.List;


//@AndroidEntryPoint
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

        mViewModel.getCategories(requireContext());
        mViewModel.displayProducts(mViewModel.categoryDataList.get(0), view.getContext());

        RecyclerView categoryView = view.findViewById(R.id.category_list);
        RecyclerView productsView = view.findViewById(R.id.product_list);

        categoryView.setAdapter(mViewModel.getCategoryAdaptor());


//        categoryView.setAdapter(mViewModel.categoryAdaptor);
        productsView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        mViewModel.productAdaptor.observe(getViewLifecycleOwner(), new Observer<ProductsListAdaptor>() {
                    @Override
                    public void onChanged(ProductsListAdaptor productsListAdaptor) {
                        productsView.setAdapter(productsListAdaptor);
                    }
                }
        );

        CardView checkOut = view.findViewById(R.id.check_out);

        checkOut.setVisibility(checkForItems(view)?View.VISIBLE:View.INVISIBLE);

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