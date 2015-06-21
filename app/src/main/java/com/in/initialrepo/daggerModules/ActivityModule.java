package com.in.initialrepo.daggerModules;

import android.app.Application;

import com.in.initialrepo.activities.BaseActivity;
import com.in.initialrepo.activities.MainActivity;
import com.in.initialrepo.utils.Constants;
import com.in.initialrepo.utils.JacksonConverter;
import com.in.initialrepo.utils.WebServiceInterface;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
/**
 * Created by Abhishek on 21/6/2015.
 */
@Module(
        injects = {
                BaseActivity.class,
                MainActivity.class
        },
        addsTo = Application.class,
        library = true,
        complete = false,
        overrides = true
)
public class ActivityModule {

    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    /*@Provides
    @Singleton
    public AppPreferences providePreferences() {
        return new AppPreferences(activity);
    }*/


    @Provides
    @Singleton
    public WebServiceInterface provideWebServiceInterface() {

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.BASE_URL)
                .setConverter(new JacksonConverter())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(okHttpClient))
                .build();

        return restAdapter.create(WebServiceInterface.class);
    }
}
