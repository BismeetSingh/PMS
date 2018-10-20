package com.app.bissudroid.myapplication.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.app.bissudroid.myapplication.model.DiamondDetails;
import com.app.bissudroid.myapplication.service.PMSService;
import com.app.bissudroid.myapplication.utils.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeSalesRepository {

    private PMSService pmsService;
    public HomeSalesRepository( PMSService pmsService) {
        this.pmsService=pmsService;

    }
    public LiveData<List<DiamondDetails>> getOrders(){
        MutableLiveData<List<DiamondDetails>> listMutableLiveData=new MutableLiveData<>();
        pmsService.getDiamondDetails().enqueue(new Callback<List<DiamondDetails>>() {
            @Override
            public void onResponse(Call<List<DiamondDetails>> call, Response<List<DiamondDetails>> response) {
                listMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<DiamondDetails>> call, Throwable t) {

            }
        });
        return listMutableLiveData;
    }
}
