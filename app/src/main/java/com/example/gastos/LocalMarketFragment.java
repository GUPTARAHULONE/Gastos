package com.example.gastos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LocalMarketFragment extends Fragment {


    public LocalMarketFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static LocalMarketFragment newInstance(String param1, String param2) {
        LocalMarketFragment fragment = new LocalMarketFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_local_market, container, false);
    }
}