package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class BodyPartFragment extends Fragment {

    // Mandatory constructor for instantiating the fragment
    public BodyPartFragment() {

    }

    // Inflate the fragment and set image resource
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        //Get reference to the ImageView
        ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        //Set the image resource to display
        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        // Return the root view
        return rootView;
    }
}
