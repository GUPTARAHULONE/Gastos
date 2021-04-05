package com.example.gastos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class step_pin_activity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String user_id;
    FirebaseFirestore db;
    private String email,pin;
    private EditText edt1,edt2,edt3,edt4,edt5;
    private Button btnDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_pin_activity);

        edt1 = findViewById(R.id.inputpin1);
        edt2 = findViewById(R.id.inputpin2);
        edt3 = findViewById(R.id.inputpin3);
        edt4 = findViewById(R.id.inputpin4);
        edt5 = findViewById(R.id.inputpin5);

        btnDone = findViewById(R.id.btnOk);

        mAuth = FirebaseAuth.getInstance();
        user_id = mAuth.getCurrentUser().getUid();
        db= FirebaseFirestore.getInstance();
        setpin();
        email = new getotp_activity().phonenumber_value + "@example.com";


//        btnDone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(email != null && pin != null)
//                {
//                    createAccount(email,pin);
//                }
//
//
//            }
//        });







        btnDone.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pin = edt1.getText().toString() + edt2.getText().toString() + edt3.getText().toString() +
                    edt4.getText().toString() + edt5.getText().toString();
            if(pin.length() == 5 ) {
                Map<String, Object> usermap = new HashMap<>();

                usermap.put("setpin=", pin);

                db.collection("users_pin")
                        .add(usermap)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                //Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                                Toast.makeText(step_pin_activity.this, "set pin done=" + pin, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("TAG", "Error adding document", e);
                            }
                        });
                Intent i = new Intent(step_pin_activity.this, Account_verified_activity.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(step_pin_activity.this, "PIN Should Be Of 5 Digits" , Toast.LENGTH_SHORT).show();
            }
        }
    });
}

    private void setpin()
    {
        edt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty())
                {
                    edt2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty())
                {
                    edt3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty())
                {
                    edt4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty())
                {
                    edt5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//
//        }
//        else
//        {
////            signIn(email , pin);
//        }
//
//    }
//
//    private void createAccount(String email, String password) {
//        // [START create_user_with_email]
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
////                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            Toast.makeText(step_pin_activity.this, "Authentication Success.",
//                                    Toast.LENGTH_SHORT).show();
////                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
////                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(step_pin_activity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
////                            updateUI(null);
//                        }
//                    }
//                });
//        // [END create_user_with_email]
//    }
//
//    private void signIn(String email, String password) {
//        // [START sign_in_with_email]
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
////                            Log.d(TAG, "signInWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            Toast.makeText(step_pin_activity.this, "Authentication Success.",
//                                    Toast.LENGTH_SHORT).show();
////                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
////                            Log.w(TAG, "signInWithEmail:failure", task.getException());
//                            Toast.makeText(step_pin_activity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
////                            updateUI(null);
//                        }
//                    }
//                });
//        // [END sign_in_with_email]
//    }
}