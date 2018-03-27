package com.ram.umonitor.controller.firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ram.umonitor.model.User;

/**
 * Created by ASUS on 5/13/2017.
 */

public class SignUpController {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    boolean isSuccessful;
    OnResponse responder;

    public SignUpController(OnResponse onResponse, final User user){
        responder=onResponse;
        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("users");
        String email=user.getEmail();
        String password=user.getPassword();
        Log.d("Sign Up","Here 1");
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("Sign Up","Here 2");
                if(task.isSuccessful()) {
                    Log.d("Sign Up","Here");
                    String userID = mAuth.getCurrentUser().getUid();
                    user.setUserID(userID);
                    mDatabase.child(userID).setValue(user);

                    isSuccessful=true;
                    responder.responded(isSuccessful);
                }else{
                    isSuccessful=false;
                }





            }
        });


    }







}
