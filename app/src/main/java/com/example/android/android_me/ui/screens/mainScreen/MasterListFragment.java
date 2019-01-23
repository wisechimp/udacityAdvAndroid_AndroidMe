package com.example.android.android_me.ui.screens.mainScreen;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;
import com.example.android.android_me.ui.screens.mainScreen.recyclerViewFiles.CustomRVItemTouchListener;
import com.example.android.android_me.ui.screens.mainScreen.recyclerViewFiles.MasterListGridAdapter;
import com.example.android.android_me.ui.screens.mainScreen.recyclerViewFiles.RecyclerViewItemClickListener;

import java.util.List;

public class MasterListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context mContext;

    OnImageClickListener mCallback;

    public interface OnImageClickListener {
        void onImageSelected (int position);
    }

    private List<Integer> mAllImageIds;

    public MasterListFragment () {
    }

    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
            + " must implement OnImageClickListener");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = this.getActivity().getApplicationContext();
        setAllImageIds(AndroidImageAssets.getAll());

        // Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        mRecyclerView = rootView.findViewById(R.id.master_list_fragment_rv);

        mLayoutManager = new GridLayoutManager(mContext, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MasterListGridAdapter(mContext, mAllImageIds);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new CustomRVItemTouchListener(mContext, mRecyclerView, new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                mCallback.onImageSelected(position);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return rootView;
    }

    public void setAllImageIds(List<Integer> allImageIds) {
        mAllImageIds = allImageIds;
    }

}
