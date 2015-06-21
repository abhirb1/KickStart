package com.in.initialrepo;


import com.in.initialrepo.daggerModules.AppModule;
import com.in.initialrepo.utils.LifeCycleHandler;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Abhishek on 21/6/2015.
 */
public class BaseApplication extends android.app.Application {

    private ObjectGraph applicationGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        //create object graph
        applicationGraph = ObjectGraph.create(getModules().toArray());
        applicationGraph.inject(this);

        if (!BuildConfig.DEBUG) {
            // TODO Enable this after you get an api key
            //  Fabric.with(this, new Crashlytics());
        }

        //TODO Use this if you want to track if application is in background or forground
        registerActivityLifecycleCallbacks(new LifeCycleHandler());
    }


    private List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule(this));
    }

    public ObjectGraph getApplicationGraph() {
        return this.applicationGraph;
    }

}
