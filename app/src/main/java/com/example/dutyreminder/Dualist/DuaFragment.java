package com.example.dutyreminder.Dualist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dutyreminder.Adapter.DailyAdapter;
import com.example.dutyreminder.Model.ModelClassPrayer;
import com.example.dutyreminder.R;
import com.example.dutyreminder.Retrofit.ApiClient;
import com.example.dutyreminder.Retrofit.ApiInterface;
import com.example.dutyreminder.databinding.FragmentDayBinding;
import com.example.dutyreminder.databinding.FragmentDuaBinding;
import com.example.dutyreminder.databinding.FragmentFajarBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class DuaFragment extends Fragment {
    private FragmentDuaBinding binding;
    DailyAdapter dailyAdapter;
    ApiInterface apiInterface;
    ArrayList<ModelClassPrayer> fajarHadisList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDuaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        getdualist();


        // Inflate the layout for this fragment
        return root;
    }


    private void getdualist() {


        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);
        dailyAdapter = new DailyAdapter(getContext(), fajarHadisList);

        binding.recyclerFajar.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        apiInterface.getdualist().enqueue(new Callback<List<ModelClassPrayer>>() {
            @Override
            public void onResponse(Call<List<ModelClassPrayer>> call, Response<List<ModelClassPrayer>> response) {
                fajarHadisList.addAll(response.body());
                binding.recyclerFajar.setAdapter(dailyAdapter);
                dailyAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Success!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ModelClassPrayer>> call, Throwable t) {
                Toast.makeText(getContext(), "Can not get the data!!", Toast.LENGTH_SHORT).show();
            }
        });



    }
}

