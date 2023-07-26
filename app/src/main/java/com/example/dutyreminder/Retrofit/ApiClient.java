package com.example.dutyreminder.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //https://israt17.000webhostapp.com/UniProjectApi/

    private  static final String BASE_URL = "https://israt25.000webhostapp.com/uniProjectIsratAra/";

    private static Retrofit retrofit = null;

    private static  Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private ApiClient(){}

    public  static synchronized Retrofit getClint(){
        if (retrofit==null){
            int timeOut = 5*60;

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(timeOut, TimeUnit.SECONDS)
                    .writeTimeout(timeOut,TimeUnit.SECONDS)
                    .readTimeout(timeOut,TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();

        }
        return  retrofit;
    }






}


