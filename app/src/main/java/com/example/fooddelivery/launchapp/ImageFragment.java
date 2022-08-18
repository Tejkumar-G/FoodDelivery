package com.example.fooddelivery.launchapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.fooddelivery.R;
import com.example.fooddelivery.helper.ImageConvertor;

public class ImageFragment extends Fragment {

    private byte[] image;

    ImageFragment(){}

    ImageFragment(byte[] image){
        this.image = image;
    };

    ImageView  imageView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
       return  inflater.inflate(R.layout.fragment_second,container,false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.splash_image_view);
        if (image != null)
            imageView.setImageBitmap(ImageConvertor.convertByteArrayToBitmap(image));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}