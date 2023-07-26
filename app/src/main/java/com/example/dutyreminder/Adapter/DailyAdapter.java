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

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.ViewHolder> {
    Context context;
    ArrayList<ModelClassPrayer> fajarHadisList;
    public DailyAdapter(Context context, ArrayList<ModelClassPrayer> fajarHadisList) {
        this.context = context;
        this.fajarHadisList = fajarHadisList;
    }


    @NonNull
    @Override
    public DailyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daydesignlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyAdapter.ViewHolder holder, int position) {
        holder.t1.setText("" + fajarHadisList.get(position).getFtitle());
        holder.t2.setText("" + fajarHadisList.get(position).getFbody());
       // holder.t3.setText("" + fajarHadisList.get(position).getFtitle());
        //holder.t4.setText("" + fajarHadisList.get(position).getFbody());

    }

    @Override
    public int getItemCount() {
        return fajarHadisList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView t1, t2,t3,t4;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            t1 = itemView.findViewById(R.id.tvfojorHadisTittle);
            t2 = itemView.findViewById(R.id.tvfojorHadisBody);
           // t3 = itemView.findViewById(R.id.tvfojorHadisTittle);
            //t4 = itemView.findViewById(R.id.tvfojorHadisBody);
        }
    }
}
