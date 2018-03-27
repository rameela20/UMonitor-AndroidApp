package com.ram.umonitor.adapters;

import android.content.Context;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.ram.umonitor.model.PeriodAssess;

import java.util.List;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class PeriodAssessFragmentAdapter extends FirebaseRecyclerAdapter<PeriodAssess,PeriodAssessViewHolder> {
    private List<PeriodAssess> periodAssessList;
    private Context context;

    public PeriodAssessFragmentAdapter(Class<PeriodAssess> modelClass, int modelLayout, DatabaseReference ref, Context context) {
        super(modelClass, modelLayout, PeriodAssessViewHolder.class, ref);
        this.context = context;
    }

    @Override
    protected void populateViewHolder(PeriodAssessViewHolder viewHolder, PeriodAssess model, int position) {
        viewHolder.time.setText("Time :" + model.getTime());
        viewHolder.satu.setText("Saturation :" + model.getSatu());
        viewHolder.bedNo.setText("Bed No :" + model.getBedNo());
        viewHolder.temp.setText("Temperature :" + model.getTemp());
    }

    private Context getContext() {
        return context;
    }

}