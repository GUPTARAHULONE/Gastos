package com.example.gastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

   private ImageView button_login;
   FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();
        button_login=findViewById(R.id.btn);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAuth.getCurrentUser() != null)
                {
                    Toast.makeText(MainActivity.this, "Hello , user =  " + mAuth.getCurrentUser().getPhoneNumber() , Toast.LENGTH_SHORT).show();
                    Intent homeIntent=new Intent(MainActivity.this,EnterPinActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
                else
                {
                    Intent intent=new Intent(MainActivity.this,login_phone_activity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });


    }
}