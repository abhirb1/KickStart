package com.in.initialrepo.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import timber.log.Timber;


public class LifeCycleHandler implements Application.ActivityLifecycleCallbacks {

    public static int resumed;
    public static int stopped;
    public static int paused;
    public static boolean isBackgroundedOnce;

    public static boolean isApplicationInBackground() {
        if (resumed == paused) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
        ++resumed;
    }

    @Override
    public void onActivityPaused(Activity activity) {
        ++paused;
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {
        ++stopped;
        if (resumed == paused) {
            isBackgroundedOnce = true;
        }
        Timber.d("resumed count" + LifeCycleHandler.resumed + "paused count" + LifeCycleHandler
                .paused + "stopped count" + LifeCycleHandler.stopped);
        Timber.i("Application is being backgrounded " + (resumed == paused));
    }
}

