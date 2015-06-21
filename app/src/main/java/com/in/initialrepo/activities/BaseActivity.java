package com.in.initialrepo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.in.initialrepo.BaseApplication;
import com.in.initialrepo.daggerModules.ActivityModule;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Abhishek on 21/6/2015.
 */
public class BaseActivity extends Activity {

    private ObjectGraph activityGraph;
    private BaseApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (BaseApplication) getApplication();
        activityGraph = application.getApplicationGraph().plus(getModules().toArray());
        activityGraph.inject(this);
    }

    @Override
    protected void onDestroy() {
        activityGraph = null;
        super.onDestroy();
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(new ActivityModule(this));
    }

    public void inject(Object object) {
        activityGraph.inject(object);
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
}