package com.example.gastos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

public class Refer_Earn_Activity extends AppCompatActivity {
    Button popup1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer__earn_);
     /*   String[] type = new String[] {"Bed-sitter dwd wqwq wqdwqdwq qwdddddddddddddd qw3333 qqqqqqqqqqqqqqd           qqqqqqqqqqqqqq eeeeeeee 11111111"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        R.layout.dropdown_item,
                        type);

        AutoCompleteTextView editTextFilledExposedDropdown =
                findViewById(R.id.t1);
        editTextFilledExposedDropdown.setAdapter(adapter);

      */
        popup1 = findViewById(R.id.pop1);
        //  public void showpopup1(View v)
        //   {

        //  }
       /* popup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(this,v);
               popupMenu.setOnMenuItemClickListener(this);
            }
        });

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return false;
        }
    }

        */
    }
}