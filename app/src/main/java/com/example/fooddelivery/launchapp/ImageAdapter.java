package com.example.fooddelivery.launchapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.db.splash.SplashImage;
import com.example.fooddelivery.db.splash.SplashImageRepository;
import com.example.fooddelivery.helper.ImageConvertor;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageAdapterViewHolder> {

    public List<SplashImage> splashImageList = new ArrayList<>();
    public SettingFragment settingFragment;
    public SplashImageRepository splashImageRepository;

    ImageAdapter(List<SplashImage> splashImageList, SettingFragment settingFragment) {
        this.splashImageList = splashImageList;
        this.settingFragment = settingFragment;
    }
    ImageAdapter() {

    }

    @NonNull
    @Override
    public ImageAdapter.ImageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.image_layout, parent, false);
        ImageAdapterViewHolder viewHolder = new ImageAdapterViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ImageAdapterViewHolder holder, int position) {
        SplashImage splashImage = splashImageList.get(position);
        holder.imageView.setImageBitmap(ImageConvertor.convertByteArrayToBitmap(splashImage.getImage()));
        holder.closeImg.setOnClickListener(v->{
            if (splashImageRepository!=null){
                splashImageRepository.deleteSplashImageData(splashImage.getId());
            } else {
                reploadRepository();
                splashImageRepository.deleteSplashImageData(splashImage.getId());
            }
            settingFragment.reloadSplashImage();
        });
    }

    void reploadRepository() {
        splashImageRepository  = new SplashImageRepository(settingFragment.getActivity());
    }

    @Override
    public int getItemCount() {
        return splashImageList.size();
    }

    public void setSplashImageData(List<SplashImage> splashImageList_) {
        splashImageList.clear();
        splashImageList.addAll(splashImageList_);
        notifyDataSetChanged();
    }

    public static class ImageAdapterViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView, closeImg;

        public ImageAdapterViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            imageView = (ImageView) view.findViewById(R.id.img);
            closeImg = view.findViewById(R.id.clearImg);

        }

    }

}


