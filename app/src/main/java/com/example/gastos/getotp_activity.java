package com.example.gastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class getotp_activity extends AppCompatActivity {

   TextView phone_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getotp_activity);

        phone_num=findViewById(R.id.pho_number);

        String number_value = getIntent().getStringExtra("phone_number");

          phone_num.setText(number_value);
    }
}