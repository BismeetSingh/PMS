package com.app.bissudroid.myapplication.di;

import com.app.bissudroid.myapplication.factory.LoginFactory;
import com.app.bissudroid.myapplication.repository.LoginRepository;
import com.app.bissudroid.myapplication.service.PMSService;
import com.app.bissudroid.myapplication.utils.SessionManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    @Singleton
    LoginFactory getLoginFactory(LoginRepository loginRepository){
        return new LoginFactory(loginRepository);
    }
    @Provides
    LoginRepository getLoginRepository(SessionManager sessionManager, PMSService pmsService){
        return new LoginRepository(sessionManager,pmsService);
    }
}
