package com.ram.umonitor.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ram.umonitor.R;
import com.ram.umonitor.controller.firebase.OnResponse;
import com.ram.umonitor.model.User;

public class ControlTest extends AppCompatActivity implements OnResponse{

    boolean isSuccess;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_test);

        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("users");

        Log.d("Sign Up","Here 1");

               User patient=new User();
               patient.setEmail("naduni20@gmail.com");
                patient.setPassword("naduni");
                patient.setName("Naduni Premasiri");
                patient.setUserType("Nurse");
                patient.setAddress("6A,Colombo 3");
                patient.setNIC("935914176V");
                patient.setGender("F");
                //patient.setSpecialty("Head Nurse");
                Log.d("Sign Up","Here 2");

                    Log.d("Sign Up","Here");
                    String PID = "GMCKNuwheeMeMuSGEgifivbK1QF3";
                   patient.setUserID(PID);
                    mDatabase.child(PID).setValue(patient);










    }

    @Override
    public void responded(Object obj) {
        isSuccess=(boolean)obj;
        Log.d("Added user ",isSuccess+" ");
    }
}
