package com.example.fooddelivery.fragments.login;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fooddelivery.R;
import com.example.fooddelivery.db.user.User;
import com.example.fooddelivery.helper.Constant;
import com.example.fooddelivery.helper.ImageConvertor;
import com.example.fooddelivery.helper.Navigation;
import com.example.fooddelivery.dashboard.DashboardFragment;


public class LoginViewModel extends BaseObservable {
    public String message = "";

    @Bindable
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void submit(View view){
        if (!message.isEmpty())  {
            if (message.contentEquals("1234")) {
                User user = new User("Dola","Server", ImageConvertor.convertPNGBitmapToByteArray(BitmapFactory.decodeResource(view.getContext().getResources(), R.mipmap.server)));
                Constant.userRole = "Server";
                Navigation.replaceFragment(Navigation.getActivity(view),new DashboardFragment());
            }
            else if (message.contentEquals("1111")) {
                User user = new User("Tej","Manager", ImageConvertor.convertPNGBitmapToByteArray(BitmapFactory.decodeResource(view.getContext().getResources(),R.mipmap.manager)));
                Constant.userRole = "Manager";
                Navigation.replaceFragment(Navigation.getActivity(view),new DashboardFragment());
            }
            else {
                Toast.makeText(view.getContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
