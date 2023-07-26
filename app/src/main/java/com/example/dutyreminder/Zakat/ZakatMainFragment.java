package com.example.dutyreminder.Zakat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dutyreminder.R;
import com.example.dutyreminder.databinding.FragmentZakatMainBinding;

public class ZakatMainFragment extends Fragment {

    private FragmentZakatMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentZakatMainBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        binding.btnjHadis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zakathadisFragment z=new zakathadisFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.month_frame,z);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        binding.btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 ZakatFragment zakatcalculator=new ZakatFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.month_frame,zakatcalculator);
                ft.addToBackStack(null);
                ft.commit();
            }
        });






        return  root;
    }
}