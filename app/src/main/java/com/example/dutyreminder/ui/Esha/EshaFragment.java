package com.example.dutyreminder.ui.Esha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dutyreminder.Adapter.DailyAdapter;
import com.example.dutyreminder.Adapter.EsharAdapter;
import com.example.dutyreminder.Model.ModelClassPrayer;
import com.example.dutyreminder.Retrofit.ApiClient;
import com.example.dutyreminder.Retrofit.ApiInterface;
import com.example.dutyreminder.databinding.FragmentEshaBinding;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class EshaFragment extends Fragment {

    private FragmentEshaBinding binding;
    EsharAdapter esharAdapter;
    ApiInterface apiInterface;
    ArrayList<ModelClassPrayer> EshaHadisList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = FragmentEshaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        getEsharHadis();

        // Inflate the layout for this fragment
        return root;
    }

    private void getEsharHadis() {


        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);
        esharAdapter= new EsharAdapter(getContext(),EshaHadisList);

        binding.recyclerEsha.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        apiInterface.getEsharHadis().enqueue(new Callback<List<ModelClassPrayer>>() {
            @Override
            public void onResponse(Call<List<ModelClassPrayer>> call, Response<List<ModelClassPrayer>> response) {
                EshaHadisList.addAll(response.body());
                binding.recyclerEsha.setAdapter(esharAdapter);
                esharAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Success!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ModelClassPrayer>> call, Throwable t) {
                Toast.makeText(getContext(), "Can not get the data!!", Toast.LENGTH_SHORT).show();
            }
        });
    }






}

