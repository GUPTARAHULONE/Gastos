package com.example.gastos.local_fragment;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gastos.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class local_1_Adapter extends RecyclerView.Adapter<local_1_Adapter.ViewHolder> {

    RecyclerView r3;
    List<Model_local1> model_local1_List;
   private int r1=0;
    private boolean c1=true;
    com.example.gastos.local_fragment.updateRecyclerviewLocal updateRecyclerviewLocal;
    Activity activity;
    com.example.gastos.local_fragment.local_3_Adapter l3;
    public local_1_Adapter(List<Model_local1> model_local1_List, updateRecyclerviewLocal updateRecyclerviewLocal, Activity activity) {
        this.model_local1_List = model_local1_List;
        this.updateRecyclerviewLocal = updateRecyclerviewLocal;
        this.activity = activity;
    }

    @NonNull
    @Override


    public local_1_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.local_items_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull local_1_Adapter.ViewHolder holder, int position) {

        if (c1)
        {
            ArrayList<Model_local3> local3list=new ArrayList<>();

            final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("Local_market").child("All");
            nm.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()){
                        for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                           // local3list l=npsnapshot.getValue(local_3_Adapter.class);
                          //  local3list.add(l);
                            local3list.add( dataSnapshot.getValue(Model_local3.class));
                        }
                        l3=new local_3_Adapter(local3list);
                       // r3.setAdapter(l3);

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

          //  local3list.add(new Model_local3(R.drawable.credit_card_24px,0));
           // local3list.add(new Model_local3(R.drawable.credit_card_24px,0));
           // local3list.add(new Model_local3(R.drawable.credit_card_24px,0));
          //  local3list.add(new Model_local3(R.drawable.credit_card_24px,0));
          //  local3list.add(new Model_local3(R.drawable.credit_card_24px,0));
           // local3list.add(new Model_local3(R.drawable.credit_card_24px,0));

            updateRecyclerviewLocal.callbacklocal(position,l3);
            c1=false;
        }


        holder.local1.setText(model_local1_List.get(position).getN1());

        if(r1 == position)
            holder.row_linearlayout_local1.setBackgroundColor(Color.parseColor("#F7B401"));



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1 = position;
                notifyDataSetChanged();

                if (position==0)
                {
                    ArrayList<Model_local3> local3list=new ArrayList<>();
                    final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("Local_market").child("All");
                    nm.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){
                                for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){

                                    local3list.add( dataSnapshot.getValue(Model_local3.class));
                                }
                                l3=new local_3_Adapter(local3list);
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    updateRecyclerviewLocal.callbacklocal(position,l3);

                }
                else if(position==1)
                {
                    ArrayList<Model_local3> local3list=new ArrayList<>();
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.credit_card_24px,0));
//                    local3list.add(new Model_local3(R.drawable.credit_card_24px,0));
//                    local3list.add(new Model_local3(R.drawable.credit_card_24px,0));
//                    local3list.add(new Model_local3(R.drawable.credit_card_24px,0));

                    final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("Local_market").child("Food");
                    nm.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){
                                for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                                    // local3list l=npsnapshot.getValue(local_3_Adapter.class);
                                    //  local3list.add(l);
                                    local3list.add( dataSnapshot.getValue(Model_local3.class));
                                }
                                l3=new local_3_Adapter(local3list);
                               // r3.setAdapter(l3);

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    updateRecyclerviewLocal.callbacklocal(position,l3);

                }

                else if(position==2)
                {
                    ArrayList<Model_local3> local3list=new ArrayList<>();
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.credit_card_24px,0));
//                    local3list.add(new Model_local3(R.drawable.credit_card_24px,0));

                    final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("Local_market").child("Drink");
                    nm.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){
                                for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                                    // local3list l=npsnapshot.getValue(local_3_Adapter.class);
                                    //  local3list.add(l);
                                    local3list.add( dataSnapshot.getValue(Model_local3.class));
                                }
                                l3=new local_3_Adapter(local3list);
                               // r3.setAdapter(l3);

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    updateRecyclerviewLocal.callbacklocal(position,l3);
                }
                else if(position==3)
                {
                    ArrayList<Model_local3> local3list=new ArrayList<>();
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));

                    final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("Local_market").child("Salon");
                    nm.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){
                                for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                                    // local3list l=npsnapshot.getValue(local_3_Adapter.class);
                                    //  local3list.add(l);
                                    local3list.add( dataSnapshot.getValue(Model_local3.class));
                                }
                                l3=new local_3_Adapter(local3list);
                              //  r3.setAdapter(l3);

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    updateRecyclerviewLocal.callbacklocal(position,l3);

                }

                else if(position==4)
                {
                    ArrayList<Model_local3> local3list=new ArrayList<>();
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));
//                    local3list.add(new Model_local3(R.drawable.home_fill,0));

                    final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("Local_market").child("Clothes");
                    nm.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){
                                for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                                    // local3list l=npsnapshot.getValue(local_3_Adapter.class);
                                    //  local3list.add(l);
                                    local3list.add( dataSnapshot.getValue(Model_local3.class));
                                }
                                l3=new local_3_Adapter(local3list);
                              //  r3.setAdapter(l3);

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    updateRecyclerviewLocal.callbacklocal(position,l3);

                }

            }
        });
       // if(r1 == position)
          //  holder.row_linearlayout_local1.setBackgroundColor(Color.parseColor("#F7B401"));

       // else
          //  holder.row_linearlayout_local1.setBackgroundColor(Color.parseColor("#004445"));

        if(r1 == position) {
            holder.row_linearlayout_local1.setBackgroundColor(Color.parseColor("#F7B401"));
            holder.local1.setTextColor(Color.parseColor("#FBF4E4"));
        }
        else
        {
            holder.row_linearlayout_local1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.local1.setTextColor(Color.parseColor("#004445"));
        }

    }

    @Override
    public int getItemCount() {
        return model_local1_List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView local1;
        LinearLayout row_linearlayout_local1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            local1=itemView.findViewById(R.id.order_items);
            row_linearlayout_local1=(LinearLayout)itemView.findViewById(R.id.linear_layout_offer);
        }
    }
}
