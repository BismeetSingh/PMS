package com.app.bissudroid.myapplication.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.app.bissudroid.myapplication.model.DiamondDetails;
import com.app.bissudroid.myapplication.repository.HomeSalesRepository;

import java.util.List;

public class DiamondDetailsViewModel extends ViewModel {
    private HomeSalesRepository homeSalesRepository;

    public DiamondDetailsViewModel(HomeSalesRepository homeSalesRepository) {
        this.homeSalesRepository=homeSalesRepository;
    }
    public LiveData<List<DiamondDetails>> getOrders(){
        return homeSalesRepository.getOrders();
    }
    public LiveData<String> updatePhases(int saleid,int cad,int cast,int dispatch,int filing,int setting,int finishing){
        return homeSalesRepository.updatePhases(saleid,cad,cast,dispatch,filing,setting,finishing);

    }
    public LiveData<String> deleteSale(int saleid){
        return homeSalesRepository.deleteSale(saleid);

    }
}
