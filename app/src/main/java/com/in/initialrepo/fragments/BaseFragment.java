package com.in.initialrepo.fragments;


import android.app.Fragment;
import android.os.Bundle;

import com.in.initialrepo.activities.BaseActivity;

/**
 * Created by Abhishek on 21/6/2015.
 */
public class BaseFragment extends Fragment {

    private BaseActivity baseActivity;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        baseActivity = ((BaseActivity) getActivity());
        baseActivity.inject(this);
    }
}
