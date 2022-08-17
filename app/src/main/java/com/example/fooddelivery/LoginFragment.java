package com.example.fooddelivery;

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

import com.example.fooddelivery.db.user.User;
import com.example.fooddelivery.db.user.UserRepository;
import com.example.fooddelivery.helper.Constant;
import com.example.fooddelivery.helper.ImageConvertor;

public class LoginFragment extends Fragment {

    Button loginBtn;
    EditText passwordET;

    UserRepository userRepository;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginBtn = view.findViewById(R.id.loginBtn);
        passwordET = view.findViewById(R.id.passwordEt);
        userRepository = new UserRepository(requireContext());

        loginBtn.setOnClickListener(view1 -> {
            String password = passwordET.getText().toString();
        if (!password.isEmpty())  {
            if (password.contentEquals("1234")) {
                User user = new User("Dola","Server", ImageConvertor.convertPNGBitmapToByteArray(BitmapFactory.decodeResource(getActivity().getResources(),R.mipmap.server)));
                Constant.userRole = "Server";
            }
            else if (password.contentEquals("1111")) {
                User user = new User("Tej","Manager", ImageConvertor.convertPNGBitmapToByteArray(BitmapFactory.decodeResource(getActivity().getResources(),R.mipmap.manager)));
                Constant.userRole = "Manager";
            }
            else {
                Toast.makeText(requireContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
            }
        }


        });

    }
}
