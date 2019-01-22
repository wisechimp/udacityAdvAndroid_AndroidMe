package com.example.android.android_me.ui.screens.mainScreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onImageSelected(int position) {
        Toast.makeText(this, "Image position is " + String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
}
