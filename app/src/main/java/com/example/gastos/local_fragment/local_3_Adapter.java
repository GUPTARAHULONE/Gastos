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

public class local_3_Adapter extends RecyclerView.Adapter<local_3_Adapter.ViewHolder> {

    ArrayList<Model_local3> model_local3_list;
    private OnItemClickListner mListner;

    public interface OnItemClickListner{
        void OnItemClick(int position);
    }

    public void setOnItemClickListner(OnItemClickListner mListner){
        this.mListner=mListner;
    }

    public local_3_Adapter(ArrayList<Model_local3> model_local3_list) {
        this.model_local3_list = model_local3_list;
    }

    @NonNull
    @Override
    public local_3_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view3= LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_items, parent, false);
        ViewHolder viewHolder3=new ViewHolder(view3,mListner);
        return viewHolder3;
    }

    @Override
    public void onBindViewHolder(@NonNull local_3_Adapter.ViewHolder holder, int position) {

        Model_local3 currentItem=model_local3_list.get(position);
        holder.offeritem.setImageResource(currentItem.getImg1());
    }

    @Override
    public int getItemCount() {
        return model_local3_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView offeritem;
        LinearLayout linearlayout2;
        public ViewHolder(@NonNull View itemView, final OnItemClickListner mListner) {
            super(itemView);

            offeritem=itemView.findViewById(R.id.offer_items);
            linearlayout2=itemView.findViewById(R.id.layout_offers);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListner !=null){
                        int position=getPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            mListner.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
