package com.example.gastos.local_fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gastos.R;
import com.example.gastos.deals_fragment.DealsProfileActivity;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class LocalMarketFragment extends Fragment implements updateRecyclerviewLocal {

  RecyclerView r1,r2,r3;
  List<Model_local1> local1List;
  ArrayList<Model_local2> local2list=new ArrayList<>();
  ArrayList<Model_local3> local3list=new ArrayList<>();
  int posi;
    com.example.gastos.local_fragment.local_2_Adapter local_2_Adapter;
    com.example.gastos.local_fragment.local_3_Adapter local_3_Adapter;
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
        View view= inflater.inflate(R.layout.fragment_local_market, container, false);

        r1 =view.findViewById(R.id.local_r1);
        r1.setHasFixedSize(true);
        r1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        r1.setAdapter(new local_1_Adapter(indata(),this,getActivity()));


        r2 =view.findViewById(R.id.local_r2);
        r2.setHasFixedSize(true);
        r2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        r2.setAdapter(new local_2_Adapter(data()));

        r3 =view.findViewById(R.id.local_r3);
        local_3_Adapter=new local_3_Adapter(local3list);
        r3.setLayoutManager(new GridLayoutManager(getContext(), 2));
        r3.setAdapter(local_3_Adapter);

       // GridLayoutManager manager = new GridLayoutManager(getContext(),2);
       // r3.setLayoutManager(manager);
       // r3.setHasFixedSize(true);
        //local_3_Adapter = new local_3_Adapter(local3list);
     //   r3.setAdapter(local_3_Adapter);

       /* FirebaseRecyclerOptions<Model_local3> options =
                new FirebaseRecyclerOptions.Builder<Model_local3>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Local_market"), Model_local3.class)
                        .build();

        local_3_Adapter=new local_3_Adapter(options);
        r3.setAdapter(local_3_Adapter);

        */
        return view;
    }
  /*  @Override
    public void onStart() {
        super.onStart();
        local_3_Adapter.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        local_3_Adapter.stopListening();
    }

   */
    private List<Model_local1> indata() {
        local1List=new ArrayList<Model_local1>();
        local1List.add(new Model_local1("All"));
        local1List.add(new Model_local1("Food"));
        local1List.add(new Model_local1("Drink"));
        local1List.add(new Model_local1("Salon"));
        local1List.add(new Model_local1("Clothes"));

        return local1List;
    }

    private ArrayList<Model_local2> data(){
        local2list=new ArrayList<Model_local2>();
        local2list.add(new Model_local2(R.drawable.home_fill));
        local2list.add(new Model_local2(R.drawable.home_fill));
        local2list.add(new Model_local2(R.drawable.home_fill));
        local2list.add(new Model_local2(R.drawable.home_fill));
        local2list.add(new Model_local2(R.drawable.home_fill));

        return local2list;
    }

    public void callbacklocal(int position, local_3_Adapter local_3_adapter) {

        local_3_Adapter=new local_3_Adapter(local3list);
        local_3_Adapter.notifyDataSetChanged();
        r3.setAdapter(local_3_Adapter);

       local_3_Adapter.setOnItemClickListner(new local_3_Adapter.OnItemClickListner() {
           @Override
           public void OnItemClick(int position) {
               //posi=local3list.get(position).getPosii();

               Intent intent=new Intent(getActivity(), DealsProfileActivity.class);
               //intent.putExtra("pos",posi);
               startActivity(intent);
           }
       });
    }




}