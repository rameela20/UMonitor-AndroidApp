package com.ram.umonitor.controller.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ram.umonitor.model.PeriodAssess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 6/10/2017.
 */

public class AllPeriodAssessController {
    DatabaseReference mDatabaseLaw;
    List <PeriodAssess> periodAssessDescList;
    public OnResponse response;


    public AllPeriodAssessController(OnResponse responder){
        mDatabaseLaw= FirebaseDatabase.getInstance().getReference().child("periodAssess");

        this.response=responder;
        mDatabaseLaw.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
               periodAssessDescList=new ArrayList<PeriodAssess>();

                    for (DataSnapshot patientDatasnapshot:dataSnapshot.getChildren()){
                       PeriodAssess periodAssess=patientDatasnapshot.getValue(PeriodAssess.class);

                        periodAssessDescList.add(periodAssess);

                    }



                Log.d("PeriodSIZE ",periodAssessDescList.size()+" ");
                response.responded(periodAssessDescList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public List<PeriodAssess> getAll(){
        return periodAssessDescList;
    }

}
