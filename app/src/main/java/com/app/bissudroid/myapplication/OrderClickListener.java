package com.app.bissudroid.myapplication;

import android.view.View;

import com.app.bissudroid.myapplication.model.DiamondDetails;

public interface OrderClickListener {
    void OnClickOrder(int pos, DiamondDetails diamondDetails, int arr[]);
    void onitemClick(int pos,DiamondDetails diamondDetails);
}
