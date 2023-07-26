package com.example.dutyreminder.ui.Week;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dutyreminder.R;
import com.example.dutyreminder.databinding.FragmentWeekBinding;
import com.example.dutyreminder.ui.Fajar.FajarFragment;

public class WeekFragment extends Fragment {

    //private WeekViewModel WeekViewModel;
    private FragmentWeekBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentWeekBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.ibtSiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent i=new Intent(getActivity().getApplication(), WeekmainActivity.class);
                //startActivity(i);
            }
        });
        binding.ibtWeekExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 //Intent i=new Intent(getActivity().getApplicationContext(), WeekFragment2.class);
                //startActivity(i);


                WeekFragment2 weekFragment2 = new WeekFragment2();

                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.weekfragm,weekFragment2);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
      /*  WeekViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
}