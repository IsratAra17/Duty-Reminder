package com.example.dutyreminder.ui.Asor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dutyreminder.Adapter.DailyAdapter;
import com.example.dutyreminder.Model.ModelClassPrayer;
import com.example.dutyreminder.Retrofit.ApiClient;
import com.example.dutyreminder.Retrofit.ApiInterface;
import com.example.dutyreminder.databinding.FragmentAsorBinding;
import com.example.dutyreminder.databinding.FragmentFajarBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class AsorFragment extends Fragment {

    private FragmentAsorBinding binding;
    DailyAdapter dailyAdapter;
    ApiInterface apiInterface;
    ArrayList<ModelClassPrayer> fajarHadisList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = FragmentAsorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        getAsorHadis();

        // Inflate the layout for this fragment
        return root;
    }

    private void getAsorHadis() {


        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);
        dailyAdapter = new DailyAdapter(getContext(), fajarHadisList);

        binding.recyclerAsor.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        apiInterface.getasorHadis().enqueue(new Callback<List<ModelClassPrayer>>() {
            @Override
            public void onResponse(Call<List<ModelClassPrayer>> call, Response<List<ModelClassPrayer>> response) {
                fajarHadisList.addAll(response.body());
                binding.recyclerAsor.setAdapter(dailyAdapter);
                dailyAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Success Asor!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ModelClassPrayer>> call, Throwable t) {
                Toast.makeText(getContext(), "Can not get the data!!", Toast.LENGTH_SHORT).show();
            }
        });



    }
}

