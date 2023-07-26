package com.example.dutyreminder.ui.Month;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dutyreminder.R;
import com.example.dutyreminder.databinding.FragmentMonthBinding;

public class MonthFragment extends Fragment {
    private FragmentMonthBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMonthBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        binding.btArabicMonth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ArabicMonth1Fragment arabicMonth1Fragment=new ArabicMonth1Fragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.month_frame,arabicMonth1Fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        binding.btArabicMonth2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArabicMonth2Fragment a2=new ArabicMonth2Fragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.month_frame,a2);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        binding.btArabicMonth3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                month3Fragment a3=new month3Fragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.month_frame,a3);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        binding.btArabicMonth4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m7Fragment m7Fragment=new m7Fragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.month_frame,m7Fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        binding.btArabicMonth8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m8Fragment m8Fragment=new m8Fragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.month_frame,m8Fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        binding.btArabicMonth9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m9Fragment m9Fragment=new m9Fragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.month_frame,m9Fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        binding.btArabicMonth10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m10Fragment m10Fragment=new m10Fragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.month_frame,m10Fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        binding.btArabicMonth11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m11Fragment m11=new m11Fragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.month_frame,m11);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        binding.btArabicMonth12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m12Fragment m12Fragment=new m12Fragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.month_frame,m12Fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return  root;
    }

}
