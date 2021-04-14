package com.example.gastos.deals_fragment;

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

import java.util.ArrayList;
import java.util.List;

public class orderAdapter extends RecyclerView.Adapter<orderAdapter.ViewHolder> {

    List<Model_order> orderList;

    int row_index=0;
    com.example.gastos.deals_fragment.updateRecyclerviewOffer updateRecyclerviewOffer;
    Activity activity;
    boolean check=true;
    boolean select=true;

    public orderAdapter( List<Model_order> orderList,Activity activity,updateRecyclerviewOffer updateRecyclerviewOffer) {
        this.orderList=orderList;
        this.activity=activity;
        this.updateRecyclerviewOffer=updateRecyclerviewOffer;
    }

    @NonNull
    @Override
    public orderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull orderAdapter.ViewHolder holder, int position) {

        if (check)
        {
            ArrayList<Model_offer> offerlist=new ArrayList<>();
            offerlist.add(new Model_offer(R.drawable.credit_card_24px,0));
            offerlist.add(new Model_offer(R.drawable.credit_card_24px,0));
            offerlist.add(new Model_offer(R.drawable.credit_card_24px,0));
            offerlist.add(new Model_offer(R.drawable.credit_card_24px,0));
            offerlist.add(new Model_offer(R.drawable.credit_card_24px,0));

            updateRecyclerviewOffer.callback(position,offerlist);
            check=false;
        }


        holder.orderitem.setText(orderList.get(position).getName());

        if(row_index == position)
           holder.row_linearlayout.setBackgroundColor(Color.parseColor("#F7B401"));



      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              row_index = position;
              notifyDataSetChanged();

              if (position==0)
              {
                  ArrayList<Model_offer> offerlist=new ArrayList<>();
                  offerlist.add(new Model_offer(R.drawable.credit_card_24px,0));
                  offerlist.add(new Model_offer(R.drawable.credit_card_24px,0));
                  offerlist.add(new Model_offer(R.drawable.credit_card_24px,0));
                  offerlist.add(new Model_offer(R.drawable.credit_card_24px,0));
                  offerlist.add(new Model_offer(R.drawable.credit_card_24px,0));
                  offerlist.add(new Model_offer(R.drawable.credit_card_24px,0));

                  updateRecyclerviewOffer.callback(position,offerlist);

              }
              else if(position==1)
              {
                  ArrayList<Model_offer> offerlist=new ArrayList<>();
                  offerlist.add(new Model_offer(R.drawable.home_fill,1));
                  offerlist.add(new Model_offer(R.drawable.home_fill,1));
                  offerlist.add(new Model_offer(R.drawable.home_fill,1));
                  offerlist.add(new Model_offer(R.drawable.home_fill,1));
                  offerlist.add(new Model_offer(R.drawable.home_fill,1));
                  offerlist.add(new Model_offer(R.drawable.home_fill,1));

                  updateRecyclerviewOffer.callback(position,offerlist);

              }

              else if(position==2)
              {
                  ArrayList<Model_offer> offerlist=new ArrayList<>();
                  offerlist.add(new Model_offer(R.drawable.credit_card_24px,2));
                  offerlist.add(new Model_offer(R.drawable.credit_card_24px,2));
                  offerlist.add(new Model_offer(R.drawable.credit_card_24px,2));
                  offerlist.add(new Model_offer(R.drawable.credit_card_24px,2));
                  offerlist.add(new Model_offer(R.drawable.credit_card_24px,2));
                  offerlist.add(new Model_offer(R.drawable.credit_card_24px,2));

                  updateRecyclerviewOffer.callback(position,offerlist);
              }
              else if(position==3)
              {
                  ArrayList<Model_offer> offerlist=new ArrayList<>();
                  offerlist.add(new Model_offer(R.drawable.home_fill,3));
                  offerlist.add(new Model_offer(R.drawable.home_fill,3));
                  offerlist.add(new Model_offer(R.drawable.home_fill,3));
                  offerlist.add(new Model_offer(R.drawable.home_fill,3));
                  offerlist.add(new Model_offer(R.drawable.home_fill,3));
                  offerlist.add(new Model_offer(R.drawable.home_fill,3));

                  updateRecyclerviewOffer.callback(position,offerlist);

              }

          }
      });
        if(row_index == position)
           holder.row_linearlayout.setBackgroundColor(Color.parseColor("#F7B401"));

        else
            holder.row_linearlayout.setBackgroundColor(Color.parseColor("#004445"));

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView orderitem;
        LinearLayout row_linearlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderitem=itemView.findViewById(R.id.order_items);
            row_linearlayout=(LinearLayout)itemView.findViewById(R.id.linear_layout_offer);
        }
    }
}
