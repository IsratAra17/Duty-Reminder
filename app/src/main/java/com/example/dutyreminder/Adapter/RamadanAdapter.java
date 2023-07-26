package com.example.dutyreminder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dutyreminder.Model.ModelClassPrayer;
import com.example.dutyreminder.R;

import java.util.ArrayList;

public class RamadanAdapter extends RecyclerView.Adapter<RamadanAdapter.MyViewHolder> {


    Context context;
    ArrayList<ModelClassPrayer> modelRamadanArrayList;

    public RamadanAdapter(Context context, ArrayList<ModelClassPrayer> modelRamadanArrayList) {
        this.context = context;
        this.modelRamadanArrayList = modelRamadanArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ramadantimedesign, parent, false);
        return new RamadanAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.r1.setText("" + modelRamadanArrayList.get(position).getRid());
        holder.r2.setText("" + modelRamadanArrayList.get(position).getDate());
        holder.r3.setText("" + modelRamadanArrayList.get(position).getIftar());
        holder.r4.setText("" + modelRamadanArrayList.get(position).getSehri());
    }

    @Override
    public int getItemCount() {
        return modelRamadanArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView r1, r2, r3, r4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            r1 = itemView.findViewById(R.id.text_ramadan_day);//database er id
            r2 = itemView.findViewById(R.id.text_ramadan_date);
            r3 = itemView.findViewById(R.id.text_time_iftar);
            r4 = itemView.findViewById(R.id.text_time_sehri);
        }
    }
}
