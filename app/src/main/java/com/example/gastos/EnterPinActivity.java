package com.example.gastos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EnterPinActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String user_id;
    FirebaseFirestore db;
    private Map<String,Object> map = new HashMap<>();
    private String originalPin;
    Button btnOk;
    EditText dig1,dig2,dig3,dig4,dig5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_pin);

        mAuth = FirebaseAuth.getInstance();
        user_id = mAuth.getCurrentUser().getUid();
        db= FirebaseFirestore.getInstance();

        dig1 = findViewById(R.id.digit1);
        dig2 = findViewById(R.id.digit2);
        dig3 = findViewById(R.id.digit3);
        dig4 = findViewById(R.id.digit4);
        dig5 = findViewById(R.id.digit5);

        btnOk = findViewById(R.id.btnOK);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredPin = dig1.getText().toString() + dig2.getText().toString() + dig3.getText().toString() +
                        dig4.getText().toString() + dig5.getText().toString();
                if(enteredPin.length() == 5)
                {
                    if(enteredPin == getOriginalPin())
                    {
                        //Intent
                        Intent intent = new Intent(EnterPinActivity.this,Account_verified_activity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(EnterPinActivity.this, "Entered Pin is Incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(EnterPinActivity.this, "Pin Must be of 5 digit", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    private String getOriginalPin()
    {
        DocumentReference docRef = db.collection("users_pin").document(user_id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
//                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        map = document.getData();
                        originalPin = map.get("setpin=").toString();


                    } else {
//                        Log.d(TAG, "No such document");
                    }
                } else {
//                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        return originalPin;
    }
}