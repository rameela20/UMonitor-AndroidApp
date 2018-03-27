package com.ram.umonitor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {

    Handler hand = new Handler();
    Button clickme;
    TextView timer;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private EditText mLoginEmailField;
    private EditText mLoginPasswordField;
    private Button mLoginBtn;

 //   Read more: http://mrbool.com/how-to-implement-multi-threading-in-android-with-handler-class/28175#ixzz4fLFnLoQB

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("users");
        mLoginEmailField=(EditText)findViewById(R.id.usernameTextView);
        mLoginPasswordField=(EditText)findViewById(R.id.passwordText);
        mLoginBtn=(Button)findViewById(R.id.LogInBtn);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogIn();
            }
        });



    }
    private void checkLogIn() {
        String email=mLoginEmailField.getText().toString().trim();
        String password=mLoginPasswordField.getText().toString().trim();

        if(!TextUtils.isEmpty(email)&& !TextUtils.isEmpty(password)){
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        checkUserExist();
                    }else{
                        Toast.makeText(LogInActivity.this, "Please Sign Up", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }

    private void checkUserExist() {
        final String user_id=mAuth.getCurrentUser().getUid();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(user_id)&(mAuth.getCurrentUser().getEmail().toString()).equals("rameela20@gmail.com")){
                    Intent mainIntent=new Intent(LogInActivity.this,MOActivity.class);
                    Toast.makeText(LogInActivity.this, "Signing in", Toast.LENGTH_SHORT).show();
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(mainIntent);
                }else if((mAuth.getCurrentUser().getEmail().toString()).equals("naduni20@gmail.com")){
                    Intent mainIntent=new Intent(LogInActivity.this,NurseActivity.class);
                    Toast.makeText(LogInActivity.this, "Signing in", Toast.LENGTH_SHORT).show();
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(mainIntent);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Toast.makeText(SignIn.this, "Error LogIn", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
