package com.app.bissudroid.myapplication.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.app.bissudroid.myapplication.model.DiamondDetails;
import com.app.bissudroid.myapplication.repository.HomeSalesRepository;

import java.util.List;

public class DiamondDetailsViewModel extends ViewModel {
    HomeSalesRepository homeSalesRepository;

    public DiamondDetailsViewModel(HomeSalesRepository homeSalesRepository) {
        this.homeSalesRepository=homeSalesRepository;
    }
    public LiveData<List<DiamondDetails>> getOrders(){
        return homeSalesRepository.getOrders();
    }
}
