package com.example.gastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Account_verified_activity extends AppCompatActivity {

    private ImageView verifiedbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_account_verified_activity);

        verifiedbtn=findViewById(R.id.btnverified);

        verifiedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account_verified_activity.this, Mainscreen.class);
                startActivity(intent);
                Toast.makeText(Account_verified_activity.this, "Welcome to GASTOS", Toast.LENGTH_SHORT).show();
            }
        });
    }
}