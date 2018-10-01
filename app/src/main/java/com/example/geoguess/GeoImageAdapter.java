package com.example.geoguess;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Adapter for the images in the recyclerview
 */
public class GeoImageAdapter extends RecyclerView.Adapter<GeoImageAdapter.ViewHolder> {

    private List<GeoImage> mGeoImages;

    public GeoImageAdapter(List<GeoImage> geoImages) {
        this.mGeoImages = geoImages;
    }

    @NonNull
    @Override
    public GeoImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.image_item, null);
        // Return a new holder instance
        GeoImageAdapter.ViewHolder viewHolder = new GeoImageAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GeoImageAdapter.ViewHolder holder, int position) {
        holder.mImageView.setImageResource(mGeoImages.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return mGeoImages.size();
    }

    //show an imageview in the recyclerview items
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }
}
