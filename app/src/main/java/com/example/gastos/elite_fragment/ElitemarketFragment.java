package com.example.gastos.elite_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gastos.R;

import java.util.ArrayList;


public class ElitemarketFragment extends Fragment {



    MyEliteRvAdapter adapter;
    public ArrayList<eliteItemView> mData = new ArrayList<>();
    private String imageURL = "";
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        container.removeAllViews();
        View view =  inflater.inflate(R.layout.fragment_elitemarket, container, false);
        recyclerView = view.findViewById(R.id.elite_fragment_rv);

//        setting layout manager for recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL , false ));
        dataFeed();

//        Initialise and set adapter
        adapter = new MyEliteRvAdapter(getContext(), mData);
//        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void dataFeed()
    {

        //

    }

}