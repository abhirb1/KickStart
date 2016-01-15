package com.in.initialrepo;


import com.in.initialrepo.activities.BaseActivity;
import com.in.initialrepo.activities.MainActivity;
import com.in.initialrepo.daggerModules.AppModule;
import com.in.initialrepo.fragments.BaseFragment;
import com.in.initialrepo.utils.LifeCycleHandler;

import javax.inject.Singleton;

import dagger.Component;
import timber.log.Timber;

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
            // Timber.plant(new CrashlyticsTree());
        } else {
            Timber.plant(new Timber.DebugTree());
        }

        //TODO Use this if you want to track if application is in background or forground
        registerActivityLifecycleCallbacks(new LifeCycleHandler());
    }

    public ApplicationComponent getComponent() {
        return component;
    }

    /**
     * A tree which logs important information for crash reporting.
     */
   /* private static class CrashlyticsTree extends Timber.HollowTree {
        @Override
        public void v(String message, Object... args) {
            logMessage(message, args);
        }

        @Override
        public void v(Throwable t, String message, Object... args) {
            logMessage(message, args);
            // NOTE: We are explicitly not sending the exception to Crashlytics here.
        }

        @Override
        public void i(String message, Object... args) {
            logMessage(message, args);
        }

        @Override
        public void i(Throwable t, String message, Object... args) {
            logMessage(message, args);
            // NOTE: We are explicitly not sending the exception to Crashlytics here.
        }

        @Override
        public void w(String message, Object... args) {
            logMessage("WARN: " + message, args);
        }

        @Override
        public void w(Throwable t, String message, Object... args) {
            logMessage("WARN: " + message, args);
            // NOTE: We are explicitly not sending the exception to Crashlytics here.
        }

        @Override
        public void e(String message, Object... args) {
            logMessage("ERROR: " + message, args);
        }

        @Override
        public void e(Throwable t, String message, Object... args) {
            logMessage("ERROR: " + message, args);
            Crashlytics.logException(t);
        }

        private void logMessage(String message, Object... args) {
            try {
                Crashlytics.log(String.format(message, args));
            } catch (MissingFormatArgumentException e) {
                Timber.e("Application MissingFormatArgumentException");
            } catch (NullPointerException e) {
                Timber.e("Message is null handled NullPointerException");
            } catch (Exception e) {
                Timber.e("Exception Handled");
            }
        }
    }*/
}
