package com.example.gastos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class ElitemarketFragment extends Fragment {



    public ElitemarketFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ElitemarketFragment newInstance(String param1, String param2) {
        ElitemarketFragment fragment = new ElitemarketFragment();

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
        View view =  inflater.inflate(R.layout.fragment_elitemarket, container, false);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Elite Activity", Toast.LENGTH_SHORT).show();
            }
        });
        return  view;
    }
}