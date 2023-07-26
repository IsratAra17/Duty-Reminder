package com.example.dutyreminder.jikir;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dutyreminder.R;
import com.example.dutyreminder.databinding.FragmentHomeBinding;
import com.example.dutyreminder.databinding.FragmentJikirBinding;


public class JikirFragment extends Fragment {

private FragmentJikirBinding binding;
Integer num=0;
    String var;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentJikirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


binding.buttonJikirStart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
num+=1;
var=num.toString();
binding.textJikir.setText(var);
    }
});

binding.buttonJikirRestart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       num=0;
        var=num.toString();

        binding.textJikir.setText(var);





    }
});



        return root;
    }
}