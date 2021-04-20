package com.example.gastos.deals_fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gastos.R;
import com.example.gastos.deals_fragment.Model_offer;

import java.util.ArrayList;
import java.util.List;

public class offerAdapter extends RecyclerView.Adapter<offerAdapter.ViewHolder>{

    ArrayList<Model_offer> offerList;
    private OnItemClickListner mListner;

    public interface OnItemClickListner{
        void OnItemClick(int position);
    }

    public void setOnItemClickListner(OnItemClickListner mListner){
        this.mListner=mListner;
    }

    public offerAdapter(ArrayList<Model_offer> offerList) {
        this.offerList = offerList;
    }

    @NonNull
    @Override
    public offerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_items, parent, false);
         ViewHolder viewHolder=new ViewHolder(view,mListner);
          return  viewHolder;
        //return new offerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull offerAdapter.ViewHolder holder, int position) {

        Model_offer currentItem=offerList.get(position);
       // holder.offeritem.setImageResource(offerList.get(position).getImage());
        holder.offeritem.setImageResource(currentItem.getImage());

    }

    @Override
    public int getItemCount() {
        return offerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView offeritem;
        LinearLayout linearlayout2;
        public ViewHolder(@NonNull View itemView,final OnItemClickListner mListner) {
            super(itemView);
            offeritem=itemView.findViewById(R.id.offer_items);
            linearlayout2=itemView.findViewById(R.id.layout_offers);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListner!=null){
//                        int position=getAbsoluteAdapterPosition();
//                        if (position!=RecyclerView.NO_POSITION){
//                            mListner.OnItemClick(position);
//                        }
                    };
                }
            });
        }
    }
}
