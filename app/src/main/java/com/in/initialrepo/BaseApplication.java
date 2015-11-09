package com.in.initialrepo;


import android.support.v7.appcompat.BuildConfig;

import com.in.initialrepo.activities.BaseActivity;
import com.in.initialrepo.activities.MainActivity;
import com.in.initialrepo.daggerModules.AppModule;
import com.in.initialrepo.fragments.BaseFragment;
import com.in.initialrepo.utils.LifeCycleHandler;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Abhishek on 21/6/2015.
 */
public class BaseApplication extends android.app.Application {

    @Singleton
    @Component(modules = {AppModule.class})
    public interface ApplicationComponent {
        void inject(BaseApplication application);
        void inject(BaseActivity baseActivity);
        void inject(MainActivity mainActivity);
        void inject(BaseFragment baseFragment);
    }

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        //inject components
        component = DaggerBaseApplication_ApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component.inject(this);

        if (!BuildConfig.DEBUG) {
            // TODO Enable this after you get an api key
            //  Fabric.with(this, new Crashlytics());
        }

        //TODO Use this if you want to track if application is in background or forground
        registerActivityLifecycleCallbacks(new LifeCycleHandler());
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
