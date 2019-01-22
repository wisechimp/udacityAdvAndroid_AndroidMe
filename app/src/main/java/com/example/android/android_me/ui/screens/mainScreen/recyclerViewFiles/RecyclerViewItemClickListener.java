package com.example.android.android_me.ui.screens.mainScreen.recyclerViewFiles;

import android.view.View;

/**
 * Created by shicks on 26/11/2017.
 */

public interface RecyclerViewItemClickListener {

    public void onClick(View view, int position);

    public void onLongClick(View view, int position);
}
