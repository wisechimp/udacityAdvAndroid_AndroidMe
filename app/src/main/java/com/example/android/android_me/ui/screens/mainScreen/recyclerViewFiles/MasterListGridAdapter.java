package com.example.android.android_me.ui.screens.mainScreen.recyclerViewFiles;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.List;

public class MasterListGridAdapter extends RecyclerView.Adapter<MasterListGridAdapter.ViewHolder> {

    private List<Integer> mAllBodyParts;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public MasterListGridAdapter(Context context, List<Integer> data) {
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
            onItemClick(view, getAdapterPosition());
        }
    }

    // Method that executes your code for the action received
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + mAllBodyParts.get(position).toString() + ", which is at cell position " + position);
    }

    @Override
    public int getItemCount() {
        Log.i("getItemCount: ", String.valueOf(mAllBodyParts.size()));
        return mAllBodyParts.size();
    }
}
