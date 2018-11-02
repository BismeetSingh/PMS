package com.app.bissudroid.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.bissudroid.myapplication.databinding.PerOrderDetailsBinding;
import com.app.bissudroid.myapplication.model.DiamondDetails;


public class DetailsFragment extends Fragment {

    PerOrderDetailsBinding perOrderDetailsBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        perOrderDetailsBinding=PerOrderDetailsBinding.inflate(inflater,container,false);
        return perOrderDetailsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setValues();
    }

    private void setValues() {
        DiamondDetails diamondDetails=getArguments().getParcelable("diamond");
        int id=diamondDetails.getSale_id();
        String ringSize=diamondDetails.getRingSize();
        String purity=diamondDetails.getMetal_purity();
        String mcolor=diamondDetails.getMetal_color();
        String dcolor=diamondDetails.getDiamond_color();
        int ringid=diamondDetails.getRingId();
        String clarity=diamondDetails.getClarity();
        String cut=diamondDetails.getDiamondCut();
        String weight=diamondDetails.getDiamondWeight();

        perOrderDetailsBinding.ringCode.setText(String.valueOf(ringid));
        perOrderDetailsBinding.ringSize.append(ringSize);
        perOrderDetailsBinding.diamondClarity.append(clarity);
        perOrderDetailsBinding.diamondCut.append(cut);
        perOrderDetailsBinding.metalColor.append(mcolor);
        perOrderDetailsBinding.metalPurity.append(purity);
        perOrderDetailsBinding.diamondColor.append(dcolor);
        perOrderDetailsBinding.diamondWeight.append(weight);
        perOrderDetailsBinding.salesId.append(String.valueOf(id));

        Toast.makeText(getActivity(), ""+id, Toast.LENGTH_SHORT).show();
    }
}
