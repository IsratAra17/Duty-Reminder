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

public class EsharAdapter extends RecyclerView.Adapter<EsharAdapter.ViewHolder> {
    Context context;
    ArrayList<ModelClassPrayer> EshaHadisList;
    public EsharAdapter(Context context, ArrayList<ModelClassPrayer> EshaHadisList) {
        this.context = context;
        this.EshaHadisList = EshaHadisList;
    }


    @NonNull
    @Override
    public EsharAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daydesignlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EsharAdapter.ViewHolder holder, int position) {
        holder.t1.setText("" + EshaHadisList.get(position).getEtittle());
        holder.t2.setText("" + EshaHadisList.get(position).getEbody());
    }

    @Override
    public int getItemCount() {
        return EshaHadisList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView t1, t2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            t1 = itemView.findViewById(R.id.tvfojorHadisTittle);
            t2 = itemView.findViewById(R.id.tvfojorHadisBody);
        }
    }
}
