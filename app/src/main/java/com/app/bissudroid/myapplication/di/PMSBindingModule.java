package com.app.bissudroid.myapplication.di;

import android.support.design.widget.NavigationView;

import com.app.bissudroid.myapplication.activity.LoginActivity;
import com.app.bissudroid.myapplication.activity.NavigationActivity;
import com.app.bissudroid.myapplication.activity.OrderDetailsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = {MainActivityModule.class,NavigationModule.class})
public abstract class PMSBindingModule {
    @ContributesAndroidInjector
    abstract LoginActivity getMainActivity();
    @ContributesAndroidInjector
    abstract
    OrderDetailsFragment orderDetailsFragment();
    @ContributesAndroidInjector
    abstract NavigationActivity navigationActivity();

}
