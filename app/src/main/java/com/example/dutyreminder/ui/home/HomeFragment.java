package com.example.dutyreminder.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.dutyreminder.Adapter.PrayertimeAdapter;
import com.example.dutyreminder.Model.ModelClassPrayer;
import com.example.dutyreminder.MySharedPreferences.MySharedPreferences;
import com.example.dutyreminder.R;
import com.example.dutyreminder.Retrofit.ApiClient;
import com.example.dutyreminder.Retrofit.ApiInterface;
import com.example.dutyreminder.databinding.FragmentHomeBinding;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {
    private static final String TAG = "dfdf";
    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    PrayertimeAdapter prayertimeAdapter;
    ApiInterface apiInterface;
    ArrayList<ModelClassPrayer> modelClassPrayerArrayList = new ArrayList<>();
    MySharedPreferences sharedPreference;
    private FragmentHomeBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();





        mylocation();
        English_date();

        getPrayer();


        // Making notification bar transparent
        /*if (Build.VERSION.SDK_INT >= 21) {
           getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }*/






        return root;
    }


    private void English_date() {


        calendar = Calendar.getInstance();
        Locale locale = new Locale("bn");
        dateFormat = new SimpleDateFormat(" EEEE\n d.MMMM.yyyy", locale);//sat,jan 8,22
        date = dateFormat.format(calendar.getTime());
        binding.tvEnglishDate.setText(date);


    }


    private void mylocation() {


        sharedPreference = MySharedPreferences.getPreferences(getContext());

        if (sharedPreference.getLogin().equals("logged")) {

            binding.tvLocation.setText(sharedPreference.getArea());


        } else {

            binding.tvLocation.setText(getActivity().getIntent().getStringExtra("area"));


        }


    }

    private void getPrayer() {


        // modelClassPrayerArrayList = new ArrayList<>();
        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);
        prayertimeAdapter = new PrayertimeAdapter(getContext(), modelClassPrayerArrayList);
        binding.recyclerHome.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));




        //way 1

        ModelClassPrayer modelClassPrayer=new ModelClassPrayer();
        modelClassPrayer.setId(sharedPreference.getAreaId());//collect the id to get data from database to app.


      apiInterface.getPrayertimebylocation(modelClassPrayer).enqueue(new Callback<List<ModelClassPrayer>>() {
            @Override
            public void onResponse(Call<List<ModelClassPrayer>> call, Response<List<ModelClassPrayer>> response) {

                modelClassPrayerArrayList.addAll(response.body());
                binding.recyclerHome.setAdapter(prayertimeAdapter);
                prayertimeAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Alhamdulillah", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<List<ModelClassPrayer>> call, Throwable t) {
                Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();
            }
        });

        //way2

      /*  int id= Integer.parseInt(sharedPreference.getAreaId());
        apiInterface.getPrayertimebylocation1(id).enqueue(new Callback<List<ModelClassPrayer>>() {
            @Override
            public void onResponse(Call<List<ModelClassPrayer>> call, Response<List<ModelClassPrayer>> response) {
                modelClassPrayerArrayList.addAll(response.body());
                binding.recyclerHome.setAdapter(prayertimeAdapter);
                prayertimeAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Alhamdulillah", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ModelClassPrayer>> call, Throwable t) {

            }
        });*/





    }
}
