package com.example.gastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;

import java.util.concurrent.TimeUnit;

public class login_phone_activity extends AppCompatActivity {

    private Button otp_button;
     private EditText phone_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone_activity);

        otp_button=findViewById(R.id.otp_btn);
        phone_num=findViewById(R.id.number);
        otp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num=phone_num.getText().toString().trim();
                if(!num.isEmpty()) {
                    if (num.length() == 10) {
                        Intent intent = new Intent(login_phone_activity.this, getotp_activity.class);
                        intent.putExtra("phone_number", num);
                        startActivity(intent);


                    } else {
                        Toast.makeText(login_phone_activity.this, "Please enter correct phone number", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(login_phone_activity.this, "Enter phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}