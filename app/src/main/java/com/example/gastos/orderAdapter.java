package com.example.gastos;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class orderAdapter extends RecyclerView.Adapter<orderAdapter.ViewHolder> {

    List<Model_order> orderList;

    int row_index=-1;
    public orderAdapter( List<Model_order> orderList) {
        this.orderList=orderList;
    }

    @NonNull
    @Override
    public orderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull orderAdapter.ViewHolder holder, int position) {

        holder.orderitem.setText(orderList.get(position).getName());

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              row_index = position;
              notifyDataSetChanged();
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
