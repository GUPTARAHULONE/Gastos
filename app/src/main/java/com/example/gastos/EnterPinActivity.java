package com.example.gastos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
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

        setpinEditText();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredPin = dig1.getText().toString() + dig2.getText().toString() + dig3.getText().toString() +
                        dig4.getText().toString() + dig5.getText().toString();
                if(enteredPin.length() == 5)
                {
                    if(enteredPin.equals(getOriginalPin()) )
                    {
                        //Intent
                        Intent intent = new Intent(EnterPinActivity.this,Mainscreen.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(EnterPinActivity.this, "Entered Pin is Incorrect " , Toast.LENGTH_SHORT).show();
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
        SharedPreferences sharedPref =  getSharedPreferences("preference", Context.MODE_PRIVATE);
        originalPin = sharedPref.getString("myPin","");
        return originalPin;
    }

    private void setpinEditText()
    {
        dig1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty())
                {
                    dig2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        dig2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty())
                {
                    dig3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        dig3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty())
                {
                   dig4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        dig4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty())
                {
                    dig5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}