package com.example.fooddelivery;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageAdapterViewHolder> {

    public List<Bitmap> bitmaps = new ArrayList<>();

    ImageAdapter(List<Bitmap> bitmaps) {
        this.bitmaps = bitmaps;
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
        Bitmap bitmap = bitmaps.get(position);
        holder.imageView.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return bitmaps.size();
    }

    public void setImageBitmap(List<Bitmap> bitmap) {
        bitmaps.clear();
        bitmaps.addAll(bitmap);
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


