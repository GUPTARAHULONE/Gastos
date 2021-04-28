package com.example.gastos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Refer_Earn_Activity extends AppCompatActivity implements View.OnClickListener {
    ImageButton drop1,drop2,drop3;
    TextView txtDrop1,txtDrop2,txtDrop3;


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
       drop1 = findViewById(R.id.btn_drop1);
       drop2 = findViewById(R.id.btn_drop2);
       drop3 = findViewById(R.id.btn_drop3);

       drop1.setOnClickListener(this);
       drop2.setOnClickListener(this);
       drop3.setOnClickListener(this);

       txtDrop1 = findViewById(R.id.txtDrop1);
       txtDrop2 = findViewById(R.id.txtDrop2);
       txtDrop3 = findViewById(R.id.txtDrop3);
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

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btn_drop1:
                if(txtDrop1.getVisibility() == View.GONE)
                txtDrop1.setVisibility(View.VISIBLE);
                else
                txtDrop1.setVisibility(View.GONE);
                break;

            case R.id.btn_drop2:
                if(txtDrop2.getVisibility() == View.GONE)
                    txtDrop2.setVisibility(View.VISIBLE);
                else
                    txtDrop2.setVisibility(View.GONE);
                break;

            case R.id.btn_drop3:
                if(txtDrop3.getVisibility() == View.GONE)
                    txtDrop3.setVisibility(View.VISIBLE);
                else
                    txtDrop3.setVisibility(View.GONE);
                break;
        }
    }
}