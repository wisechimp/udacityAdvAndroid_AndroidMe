package com.example.android.android_me.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class AndroidMeViewModel extends AndroidViewModel {

    private int listIndex;
    private int headIndex = 0;
    private int bodyIndex = 0;
    private int legsIndex = 0;

    public AndroidMeViewModel(@NonNull Application application) {
        super(application);
    }

    public int getListIndex() {
        return listIndex;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }

    public int getHeadIndex() {
        return headIndex;
    }

    public void setHeadIndex(int headIndex) {
        this.headIndex = headIndex;
    }

    public int getBodyIndex() {
        return bodyIndex;
    }

    public void setBodyIndex(int bodyIndex) {
        this.bodyIndex = bodyIndex;
    }

    public int getLegsIndex() {
        return legsIndex;
    }

    public void setLegsIndex(int legsIndex) {
        this.legsIndex = legsIndex;
    }
}
