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


    private String pin;
    private EditText edt1,edt2,edt3,edt4,edt5;
    private Button btnDone;
    private SharedPreferences sharedPreferences;
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

        setpinEditText();

        btnDone.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pin = edt1.getText().toString() + edt2.getText().toString() + edt3.getText().toString() +
                    edt4.getText().toString() + edt5.getText().toString();
            if(pin.length() == 5 ) {

                setPin(pin);
                Toast.makeText(step_pin_activity.this, "set pin done=" + pin, Toast.LENGTH_SHORT).show();
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
    private void setPin(String pin)
    {
        sharedPreferences =  getSharedPreferences("preference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("myPin", pin);
        editor.apply();
    }

    private void setpinEditText()
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

}