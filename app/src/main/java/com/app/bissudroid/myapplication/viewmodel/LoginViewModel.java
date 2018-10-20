package com.app.bissudroid.myapplication.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.app.bissudroid.myapplication.repository.LoginRepository;

public class LoginViewModel extends ViewModel {
    private LoginRepository loginRepository;


    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository=loginRepository;

    }
    public LiveData<Integer> login(String email, String password){
       return loginRepository.login(email,password);
    }

}
