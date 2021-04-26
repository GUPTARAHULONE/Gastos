package com.example.gastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class Refer_Earn_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer__earn_);
        String[] type = new String[] {"Bed-sitter dwd wqwq wqdwqdwq qwdddddddddddddd qw3333 qqqqqqqqqqqqqqd           qqqqqqqqqqqqqq eeeeeeee 11111111"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        R.layout.dropdown_item,
                        type);

        AutoCompleteTextView editTextFilledExposedDropdown =
                findViewById(R.id.t1);
        editTextFilledExposedDropdown.setAdapter(adapter);
    }
}