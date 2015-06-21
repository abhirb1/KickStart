package com.in.initialrepo.daggerModules;

import android.content.Context;

import com.in.initialrepo.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Abhishek on 21/6/2015.
 */
@Module(
        injects = {
                BaseApplication.class
        },
        library = true,
        complete = false

)
public class AppModule {
    private BaseApplication app;

    public AppModule(BaseApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return app;
    }

}
