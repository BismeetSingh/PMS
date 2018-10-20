package com.app.bissudroid.myapplication.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AndroidInjectionModule.class,PMSModule.class,PMSBindingModule.class})
public interface PMSComponent extends AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder{
        PMSComponent build();
        @BindsInstance
        Builder buildapp(Application application);
    }

}
