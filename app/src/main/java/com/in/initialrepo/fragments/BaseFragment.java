package com.in.initialrepo.fragments;


import android.app.Fragment;
import android.os.Bundle;

import com.in.initialrepo.BaseApplication;


public class BaseFragment extends Fragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((BaseApplication)getActivity().getApplication()).getComponent().inject(this);
    }
}
