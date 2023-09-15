package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.retrofit.databinding.CustomitemBinding;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<Videos.VediosData> VediosData;
    Context context;

    public Adapter(List<Videos.VediosData> VediosData, Context context) {
        this.VediosData = VediosData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomitemBinding binding = CustomitemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Videos.VediosData vediosData = VediosData.get(position);
        if (VediosData == null) {
            return;
        } else {
            Glide.with(context).load(vediosData.getVideo_cover_image()).optionalCircleCrop().into(holder.img);
            holder.discription.setText(vediosData.getDiscription());
            holder.video_status.setText(vediosData.getVideo_status());
        }


    }

    @Override
    public int getItemCount() {
        return VediosData != null ? VediosData.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView video_status, discription;
        ImageView img;

        public ViewHolder(@NonNull CustomitemBinding binding) {
            super(binding.getRoot());

            video_status = binding.videoStatus;
            discription = binding.tvDiscription;
            img = binding.img;
        }
    }
}
