package com.example.gastos.elite_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gastos.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyEliteRvAdapter extends RecyclerView.Adapter<MyEliteRvAdapter.ViewHolder> {

    public ArrayList<eliteItemView> mData  ;
    private LayoutInflater mInflater;

    public MyEliteRvAdapter()
    {

    }

    // Data is passed into the constructor
    public MyEliteRvAdapter( Context context,ArrayList<eliteItemView> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    // Inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.elite_fragment_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Binds the data to the textviews  and images in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String restaurantImageUrl  = mData.get(position).getRestaurantImageUrl();
        String restaurantName = mData.get(position).getRestaurantName();

        Picasso.get().load(restaurantImageUrl).into(holder.Img);
        holder.txtImageName.setText(restaurantName);

    }

    // Total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtImageName;
        public ImageView Img;
        private  Context context;


        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txtImageName = (TextView)itemView.findViewById(R.id.txtRestaurantName);
            Img = (ImageView)itemView.findViewById(R.id.restaurantImg);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }

    }

    //     Convenience method for getting data at click position
    public eliteItemView getItem(int id) {
        return mData.get(id);
    }

    //     Method that executes your code for the action received
    public void onItemClick(View view, int position) {

    }
}

