package com.in.initialrepo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.in.initialrepo.BaseApplication;
import com.in.initialrepo.utils.WebServiceInterface;

import javax.inject.Inject;

import timber.log.Timber;

public class BaseActivity extends Activity {

    @Inject
    WebServiceInterface webServiceInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication)getApplication()).getComponent().inject(this);
        initUi();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void initUi() {
        if(webServiceInterface != null) {
            Timber.i("Inject successful");
        }
    }
}