package com.app.bissudroid.myapplication.factory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.app.bissudroid.myapplication.repository.HomeSalesRepository;
import com.app.bissudroid.myapplication.viewmodel.DiamondDetailsViewModel;

public class HomeScreenFactory extends ViewModelProvider.NewInstanceFactory {
private HomeSalesRepository HomeSalesRepository;

public HomeScreenFactory(HomeSalesRepository HomeSalesRepository) {
        this.HomeSalesRepository = HomeSalesRepository;
        }

@NonNull
@Override
public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new DiamondDetailsViewModel(HomeSalesRepository);
        }
        }
