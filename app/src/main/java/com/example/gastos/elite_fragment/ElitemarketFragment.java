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

import com.example.gastos.R;

import java.util.ArrayList;
import java.util.List;


public class ElitemarketFragment extends Fragment {

    RecyclerView horizontalRecyclerView;
    List<elite_Horizontal_item_view> orderlist;
    MyEliteRvAdapter adapter;
    public ArrayList<eliteItemView> mData = new ArrayList<>();
    private String imageURL = "";
    RecyclerView recyclerView;

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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        container.removeAllViews();
        View view =  inflater.inflate(R.layout.fragment_elitemarket, container, false);
        recyclerView = view.findViewById(R.id.elite_fragment_rv);
        horizontalRecyclerView = view.findViewById(R.id.filterRv);

        horizontalRecyclerView.setHasFixedSize(true);
        horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        //initdata();
        horizontalRecyclerView.setAdapter(new horizontal_item_adapter(initdata()));

//------------------------------------------------------------------------------------------------------------------------------------
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

    private List<elite_Horizontal_item_view> initdata() {
        orderlist=new ArrayList<elite_Horizontal_item_view>();
        orderlist.add(new elite_Horizontal_item_view("All"));
        orderlist.add(new elite_Horizontal_item_view("Restaurants"));
        orderlist.add(new elite_Horizontal_item_view("Lounges"));
        orderlist.add(new elite_Horizontal_item_view("Pubs"));
        orderlist.add(new elite_Horizontal_item_view("Clubs"));

        return orderlist;
    }
}