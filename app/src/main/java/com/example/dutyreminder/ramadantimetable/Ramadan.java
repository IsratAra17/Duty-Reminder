package com.example.dutyreminder.ramadantimetable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dutyreminder.Adapter.DailyAdapter;
import com.example.dutyreminder.Adapter.PrayertimeAdapter;
import com.example.dutyreminder.Adapter.RamadanAdapter;
import com.example.dutyreminder.Model.ModelClassPrayer;
import com.example.dutyreminder.R;
import com.example.dutyreminder.Retrofit.ApiClient;
import com.example.dutyreminder.Retrofit.ApiInterface;
import com.example.dutyreminder.databinding.FragmentHomeBinding;
import com.example.dutyreminder.databinding.FragmentRamadanBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Ramadan extends Fragment {

    RamadanAdapter ramadanAdapter;
    ApiInterface apiInterface;
    ArrayList<ModelClassPrayer> modelRamadanArrayList= new ArrayList<>();
    private FragmentRamadanBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRamadanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        getRamadantime();

        return root;
    }

    private void getRamadantime() {


        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);
       ramadanAdapter= new RamadanAdapter(getContext(), modelRamadanArrayList);

        binding.recylerViewRamadanTimeFragmentRamadan.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        apiInterface.getramadantime().enqueue(new Callback<List<ModelClassPrayer>>() {
            @Override
            public void onResponse(Call<List<ModelClassPrayer>> call, Response<List<ModelClassPrayer>> response) {
                modelRamadanArrayList.addAll(response.body());
                binding.recylerViewRamadanTimeFragmentRamadan.setAdapter(ramadanAdapter);
                ramadanAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<ModelClassPrayer>> call, Throwable t) {

            }
        });



    }
}

