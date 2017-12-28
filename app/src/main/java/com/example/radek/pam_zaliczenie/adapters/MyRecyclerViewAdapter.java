package com.example.radek.pam_zaliczenie.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.radek.pam_zaliczenie.R;
import com.example.radek.pam_zaliczenie.entity.City;
import com.example.radek.pam_zaliczenie.entity.CityAndHeaderList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<CityAndHeaderList> mData = Collections.emptyList();
    private final LayoutInflater mInflater;
    private final ItemClickListener mClickListener;

    // data is passed into the constructor
    public MyRecyclerViewAdapter(@NonNull Context context, @NonNull ArrayList<CityAndHeaderList> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mClickListener = (ItemClickListener) context;
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getListItemType();
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case CityAndHeaderList.VIEW_TYPE_CITY:
                 view = mInflater.inflate(R.layout.recyclerview_row, parent, false);

                break;
            case CityAndHeaderList.VIEW_TYPE_HEADER:
                 view = mInflater.inflate(R.layout.recyclerview_row_header, parent, false);
                break;
        }

        return new ViewHolder(view);
    }

    // binds the data to the textview in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(mData.get(position)instanceof City){
        City animal = (City)mData.get(position);
        holder.myTextView.setText(animal.GetDate());}
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvCityName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(myTextView.getText().toString());
        }
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(String cityName);
    }
}
