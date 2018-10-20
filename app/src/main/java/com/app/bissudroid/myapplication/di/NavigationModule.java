package com.app.bissudroid.myapplication.di;

import com.app.bissudroid.myapplication.factory.HomeScreenFactory;
import com.app.bissudroid.myapplication.factory.LoginFactory;
import com.app.bissudroid.myapplication.repository.HomeSalesRepository;
import com.app.bissudroid.myapplication.repository.LoginRepository;
import com.app.bissudroid.myapplication.service.PMSService;
import com.app.bissudroid.myapplication.utils.SessionManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
@Module
public class NavigationModule {
    @Provides
    @Singleton
    HomeScreenFactory getHomeFactory(HomeSalesRepository loginRepository){
        return new HomeScreenFactory(loginRepository);
    }
    @Provides
    HomeSalesRepository getHome( PMSService pmsService){
        return new HomeSalesRepository(pmsService);
    }
}
