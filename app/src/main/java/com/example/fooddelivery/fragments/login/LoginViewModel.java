package com.example.fooddelivery.fragments.login;

import android.graphics.BitmapFactory;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.fooddelivery.R;
import com.example.fooddelivery.fragments.dashboard.DashboardFragment;
import com.example.fooddelivery.db.user.User;
import com.example.fooddelivery.helper.Constant;
import com.example.fooddelivery.helper.ImageConvertor;
import com.example.fooddelivery.helper.Navigation;
import com.example.fooddelivery.helper.Utills;

import java.util.Objects;


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
                Constant.userName = user.getUserName();
                Constant.userRole = "Server";
                Objects.requireNonNull(Navigation.getActivity(view)).configureUserInfo(user,R.mipmap.server);
                Navigation.replaceFragment(Objects.requireNonNull(Navigation.getActivity(view)),new DashboardFragment(),false);
                Utills.closeKeyboard(view);
            }
            else if (message.contentEquals("1111")) {
                User user = new User("Tej","Manager", ImageConvertor.convertPNGBitmapToByteArray(BitmapFactory.decodeResource(view.getContext().getResources(),R.mipmap.manager)));
                Constant.userName = user.getUserName();
                Constant.userRole = "Manager";
                Objects.requireNonNull(Navigation.getActivity(view)).configureUserInfo(user,R.mipmap.manager);
                Navigation.replaceFragment(Objects.requireNonNull(Navigation.getActivity(view)),new DashboardFragment(),false);
                Utills.closeKeyboard(view);
            }
            else {
                Utills.showToast( "Invalid Password", view.getContext());
            }
        }

    }
}
