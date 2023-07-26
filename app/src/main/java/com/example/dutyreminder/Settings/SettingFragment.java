package com.example.dutyreminder.Settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.dutyreminder.NavidrawerActivity;
import com.example.dutyreminder.Spalsh.LocationActivity;
import com.example.dutyreminder.databinding.FragmentSettingBinding;

public class SettingFragment extends Fragment {
    private FragmentSettingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSettingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btSettingYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplication(), LocationActivity.class);
                startActivity(i);
            }
        });
        binding.btSettingNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "no", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getActivity().getApplication(), NavidrawerActivity.class);
                startActivity(i);
            }
        });

        return root;
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_setting, container, false);
    }


}