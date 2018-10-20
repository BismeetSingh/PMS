package com.app.bissudroid.myapplication.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.app.bissudroid.myapplication.service.PMSService;
import com.app.bissudroid.myapplication.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    SessionManager sessionManager;
    PMSService pmsService;
    public LoginRepository(SessionManager sessionManager, PMSService pmsService) {
        this.pmsService=pmsService;
        this.sessionManager=sessionManager;
    }
    public LiveData<Integer> login(String username, String  password){
        MutableLiveData<Integer> mutableLiveData=new MutableLiveData<>();
        pmsService.login(username,password).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
