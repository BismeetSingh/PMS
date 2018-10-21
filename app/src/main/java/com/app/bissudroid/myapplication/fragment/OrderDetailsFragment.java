package com.app.bissudroid.myapplication.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bissudroid.myapplication.adapter.OrderListAdapter;
import com.app.bissudroid.myapplication.databinding.OrderListBinding;
import com.app.bissudroid.myapplication.factory.HomeScreenFactory;
import com.app.bissudroid.myapplication.model.DiamondDetails;
import com.app.bissudroid.myapplication.viewmodel.DiamondDetailsViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class OrderDetailsFragment extends Fragment {
//    OrderListBinding orderListBinding;
    @Inject
    Context context;
    @Inject
    HomeScreenFactory homeScreenFactory;
    DiamondDetailsViewModel diamondDetailsViewModel;
    OrderListBinding orderListBinding;
    OrderListAdapter orderListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        orderListBinding=OrderListBinding.inflate(inflater,container,false);
        orderListBinding.listorders.setLayoutManager(new LinearLayoutManager(context));
        orderListAdapter=new OrderListAdapter(getActivity());
        orderListBinding.listorders.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        diamondDetailsViewModel=ViewModelProviders.of(this,homeScreenFactory).get(DiamondDetailsViewModel.class) ;


        return orderListBinding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<DiamondDetails> diamondDetailsList=new ArrayList<>();
        diamondDetailsViewModel.getOrders().observe(this, diamondDetails -> {
            orderListBinding.listorders.setAdapter(orderListAdapter);

            if (diamondDetails != null) {
                for (int i=0;i<diamondDetails.size();i++){
                    String tagline=diamondDetails.get(i).getTagline();
                    String dcolor=diamondDetails.get(i).getDiamond_color();
                    String ringSize=diamondDetails.get(i).getRingSize();
                    String clarity=diamondDetails.get(i).getClarity();
                    String mtype=diamondDetails.get(i).getMetal_type();
                    String mpurity=diamondDetails.get(i).getMetal_purity();
                    String mcolor=diamondDetails.get(i).getMetal_color();
                    DiamondDetails diamondDetailsitem=new DiamondDetails(tagline,dcolor,mcolor,clarity,mtype,mpurity,ringSize);
                    diamondDetailsList.add(diamondDetailsitem);
                }

                orderListAdapter.update(diamondDetailsList);
            }


        });
//        setMockData();
    }

//    private void setMockData() {
//        ArrayList<DiamondDetails> diamondDetailsList=new ArrayList<>();
//        for (int i=0;i<100;i++){
//            String tagline="tag"+i;
//            String color ="red"+i;
//            String clarity="clarity"+i;
//            String metal="metal"+i;
//            String ring="ringsize"+i;
//            String pcode="pcode"+i;
//            DiamondDetails diamondDetails=new DiamondDetails(i,tagline,color,clarity,metal,ring,pcode);
//            diamondDetailsList.add(diamondDetails);
//
//        }
//        orderListAdapter.update(diamondDetailsList);
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
//        AndroidInjection.inject(this);
    }
}
