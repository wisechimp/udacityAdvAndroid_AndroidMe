package com.example.android.android_me.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    private int headIndex = 0;
    private int bodyIndex = 0;
    private int legsIndex = 0;

//    AndroidMeViewModel viewModel;

//    https://medium.com/androiddevelopers/viewmodels-persistence-onsaveinstancestate-restoring-ui-state-and-loaders-fc7cc4a6c090

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

//        viewModel = ViewModelProviders.of(this).get(AndroidMeViewModel.class);

        // Create a head part instance and display it by initialising a list of heads and selecting one
        BodyPartFragment headFragment = new BodyPartFragment();
        headFragment.setImageIds(AndroidImageAssets.getHeads());
        headFragment.setListIndex(headIndex);

        BodyPartFragment bodyFragment = new BodyPartFragment();
        bodyFragment.setImageIds(AndroidImageAssets.getBodies());
        bodyFragment.setListIndex(bodyIndex);

        BodyPartFragment legsFragment = new BodyPartFragment();
        legsFragment.setImageIds(AndroidImageAssets.getLegs());
        legsFragment.setListIndex(legsIndex);

        // Using a FragmentManager to get the fragment onto the screen
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Fragment transaction
        fragmentManager.beginTransaction()
                .add(R.id.head_container, headFragment)
                .add(R.id.body_container, bodyFragment)
                .add(R.id.legs_container, legsFragment)
                .commit();
    }
}
