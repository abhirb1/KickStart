package com.in.initialrepo.daggerModules;

import android.content.Context;

import com.in.initialrepo.BaseApplication;
import com.in.initialrepo.utils.Constants;
import com.in.initialrepo.utils.WebServiceInterface;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


@Module
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

    @Provides
    @Singleton
    public WebServiceInterface provideWebServiceInterface() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        okHttpClient.interceptors().add(logging);
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return restAdapter.create(WebServiceInterface.class);
    }

}
