package com.app.bissudroid.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bissudroid.myapplication.OrderClickListener;
import com.app.bissudroid.myapplication.R;
import com.app.bissudroid.myapplication.databinding.OrderCardBinding;
import com.app.bissudroid.myapplication.model.DiamondDetails;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {
    private ArrayList<DiamondDetails> diamondDetails;
    private OrderClickListener orderClickListener;


    private LayoutInflater layoutInflater;

//    private OrderCardBinding orderCardBinding;

    public OrderListAdapter(Context context, OrderClickListener orderClickListener) {
        layoutInflater = LayoutInflater.from(context);
        this.orderClickListener = orderClickListener;
        diamondDetails = new ArrayList<>();
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        OrderCardBinding orderCardBinding = OrderCardBinding.inflate(layoutInflater, viewGroup, false);
//        View view=View.inflate(viewGroup.getContext(), R.layout.order_card,null);
        return new MyViewHolder(orderCardBinding, i);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.bind(diamondDetails.get(i));


    }

    public void update(ArrayList<DiamondDetails> diamondDetails) {
        this.diamondDetails.clear();
        this.diamondDetails.addAll(diamondDetails);
        notifyDataSetChanged();
    }
//
//    @Override
//    public int getItemViewType(int position) {
//
//
//        Timber.d("%s", pos);
//        return TimelineView.getTimeLineViewType(pos,3);
//    }

    @Override
    public int getItemCount() {

        return diamondDetails == null || diamondDetails.size() == 0 ? 0 : diamondDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        OrderCardBinding orderCardBinding;
//        TimelineView mTimelineView;

        MyViewHolder(@NonNull OrderCardBinding orderCardBinding, int viewtype) {
            super(orderCardBinding.getRoot());
            this.orderCardBinding = orderCardBinding;
//            mTimelineView = orderCardBinding.timelinecard;
//            mTimelineView.initLine(viewtype);
        }

        private void bind(DiamondDetails diamondDetails) {
            orderCardBinding.setDiamond(diamondDetails);
            diamondDetails.setArr(setarray(diamondDetails));
//            int arr[]=setarray(diamondDetails);

            orderCardBinding.getRoot().findViewById(R.id.updatePhase)
                    .setOnClickListener(v -> orderClickListener.OnClickOrder(getAdapterPosition(), diamondDetails,
                            diamondDetails.getArr()));
            orderCardBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    orderClickListener.onitemClick(getAdapterPosition(),diamondDetails);
                }
            });

            orderCardBinding.executePendingBindings();


        }

        private int[] setarray(DiamondDetails diamondDetails) {
            int arr[] = new int[6];
            arr[0] = diamondDetails.getPhase_CAD();
            arr[1] = diamondDetails.getPhase_CASTING();
            arr[2] = diamondDetails.getPhase_FILING();
            arr[3] = diamondDetails.getPhase_SETTING();
            arr[4] = diamondDetails.getPhase_FINISHING();
            arr[5] = diamondDetails.getPhase_DISPATCH();
            return arr;

        }
    }
    public void changePhases(int pos, int[] arr){
        this.diamondDetails.get(pos).setArr(arr);
        DiamondDetails diamondDetails1=this.diamondDetails.get(pos);
        diamondDetails1.setPhase_CAD(arr[0]);
        diamondDetails1.setPhase_CASTING(arr[1]);
        diamondDetails1.setPhase_FILING(arr[2]);
        diamondDetails1.setPhase_SETTING(arr[3]);
        diamondDetails1.setPhase_FINISHING(arr[4]);
        diamondDetails1.setPhase_DISPATCH(arr[5]);
        notifyDataSetChanged();
    }
}
