package com.example.dutyreminder.ui.Fajar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dutyreminder.R;

import com.example.dutyreminder.databinding.FragmentDayBinding;
import com.example.dutyreminder.ui.Asor.AsorFragment;
import com.example.dutyreminder.ui.Esha.EshaFragment;
import com.example.dutyreminder.ui.Magriv.MagrivFragment;
import com.example.dutyreminder.ui.zuhor.ZuhorFragment;


public class DayFragment extends Fragment {

    private FragmentDayBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDayBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.btnFojor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FajarFragment fajarFragment = new FajarFragment();

               FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.framelayout_day,fajarFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        binding.btnjohor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ZuhorFragment zuhorFragment = new ZuhorFragment();

                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.framelayout_day,zuhorFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        binding.btnAsor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsorFragment asorFragment = new AsorFragment();

                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.framelayout_day,asorFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        binding.btnMagriv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MagrivFragment magrivFragment=new MagrivFragment();

                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.framelayout_day,magrivFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        binding.btnEsha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               EshaFragment eshaFragment = new EshaFragment();

                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.framelayout_day,eshaFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


return  root;
    }
}