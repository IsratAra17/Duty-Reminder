package com.example.dutyreminder.Spalsh;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dutyreminder.MainActivity;
import com.example.dutyreminder.Model.ModelClassPrayer;
import com.example.dutyreminder.MySharedPreferences.MySharedPreferences;
import com.example.dutyreminder.NavidrawerActivity;
import com.example.dutyreminder.Retrofit.ApiClient;
import com.example.dutyreminder.Retrofit.ApiInterface;
import com.example.dutyreminder.databinding.ActivityLocationBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LocationActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    private ActivityLocationBinding binding;
    String selectedDivision;
    int divisionposition;
    MySharedPreferences sharedPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_location);

        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sharedPreference= MySharedPreferences.getPreferences(this);

        binding.spinnerDivisionSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

               if (id!=0){
                   selectedDivision = binding.spinnerDivisionSelect.getItemAtPosition(position).toString();
                   Log.d(TAG, "onItemSelected: " + id);

                   sharedPreference.setLogin("logged");
                   binding.spinnerDivisionSelect.setSelection(position);
                   sharedPreference.setArea(selectedDivision);
                   sharedPreference.setAreaId("" + id);
                   Toast.makeText(LocationActivity.this, "\n আপনার জেলা\t " + selectedDivision +
                           "\n নির্বাচিত হয়েছে \t", Toast.LENGTH_LONG).show();



                   Intent intent = new Intent(LocationActivity.this, NavidrawerActivity.class);
                   intent.putExtra("area", selectedDivision);
                  // intent.putExtra("position",id);
                   startActivity(intent);
               }


               else{


               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }


        });//3


    }//2


/*    private void insertLocation()
    {
        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);

        ModelClassPrayer modelClassPrayer = new ModelClassPrayer();
        modelClassPrayer.setArea(selectedDivision);


        apiInterface.insertlocation(modelClassPrayer).enqueue(new Callback<ModelClassPrayer>()  {
            @Override
            public void onResponse(Call<ModelClassPrayer> call, Response<ModelClassPrayer> response) {
                //Log.d(TAG,"onResponse1");


                locationData();//getting data from databaese name area.
            }

            @Override
            public void onFailure(Call<ModelClassPrayer> call, Throwable t) {
                //Log.d(TAG,"onResponse0");
                Toast.makeText(LocationActivity.this, "failed", Toast.LENGTH_LONG).show();

            }
        });

    }


    private void locationData()
    {


        sharedPreference= MySharedPreferences.getPreferences(this);

        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);

        ModelClassPrayer modelClassPrayer = new ModelClassPrayer();

        modelClassPrayer.setArea(selectedDivision);

        apiInterface.selectedArea(modelClassPrayer).enqueue(new Callback<ModelClassPrayer>() {
            @Override
            public void onResponse(Call<ModelClassPrayer> call, Response<ModelClassPrayer> response) {


                //if (position!= 0 ) {
//Log.d(TAG,"onResponse1");
                if (response.body().getResponse().equals("ok")) {


                    Toast.makeText(LocationActivity.this, "\n আপনার জেলা\t " + selectedDivision +
                            "\n নির্বাচিত হয়েছে \t", Toast.LENGTH_LONG).show();


                    sharedPreference.setLogin("logged");
                    sharedPreference.setArea(response.body().getArea());
                    sharedPreference.setAreaId(response.body().getId());


                    String getArea = response.body().getArea();


                    Intent intent = new Intent(LocationActivity.this, NavidrawerActivity.class);
                    intent.putExtra("area", getArea);
                    intent.putExtra("position",divisionposition);
                    startActivity(intent);



//database table name area

                }
                else {

                    Toast.makeText(LocationActivity.this, ""
                            ,Toast.LENGTH_LONG).show();
                }
            }


            @Override
            public void onFailure(Call<ModelClassPrayer> call, Throwable t) {
                Toast.makeText(LocationActivity.this, "error"
                        , Toast.LENGTH_LONG).show();

            }
        });
    }*/


}//1
