package com.example.fooddelivery;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fooddelivery.db.splash.SplashImage;
import com.example.fooddelivery.db.splash.SplashImageRepository;
import com.example.fooddelivery.helper.ImageConvertor;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class SettingFragment extends Fragment {


    ImageView customIV;
    Button camera, save;

    int MY_CAMERA_PERMISSION_CODE = 99;
    int CAMERA_REQUEST = 102;

    Bitmap bitmap;

    SplashImageRepository splashImageRepository;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        customIV = view.findViewById(R.id.customImage);
        camera = view.findViewById(R.id.camera);
        save = view.findViewById(R.id.save);

        splashImageRepository = new SplashImageRepository(getActivity());

        camera.setOnClickListener(view1 -> {

            openCamera();

        });

        save.setOnClickListener(view12 -> {
            if (bitmap != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                String currentDateandTime = sdf.format(new Date());
                byte[] bytes = ImageConvertor.convertBitmapToByteArray(bitmap);
                Log.d("BytesData", Arrays.toString(bytes));
                SplashImage splashImage = new SplashImage(currentDateandTime, bytes);
                splashImageRepository.addImageData(splashImage);
                Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });

    }


    void openCamera() {

        if (getContext().checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
        } else {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getContext(), "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(getContext(), "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            bitmap = (Bitmap) data.getExtras().get("data");
            customIV.setImageBitmap(bitmap);
        }
    }


}
