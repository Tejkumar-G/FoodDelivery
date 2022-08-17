package com.example.fooddelivery.helper;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.fooddelivery.MainActivity;
import com.example.fooddelivery.R;

public class Navigation {
    public static void replaceFragment(FragmentActivity activity, Fragment fragment, Boolean backStack) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment, fragment.getClass().getName());
        if (backStack){
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }

    public static void addFragment(FragmentActivity activity, Fragment fragment, Boolean backStack) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameLayout,fragment, fragment.getClass().getName());
        if (backStack){
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }



    public static void addFragment(FragmentActivity activity,Fragment fragment){
        addFragment(activity,fragment, true);
    }

    public static void replaceFragment(FragmentActivity activity, Fragment fragment){
        replaceFragment(activity,fragment, true);
    }

    public static void goBackScreen(FragmentActivity activity) {
        activity.getSupportFragmentManager().popBackStack();
    }

    public static MainActivity getActivity(View view) {
        if(view.getContext() instanceof MainActivity)
            return (MainActivity) view.getContext();
        return null;
    }
}
