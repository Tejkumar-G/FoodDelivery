package com.example.fooddelivery.fragments.login;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentDashboardBinding;
import com.example.fooddelivery.databinding.FragmentLoginBinding;
import com.example.fooddelivery.db.user.User;
import com.example.fooddelivery.db.user.UserRepository;
import com.example.fooddelivery.helper.Constant;
import com.example.fooddelivery.helper.ImageConvertor;
import com.example.fooddelivery.helper.Navigation;


public class LoginFragment extends Fragment {

    Button loginBtn;
    EditText passwordET;

    UserRepository userRepository;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentLoginBinding binding = FragmentLoginBinding.inflate(inflater, container, false);
        binding.setModel(new LoginViewModel());
        return binding.getRoot();
    }
}
