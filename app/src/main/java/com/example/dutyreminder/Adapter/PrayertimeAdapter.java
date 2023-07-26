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

public class PrayertimeAdapter extends RecyclerView.Adapter<PrayertimeAdapter.MyViewHolder> {

    Context context;
    ArrayList<ModelClassPrayer> prayerlist;

    public PrayertimeAdapter(Context context, ArrayList<ModelClassPrayer> prayerlist) {
        this.context = context;
        this.prayerlist = prayerlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prayertimedesign, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        {

            holder.t1.setText("" + prayerlist.get(position).getFajr());
            holder.t2.setText("" + prayerlist.get(position).getZuhor());
            holder.t3.setText("" + prayerlist.get(position).getAsor());
            holder.t4.setText("" + prayerlist.get(position).getMagriv());
            holder.t5.setText("" + prayerlist.get(position).getEsha());
           // holder.t6.setText("" + prayerlist.get(position).getId());
            //holder.dua.setText("" +prayerlist.get(position).getDua());

        }
    }

        @Override
        public int getItemCount () {
            return prayerlist.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView t1, t2, t3, t4, t5, t6,dua;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                t1 = itemView.findViewById(R.id.text_time_fojor);
                t2 = itemView.findViewById(R.id.text_time_johor);
                t3 = itemView.findViewById(R.id.text_time_Asor);
                t4 = itemView.findViewById(R.id.text_time_Magriv);
                t5 = itemView.findViewById(R.id.text_time_Esha);
                //t6 = itemView.findViewById(R.id.text_time_area);
             //   dua=itemView.findViewById(R.id.duaid);


            }
        }

}
