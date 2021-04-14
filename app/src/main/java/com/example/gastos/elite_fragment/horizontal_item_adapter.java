package com.example.gastos.elite_fragment;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gastos.Model_order;
import com.example.gastos.R;
import com.example.gastos.orderAdapter;


import java.util.List;

public class horizontal_item_adapter extends RecyclerView.Adapter<horizontal_item_adapter.ViewHolder> {
    List<elite_Horizontal_item_view> orderList;
    int row_index=-1;

    public horizontal_item_adapter(List<elite_Horizontal_item_view> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public horizontal_item_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull horizontal_item_adapter.ViewHolder holder, int position) {

        holder.elite_filter_text_view.setText(orderList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();
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
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView elite_filter_text_view;
        LinearLayout row_linearlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            elite_filter_text_view = itemView.findViewById(R.id.order_items);
            row_linearlayout=(LinearLayout)itemView.findViewById(R.id.linear_layout_offer);
        }
    }
}
