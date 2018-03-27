package com.ram.umonitor.adapters;

import android.content.Context;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.ram.umonitor.model.PeriodAssess;
import com.ram.umonitor.model.Treatment;

import java.util.List;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class TreatmentManagementFragmentAdapter extends FirebaseRecyclerAdapter<Treatment,TreatmentManagementViewHolder> {
    private List<PeriodAssess> periodAssessList;
    private Context context;

    public TreatmentManagementFragmentAdapter(Class<Treatment> modelClass, int modelLayout, DatabaseReference ref, Context context) {
        super(modelClass, modelLayout, TreatmentManagementViewHolder.class, ref);
        this.context = context;
    }

    @Override
    protected void populateViewHolder(TreatmentManagementViewHolder viewHolder, Treatment model, int position) {
        viewHolder.bedNo.setText("Bed No: :" + model.getBedNo());
        viewHolder.shortDesc.setText("Description :" + model.getDrugName());


    }

    private Context getContext() {
        return context;
    }

}