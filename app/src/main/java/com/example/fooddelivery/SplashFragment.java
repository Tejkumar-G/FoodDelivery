package com.example.fooddelivery;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;


import com.example.fooddelivery.dashboard.DashboardFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class SplashFragment extends Fragment {



    private List<byte[]> images  = new ArrayList<>();

    private ViewPager2 viewPager;

    private SplashSlidePagerAdapter pagerAdapter;

    private int currentPage = 0;

    public SplashFragment(List<byte[]> splashImages) {
        for (int i=0;i<splashImages.size();i++) {
            images.add(splashImages.get(i));
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        return inflater.inflate(R.layout.fragment_first,container,false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.view_pager);
        pagerAdapter = new SplashSlidePagerAdapter(getActivity());
        viewPager.setAdapter(pagerAdapter);
        startSplashTimer();
    }

    void startSplashTimer(){
        Handler handler = new Handler();
        Runnable update = () -> {
            if ( currentPage == images.size() ) {
//                replaceFragment(new ImageFragment());
                replaceFragment(new DashboardFragment());
            }
            viewPager.setCurrentItem(currentPage++, true);
        };
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 1500);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private class SplashSlidePagerAdapter extends FragmentStateAdapter {
        public SplashSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            return new ImageFragment(images.get(position));
        }

        @Override
        public int getItemCount() {
            return images.size();
        }
    }

    void replaceFragment( Fragment fragment, Boolean backStack) {
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment, fragment.getClass().getName());
        if (backStack){
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }

    void addFragment( Fragment fragment, Boolean backStack) {
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameLayout,fragment, fragment.getClass().getName());
        if (backStack){
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }

    void addFragment(Fragment fragment){
        addFragment(fragment, true);
    }

    void replaceFragment(Fragment fragment){
        replaceFragment(fragment, true);
    }
}