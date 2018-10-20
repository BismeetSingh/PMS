package com.app.bissudroid.myapplication.di;

import com.app.bissudroid.myapplication.BuildConfig;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import timber.log.Timber;

public class PMSApplication extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.uprootAll();
        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        PMSComponent studentComponent = DaggerPMSComponent.builder().buildapp(this).build();
        studentComponent.inject(this);
        return studentComponent;
    }

}
