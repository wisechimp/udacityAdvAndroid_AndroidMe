package com.example.android.android_me.ui.screens.mainScreen.recyclerViewFiles;

import android.view.View;

public interface RecyclerViewItemClickListener {

    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
