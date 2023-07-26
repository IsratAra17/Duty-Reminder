package com.example.dutyreminder.ui.Magriv;

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
import com.example.dutyreminder.databinding.FragmentMagrivBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MagrivFragment extends Fragment {

    private FragmentMagrivBinding binding;
    DailyAdapter dailyAdapter;
    ApiInterface apiInterface;
    ArrayList<ModelClassPrayer> fajarHadisList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = FragmentMagrivBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        getMagrivHadis();

        // Inflate the layout for this fragment
        return root;
    }

    private void  getMagrivHadis() {


        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);
        dailyAdapter = new DailyAdapter(getContext(), fajarHadisList);

        binding.recyclerMagriv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        apiInterface.getMagrivHadis().enqueue(new Callback<List<ModelClassPrayer>>() {
            @Override
            public void onResponse(Call<List<ModelClassPrayer>> call, Response<List<ModelClassPrayer>> response) {
                fajarHadisList.addAll(response.body());
                binding.recyclerMagriv.setAdapter(dailyAdapter);
                dailyAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<ModelClassPrayer>> call, Throwable t) {

            }
        });



    }
}

