package com.example.android.android_me.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private String imageIdList = "Image ID List";
    private String listIndex = "List Index";
    private List<Integer> mImageIds;
    private int mListIndex;

    // Mandatory constructor for instantiating the fragment
    public BodyPartFragment() {
    }

    // Inflate the fragment and set image resource
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Load the saved state (the list of images and list index) if there is one
        if(savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(imageIdList);
            mListIndex = savedInstanceState.getInt(listIndex);
        }

        // Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        //Get reference to the ImageView
        final ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        // If a list of IDs exists then set the image resource that's been selected. Otherwise state no list found
        if(mImageIds != null) {
            // Set the image resource to the list item at the selected index
            imageView.setImageResource(mImageIds.get(mListIndex));

            // Setting a click listener on the image view
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListIndex < mImageIds.size()-1) {
                        mListIndex++;
                    } else {
                        // The end of the list has been reached, so loop round to the beginning index
                        mListIndex = 0;
                    }
                    // Update the image resource to show the new list item
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        } else {
            // Log message saying no image id list
            Log.v("Image ID list: ", "No list of body part IDs initialised");
        }
        // Return the root view
        return rootView;
    }

    public void setImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }

    public void setListIndex(int listIndex) {
        mListIndex = listIndex;
    }

    //https://medium.com/androiddevelopers/viewmodels-persistence-onsaveinstancestate-restoring-ui-state-and-loaders-fc7cc4a6c090

    // Saving the fragment's current state for screen rotation
    @Override
    public void onSaveInstanceState(@NonNull Bundle currentState) {

        currentState.putIntegerArrayList(imageIdList, (ArrayList<Integer>) mImageIds);
        currentState.putInt(listIndex, mListIndex);
    }
}
