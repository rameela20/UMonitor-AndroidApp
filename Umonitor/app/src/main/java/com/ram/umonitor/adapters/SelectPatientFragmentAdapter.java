package com.ram.umonitor.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.ram.umonitor.MOActivity;
import com.ram.umonitor.R;
import com.ram.umonitor.fragments.Assessment;
import com.ram.umonitor.model.Patient;

import java.util.List;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class SelectPatientFragmentAdapter extends FirebaseRecyclerAdapter<Patient,SelectPatientViewHolder> {
    private List<Patient> patientsList;
    private Context context;

    public SelectPatientFragmentAdapter(Class<Patient> modelClass, int modelLayout, DatabaseReference ref,Context context){
        super(modelClass, modelLayout, SelectPatientViewHolder.class, ref);
        this.context = context;
    }

    private Context getContext(){
        return context;
    }


    @Override
    protected void populateViewHolder(SelectPatientViewHolder viewHolder, Patient model, int position) {
        if(model.getGender().equals("M"))
            viewHolder.shortDesc.setText("Male");
        else
            viewHolder.shortDesc.setText("Female");
        viewHolder.title.setText(model.getName());

        viewHolder.mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Patient Selected",Toast.LENGTH_SHORT).show();
                Fragment frag = new Assessment();

                FragmentTransaction transaction =((MOActivity)getContext()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainFrame, frag);//have to select the first fragment
                transaction.commitAllowingStateLoss();

            }
        });
    }
}
