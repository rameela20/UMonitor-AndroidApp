package com.ram.umonitor.controller.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ram.umonitor.model.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 6/10/2017.
 */

public class AllPatientsController {
    DatabaseReference mDatabaseLaw;
    List <Patient> patientsDescList;
    public OnResponse response;


    public AllPatientsController(OnResponse responder){
        mDatabaseLaw= FirebaseDatabase.getInstance().getReference().child("patients");

        this.response=responder;
        mDatabaseLaw.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
                patientsDescList=new ArrayList<Patient>();

                    for (DataSnapshot patientDatasnapshot:dataSnapshot.getChildren()){
                       Patient patient=patientDatasnapshot.getValue(Patient.class);

                        patientsDescList.add(patient);

                    }



                Log.d("PATIENTSIZE ",patientsDescList.size()+" ");
                response.responded(patientsDescList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public List<Patient> getAllLawDescForTags(){
        return patientsDescList;
    }

}
