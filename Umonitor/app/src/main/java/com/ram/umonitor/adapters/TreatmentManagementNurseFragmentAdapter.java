package com.ram.umonitor.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.ram.umonitor.model.PeriodAssess;
import com.ram.umonitor.model.Treatment;

import java.util.List;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class TreatmentManagementNurseFragmentAdapter extends FirebaseRecyclerAdapter<Treatment,TreatmentManagementNurseViewHolder> {
    private List<PeriodAssess> periodAssessList;
    private Context context;

    public TreatmentManagementNurseFragmentAdapter(Class<Treatment> modelClass, int modelLayout, DatabaseReference ref, Context context) {
        super(modelClass, modelLayout, TreatmentManagementNurseViewHolder.class, ref);
        this.context = context;
    }

    @Override
    protected void populateViewHolder(final TreatmentManagementNurseViewHolder viewHolder, Treatment model, int position) {
        viewHolder.bedNo.setText("Bed No: :" + model.getBedNo());
        viewHolder.shortDesc.setText("Description :" + model.getDrugName());
        viewHolder.btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Treatment Done",Toast.LENGTH_SHORT).show();
                viewHolder.btnDone.setEnabled(false);
                viewHolder.btnDone.setBackgroundColor(Color.GRAY);
                viewHolder.btnDone.setText("Done");
            }
        });


    }

    private Context getContext() {
        return context;
    }

}