package com.example.gastos.elite_fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gastos.Account_verified_activity;
import com.example.gastos.Model_offer;
import com.example.gastos.Model_order;
import com.example.gastos.R;
import com.example.gastos.orderAdapter;
import com.example.gastos.updateRecyclerviewOffer;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;


import java.util.ArrayList;
import java.util.List;

public class horizontal_item_adapter extends RecyclerView.Adapter<horizontal_item_adapter.ViewHolder> implements View.OnClickListener {
    List<elite_Horizontal_item_view> orderList;
    int row_index=0;
    ElitemarketFragment elitemarketFragment;
    FirebaseStorage storage ;
    StorageReference storageRef ;
    FirebaseAuth mAuth;
    Context context;
    UpdateEliteRecyclerView updateEliteRecyclerView ;
    boolean check = true;
    Activity activity;

    public horizontal_item_adapter()
    {

    }

    public horizontal_item_adapter(List<elite_Horizontal_item_view> orderList , Activity activity,
                                   UpdateEliteRecyclerView updateEliteRecyclerView) {
        this.orderList = orderList;
        this.activity = activity;
        this.updateEliteRecyclerView = updateEliteRecyclerView;
    }

    @NonNull
    @Override
    public horizontal_item_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull horizontal_item_adapter.ViewHolder holder, int position) {

        if(check)
        {
            ArrayList<eliteItemView> mData = new ArrayList<>();
            filterDataFeed(mData);
        }

        holder.elite_filter_text_view.setText(orderList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();

                ArrayList<eliteItemView> mData = new ArrayList<>();

               updateEliteRecyclerView.callback(position,filterDataFeed(mData));


            }
        });
        if(row_index == position) {
        holder.row_linearlayout.setBackgroundColor(Color.parseColor("#F7B401"));
        holder.elite_filter_text_view.setTextColor(Color.parseColor("#FBF4E4"));
        }
        else
        {
            holder.row_linearlayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.elite_filter_text_view.setTextColor(Color.parseColor("#004445"));
        }


        elitemarketFragment = new ElitemarketFragment();
        mAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        storageRef= storage.getReference().child("eliteShops").child( orderList.get(position).getName().toLowerCase());

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView elite_filter_text_view;
        LinearLayout row_linearlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            elite_filter_text_view = itemView.findViewById(R.id.order_items);
            row_linearlayout=(LinearLayout)itemView.findViewById(R.id.linear_layout_offer);


        }

        @Override
        public void onClick(View view) {

        }
    }

    public ArrayList<eliteItemView> filterDataFeed(ArrayList<eliteItemView> list )
    {

        if(orderList.get(row_index).getName().equals("All") )
        {
            filterAll(list);
        }
        else
        if(orderList.get(row_index).getName().equals("Clubs") )
        {
            filterClubs(list);
        }
        else
        if(orderList.get(row_index).getName().equals("Pubs") )
        {
            filterPubs(list);
        }
        else
        if(orderList.get(row_index).getName().equals("Lounges"))
        {
            filterLounges(list);
        }
        else
        if(orderList.get(row_index).getName().equals("Restaurants") )
        {
            filterRestaurant(list);
        }

        return list;

    }

    public void filterAll(ArrayList<eliteItemView> list)
    {
        filterClubs(list);
        filterLounges(list);
        filterPubs(list);
        filterRestaurant(list);


    }
    public void filterClubs(ArrayList<eliteItemView> list)
    {
        list.add(new eliteItemView("https://firebasestorage.googleapis.com/v0/b/gastos-app-" +
                "2f1f7.appspot.com/o/eliteShops%2Fclubs%2Fclub1.jpg?alt=media&token=a5b15694-" +
                "d44f-46c1-8289-b0f7bc3f88d9", "Club1"));
        list.add(new eliteItemView("https://firebasestorage.googleapis.com/v0/b/gastos-app-" +
                "2f1f7.appspot.com/o/eliteShops%2Fclubs%2Fclub2.jpg?alt=media&token=770e83e0-fa0b-" +
                "4022-ad97-53657db5d1b7", "Club2"));
        list.add(new eliteItemView("https://firebasestorage.googleapis.com/v0/b/gastos-app-" +
                "2f1f7.appspot.com/o/eliteShops%2Fclubs%2Fclub3.jpg?alt=media&token" +
                "=520024e1-9740-4d93-9b6c-8a26d62b8e05", "Club3"));
    }
    public void filterRestaurant(ArrayList<eliteItemView> list)
    {

        list.add(new eliteItemView("https://firebasestorage.googleapis.com/v0/b/gastos-" +
                "app-2f1f7.appspot.com/o/eliteShops%2Frestaurants%2Frestro1.jpg?alt=media&token=77cec1e7-23c5" +
                "-43f2-be68-700c3e770cd7", "Restaurant1"));
        list.add(new eliteItemView("https://firebasestorage.googleapis.com/v0/b/gastos-app" +
                "-2f1f7.appspot.com/o/eliteShops%2Frestaurants%2Frestro2.jpg?alt=media&token=db228437-305d-421e" +
                "-9b15-f7a0d5b7b62e", "Restaurant2"));
        list.add(new eliteItemView("https://firebasestorage.googleapis.com/v0/b/gastos-" +
                "app-2f1f7.appspot.com/o/eliteShops%2Frestaurants%2Fstreet-food-3855545_1280.jpg?alt=media&token=" +
                "a48f3ddc-1cb2-43f6-8191-716522810bfe", "Restaurant3"));
    }
    public void filterLounges(ArrayList<eliteItemView> list)
    {
        list.add(new eliteItemView("https://firebasestorage.googleapis.com/v0/b/gastos-app-2f1f7.appspot.com" +
                "/o/eliteShops%2Flounges%2Flounge1.jpg?alt=media&token=d39a96a0-3989-4b9b-b855-9b677f254f32", "Lounges1"));
        list.add(new eliteItemView("https://firebasestorage.googleapis.com/v0/b/gastos-app-2f1f7.appspot.com/o/" +
                "eliteShops%2Flounges%2Flounge2.jpg?alt=media&token=3a22a7e3-f9b5-4d9f-9ae9-38317edac4e4", "Lounges2"));
    }
    public void filterPubs(ArrayList<eliteItemView> list)
    {

        list.add(new eliteItemView("https://firebasestorage.googleapis.com/v0/b/gastos-app-2f1f7.appspot.com/o/" +
                "eliteShops%2Fpubs%2Fpub1.jpg?alt=media&token=657519cc-770c-4a5f-b665-88fb8c86d959", "Pubs1"));
        list.add(new eliteItemView("https://firebasestorage.googleapis.com/v0/b/gastos-app-2f1f7.appspot.com/o/" +
                "eliteShops%2Fpubs%2Fpub2.jpg?alt=media&token=24d493f7-779f-49e4-b91f-8502a1071d0d", "Pubs2"));
    }


}
// if (orderList.get(position).getName() != "All") {
//
//         } else {
//         storageRef.listAll()
//         .addOnSuccessListener(new OnSuccessListener<ListResult>() {
//@Override
//public void onSuccess(ListResult listResult) {
//
//        for (StorageReference item : listResult.getItems()) {
//        // All the items under listRef.
//        item.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//@Override
//public void onSuccess(Uri uri) {
//        elitemarketFragment.mData.add(new eliteItemView(uri.toString(), ""));
//        }
//        }).addOnFailureListener(new OnFailureListener() {
//@Override
//public void onFailure(@NonNull Exception e) {
//
//        }
//        });
//
//
////                                Log.i("TAG",item.getDownloadUrl().toString() +"");
//        }
//        }
//        })
//        .addOnFailureListener(new OnFailureListener() {
//@Override
//public void onFailure(@NonNull Exception e) {
////                            Toast.makeText(, "Welcome to GASTOS", Toast.LENGTH_SHORT).show();
//
//        }
//        });
//
//        }