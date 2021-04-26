package com.example.gastos.home_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.gastos.Account_verified_activity;
import com.example.gastos.R;

public class UserProfilScreen extends AppCompatActivity {
    SwitchCompat toggleAccountActivation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profil_screen);

        toggleAccountActivation = findViewById(R.id.toggle_account_activation);

        toggleAccountActivation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked())
                {
                    Intent accountActivationIntent = new Intent(UserProfilScreen.this,AccountActivationActivity.class);
                    startActivity(accountActivationIntent);
                }
                else
                {
                    Toast.makeText(UserProfilScreen.this, "UNCHECKED", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}