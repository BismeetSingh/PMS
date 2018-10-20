package com.app.bissudroid.myapplication.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.app.bissudroid.myapplication.service.PMSService;
import com.app.bissudroid.myapplication.utils.SessionManager;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class PMSModule {
    @Provides
    @Singleton
    static Context getContext(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    static HttpLoggingInterceptor getHttpLoggingInterceptor() {

        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    static OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).
                connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS).build();
    }

    @Provides
    @Singleton
    static Retrofit getRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(PMSService.ENDPOINT).build();

    }

    @Provides
    @Singleton
    static PMSService getPMSService(Retrofit retrofit) {
        return retrofit.create(PMSService.class);
    }
    @Provides
    @Singleton
    static SessionManager getSessionManager(SharedPreferences sharedPreferences){
        return new SessionManager(sharedPreferences);
    }

}
