package com.example.gastos.local_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gastos.R;

import java.util.ArrayList;

public class local_2_Adapter extends RecyclerView.Adapter<local_2_Adapter.ViewHolder> {

    ArrayList<Model_local2> model_local2_list;

    public local_2_Adapter(ArrayList<Model_local2> model_local2_list) {
        this.model_local2_list = model_local2_list;
    }

    @NonNull
    @Override


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_items_local, parent, false);
        return new local_2_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.local2.setImageResource(model_local2_list.get(position).getImg2());

    }

    @Override
    public int getItemCount() {
        return model_local2_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView local2;
        LinearLayout row_linearlayout_local2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            local2=itemView.findViewById(R.id.local_img_items);
            row_linearlayout_local2=(LinearLayout)itemView.findViewById(R.id.linear_layout_local_img_items);

        }
    }
}
