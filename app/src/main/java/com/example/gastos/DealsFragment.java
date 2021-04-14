package com.example.gastos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class DealsFragment extends Fragment {

    RecyclerView recyclerView;
    List<Model_order> orderlist;
    public DealsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DealsFragment newInstance(String param1, String param2) {
        DealsFragment fragment = new DealsFragment();

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
        View view= inflater.inflate(R.layout.fragment_deals, container, false);

       recyclerView =view.findViewById(R.id.offer);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        //initdata();
        recyclerView.setAdapter(new orderAdapter(initdata()));
               return view;
    }

    private List<Model_order> initdata() {
         orderlist=new ArrayList<Model_order>();
         orderlist.add(new Model_order("All"));
        orderlist.add(new Model_order("Shopping"));
        orderlist.add(new Model_order("Health"));
        orderlist.add(new Model_order("Trending Offers"));
        orderlist.add(new Model_order("Trending Offers"));
        orderlist.add(new Model_order("Trending Offers"));
        orderlist.add(new Model_order("Trending Offers"));
        return orderlist;
    }
}