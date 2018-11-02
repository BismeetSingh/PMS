package com.app.bissudroid.myapplication.fragment;

import android.app.AlertDialog;
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
import android.widget.CheckedTextView;
import android.widget.Toast;

import com.app.bissudroid.myapplication.OrderClickListener;
import com.app.bissudroid.myapplication.R;
import com.app.bissudroid.myapplication.adapter.OrderListAdapter;
import com.app.bissudroid.myapplication.databinding.OrderListBinding;
import com.app.bissudroid.myapplication.databinding.PhasesDialogBinding;
import com.app.bissudroid.myapplication.factory.HomeScreenFactory;
import com.app.bissudroid.myapplication.model.DiamondDetails;
import com.app.bissudroid.myapplication.viewmodel.DiamondDetailsViewModel;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;

import androidx.navigation.Navigation;
import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;

public class OrderDetailsFragment extends Fragment implements OrderClickListener {
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
        orderListBinding = OrderListBinding.inflate(inflater, container, false);
        orderListBinding.listorders.setLayoutManager(new LinearLayoutManager(context));
        orderListAdapter = new OrderListAdapter(getActivity(), this);
        orderListBinding.listorders.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        diamondDetailsViewModel = ViewModelProviders.of(this, homeScreenFactory).get(DiamondDetailsViewModel.class);
        return orderListBinding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<DiamondDetails> diamondDetailsList = new ArrayList<>();
        diamondDetailsViewModel.getOrders().observe(this, diamondDetails -> {
            orderListBinding.listorders.setAdapter(orderListAdapter);

            if (diamondDetails != null) {
                for (int i = 0; i < diamondDetails.size(); i++) {
                    String tagline = diamondDetails.get(i).getTagline();
                    String dcolor = diamondDetails.get(i).getDiamond_color();
                    String ringSize = diamondDetails.get(i).getRingSize();
                    String clarity = diamondDetails.get(i).getClarity();
                    String mtype = diamondDetails.get(i).getMetal_type();
                    String mpurity = diamondDetails.get(i).getMetal_purity();
                    String mcolor = diamondDetails.get(i).getMetal_color();
                    int sale_id = diamondDetails.get(i).getSale_id();
                    int cad = diamondDetails.get(i).getPhase_CAD();
                    int casting = diamondDetails.get(i).getPhase_CASTING();
                    int dispatch = diamondDetails.get(i).getPhase_DISPATCH();
                    int filing = diamondDetails.get(i).getPhase_FILING();
                    int setting = diamondDetails.get(i).getPhase_SETTING();
                    int finishing = diamondDetails.get(i).getPhase_FINISHING();
                    String cut=diamondDetails.get(i).getDiamondCut();
                    String weight=diamondDetails.get(i).getDiamondWeight();
                    int ringid=diamondDetails.get(i).getRingId();
                    DiamondDetails diamondDetailsitem = new DiamondDetails(sale_id, tagline, dcolor, mcolor, clarity, mtype, mpurity, ringSize
                            , cad, casting, filing, setting, finishing, dispatch,cut,weight,ringid);
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
//        orderListAdapter.update(diamondDetailsList);f
//    }

    @Override
    public void onAttach(Context context) {
        Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
//        AndroidInjection.inject(this);
    }

    /**
     * This method saves the phases changed of the respective salesId.
     */
    @Override
    public void OnClickOrder(int pos, DiamondDetails diamondDetails, int arr[]) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Timber.d("%s", Arrays.toString(arr));
        PhasesDialogBinding phasesDialogBinding = PhasesDialogBinding.inflate(LayoutInflater.from(getActivity()), null, false);
        CheckedTextView textView[] = getArrayOfViews(phasesDialogBinding);
        setListener(textView, arr);

        builder.setView(phasesDialogBinding.getRoot());
        builder.setPositiveButton("Save", (dialog, which) -> {
            checkPhases(pos, textView, diamondDetails);

            dialog.dismiss();
        });
        builder.setNegativeButton("Cancel", ((dialog, which) -> {
            dialog.dismiss();
        }));
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public void onitemClick(int pos, DiamondDetails diamondDetails) {
        Bundle bundle=new Bundle();
        bundle.putParcelable("diamond",diamondDetails);
        Navigation.findNavController(orderListBinding.getRoot()).navigate(R.id.details,bundle);
    }

    /**
     * This method saves the updated phases to the databases after assigning respective booleans,
     */
    private void checkPhases(int pos, CheckedTextView[] textView, DiamondDetails diamondDetails) {
        int cad = 0, cast = 0, finish = 0, dispatch = 0, setting = 0, filing = 0;
        if (textView[0].isChecked()) {
            cad = 1;
        }
        if (textView[1].isChecked()) {
            cast = 1;
        }
        if (textView[2].isChecked()) {
            filing = 1;
        }
        if (textView[3].isChecked()) {
            setting = 1;
        }
        if (textView[4].isChecked()) {
            finish = 1;
        }
        if (textView[5].isChecked()) {
            dispatch = 1;
        }
        int arr[] = new int[6];
        arr[0] = cad;
        arr[1] = cast;
        arr[2] = filing;
        arr[3] = setting;
        arr[4] = finish;
        arr[5] = dispatch;
        diamondDetails.setArr(arr);
        orderListAdapter.changePhases(pos, arr);

        diamondDetailsViewModel.updatePhases(1, cad, cast, dispatch, filing, setting, finish)
                .observe(this, s -> Toast.makeText(context, "" + s, Toast.LENGTH_SHORT).show());
    }

    private void setListener(CheckedTextView[] textView, int[] arr) {

        for (int i = 0; i < textView.length; i++) {
            if (arr[i] == 0) {
                textView[i].setCheckMarkDrawable(null);
                textView[i].setChecked(false);
            } else {
                textView[i].setCheckMarkDrawable(R.drawable.tick);
                textView[i].setChecked(true);
            }
            int finalI = i;
            textView[i].setOnClickListener(v -> {
                if(!textView[finalI].isChecked()) {
                    textView[finalI].setChecked(true);
                    textView[finalI].setCheckMarkDrawable(R.drawable.tick);
                }
                else {
                    textView[finalI].setChecked(false);
                    textView[finalI].setCheckMarkDrawable(null);
                }
                if (textView[finalI].isChecked()) {
                    for (int j = 0; j <= finalI; j++) {
                        textView[j].setChecked(true);
                        textView[j].setCheckMarkDrawable(R.drawable.tick);


                    }
                }
                else {
                    for (int j=finalI+1;j<6;j++){
                        textView[j].setChecked(false);
                        textView[j].setCheckMarkDrawable(null);

                    }
                }
//                    for (int j=finalI;j<textView.length;j++){
//                        textView[j].setChecked(false);
//                        textView[j].setCheckMarkDrawable(null);
//                    }


            });
        }
        Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
    }

    private CheckedTextView[] getArrayOfViews(PhasesDialogBinding phasesDialogBinding) {
        CheckedTextView viewArray[] = new CheckedTextView[6];
        viewArray[0] = phasesDialogBinding.checkedCad;
        viewArray[1] = phasesDialogBinding.checkedCasting;
        viewArray[2] = phasesDialogBinding.checkedFiling;
        viewArray[3] = phasesDialogBinding.checkedSetting;
        viewArray[4] = phasesDialogBinding.checkedFinishing;
        viewArray[5] = phasesDialogBinding.checkedDispatch;
        return viewArray;

    }


}
