package com.example.gastos.home_fragment;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gastos.R;

import org.w3c.dom.Text;


public class HomeScreenFragment extends Fragment {


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView txtMostPaid;
    private TextView txtRecentPaid;
    private RelativeLayout homeScreenCard;

    public HomeScreenFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HomeScreenFragment newInstance(String param1, String param2) {
        HomeScreenFragment fragment = new HomeScreenFragment();

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
        View view =  inflater.inflate(R.layout.fragment_home_screen, container, false);
        txtMostPaid = view.findViewById(R.id.txtMostPaid);
        txtRecentPaid = view.findViewById(R.id.txtRecentPaid);
        homeScreenCard = view.findViewById(R.id.card_2);

        txtMostPaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMostPaid.setPaintFlags(txtMostPaid.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                txtRecentPaid.setPaintFlags(txtRecentPaid.getPaintFlags() & (~ Paint.UNDERLINE_TEXT_FLAG));
            }
        });

        txtRecentPaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtRecentPaid.setPaintFlags(txtRecentPaid.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                txtMostPaid.setPaintFlags(txtMostPaid.getPaintFlags() & (~ Paint.UNDERLINE_TEXT_FLAG));
            }
        });

        homeScreenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userProfileIntent = new Intent(getContext(),UserProfilScreen.class);
                startActivity(userProfileIntent);
            }
        });

        return view;
    }
}