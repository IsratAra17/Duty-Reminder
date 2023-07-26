package com.example.dutyreminder.ui.Week;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dutyreminder.R;
import com.example.dutyreminder.databinding.FragmentWeek2Binding;
import com.example.dutyreminder.databinding.FragmentWeekBinding;

public class WeekFragment2 extends Fragment {

private FragmentWeek2Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWeek2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
}