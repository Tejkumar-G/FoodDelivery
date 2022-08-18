package com.example.fooddelivery.launchapp;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.db.splash.SplashImage;
import com.example.fooddelivery.db.splash.SplashImageRepository;
import com.example.fooddelivery.helper.ImageConvertor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SettingFragment extends Fragment {


    ImageView customIV;
    TextView camera, save;

    int MY_CAMERA_PERMISSION_CODE = 99;
    int CAMERA_REQUEST = 102;
    int REQUEST_GET_SINGLE_FILE = 103;

    Bitmap bitmap;

    SplashImageRepository splashImageRepository;

    RecyclerView recyclerView;
    ImageAdapter imageAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        camera = view.findViewById(R.id.addImage);
        recyclerView = view.findViewById(R.id.rv);

        splashImageRepository = new SplashImageRepository(getActivity());

        camera.setOnClickListener(view1 -> {

            showImageCaptureOption();

        });
        List<SplashImage> splashScreenData = splashImageRepository.getAllSplashScreenData();
        imageAdapter = new ImageAdapter(splashScreenData,this);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        recyclerView.setAdapter(imageAdapter);

    }

    void openGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_GET_SINGLE_FILE);
    }

    void saveImage() {
        if (bitmap != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            String currentDateandTime = sdf.format(new Date());
            byte[] bytes = ImageConvertor.convertBitmapToByteArray(bitmap);
            SplashImage splashImage = new SplashImage(currentDateandTime, bytes);
            splashImageRepository.addImageData(splashImage);
            Toast.makeText(getContext(), "Please Wait....", Toast.LENGTH_SHORT).show();
            if (imageAdapter != null) {
                new Handler().postDelayed((Runnable) () -> {
                    List<SplashImage> splashScreenData = splashImageRepository.getAllSplashScreenData();
                    imageAdapter.setSplashImageData(splashScreenData);
                    Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_SHORT).show();
                },500);
            }
        }
    }

    void reloadSplashImage() {
        if (imageAdapter != null) {
            new Handler().postDelayed((Runnable) () -> {
                List<SplashImage> splashScreenData = splashImageRepository.getAllSplashScreenData();
                imageAdapter.setSplashImageData(splashScreenData);
                Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_SHORT).show();
            },500);
        }
    }


    void showImageCaptureOption() {
        // Dialogue with Multiple URL Instance
        View view = LayoutInflater.from(requireContext()).inflate(R.layout.choose_camera, null, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext(), R.style.CustomAlertDialog);
        builder.setView(view);
        Dialog dialog = builder.create();

        TextView camera = view.findViewById(R.id.camera);
        TextView gallery = view.findViewById(R.id.gallery);
        ImageView closePopup = view.findViewById(R.id.closePopup);

        //On Click Listener
        camera.setOnClickListener(v1 -> {
            openCamera();
            dialog.dismiss();
        });
        gallery.setOnClickListener(v2 -> {
            openGallery();
            dialog.dismiss();
        });
        closePopup.setOnClickListener(v3->{
            dialog.dismiss();
        });


        dialog.setCancelable(false);
        dialog.show();
        // Make The Dialogue width 80% of Full Screen
        DisplayMetrics displayMetrics = new DisplayMetrics();

        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int displayWidth = displayMetrics.widthPixels;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = (int) (displayWidth * 0.8f);
        dialog.getWindow().setAttributes(layoutParams);
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
        } else if (requestCode == REQUEST_GET_SINGLE_FILE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

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
            saveImage();
        } else if (requestCode == REQUEST_GET_SINGLE_FILE && resultCode == Activity.RESULT_OK) {
            try {
                Uri imageUri = data.getData();
                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imageUri);
                saveImage();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
