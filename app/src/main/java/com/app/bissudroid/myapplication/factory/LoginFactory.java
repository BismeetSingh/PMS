package com.app.bissudroid.myapplication.factory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.app.bissudroid.myapplication.repository.LoginRepository;
import com.app.bissudroid.myapplication.viewmodel.LoginViewModel;

public class LoginFactory extends ViewModelProvider.NewInstanceFactory {
    private LoginRepository loginRepository;

    public LoginFactory(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(loginRepository);
    }
}
