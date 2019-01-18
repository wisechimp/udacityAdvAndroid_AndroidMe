package com.example.android.android_me.ui.screens.mainScreen.recyclerViewFiles;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.List;

public class BodyPartsGridAdapter extends RecyclerView.Adapter<BodyPartsGridAdapter.ViewHolder> {

    private List<Integer> mAllBodyParts;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public BodyPartsGridAdapter(Context context, List<Integer> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mAllBodyParts = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.grid_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bodyPartImageView.setImageResource(mAllBodyParts.get(position));
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView bodyPartImageView;

        ViewHolder(View itemView) {
            super(itemView);
            bodyPartImageView = itemView.findViewById(R.id.body_part_grid_cell);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (mClickListener != null) mClickListener.
                    onItemClick(view, getAdapterPosition());
        }
    }

    @Override
    public int getItemCount() {
        return mAllBodyParts.size();
    }
}
