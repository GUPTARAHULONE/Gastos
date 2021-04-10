package com.example.gastos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Mainscreen extends AppCompatActivity {

    private FrameLayout containerFL;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        containerFL = findViewById(R.id.idFLContainer);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        bottomNavigationView.getMenu().findItem(R.id.deal_item).setChecked(true);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.idFLContainer,
                    new DealsFragment()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.deal_item:
                            selectedFragment = new DealsFragment();
                            break;
                        case R.id.elite_item:
                            selectedFragment = new ElitemarketFragment();
                            break;
                        case R.id.home_item:
                            selectedFragment = new HomeScreenFragment();
                            break;
                        case R.id.local_item:
                            selectedFragment = new LocalMarketFragment();
                            break;
                        case R.id.expense_item:
                            selectedFragment = new ExpensesFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.idFLContainer,
                            selectedFragment).commit();
                    return true;
                }
            };
}