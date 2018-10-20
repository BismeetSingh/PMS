package com.app.bissudroid.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.app.bissudroid.myapplication.databinding.OrderCardBinding;
import com.app.bissudroid.myapplication.model.DiamondDetails;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {
    private ArrayList<DiamondDetails> diamondDetails;
    private int pos;
    private LayoutInflater layoutInflater;
    private Context context;
//    private OrderCardBinding orderCardBinding;

    public OrderListAdapter(Context context) {
        this.context=context;
        layoutInflater = LayoutInflater.from(context);
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
            orderCardBinding.executePendingBindings();


        }
    }
}
