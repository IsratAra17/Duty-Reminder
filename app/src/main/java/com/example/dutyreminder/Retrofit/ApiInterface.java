package com.example.dutyreminder.Retrofit;




import com.example.dutyreminder.Model.ModelClassPrayer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {


   // @POST("location.php")
    //Call<ModelClassPrayer> selectedArea(@Body ModelClassPrayer modelClassPrayer);

   // @POST("areaInsert.php")
   // Call<ModelClassPrayer> insertlocation(@Body ModelClassPrayer modelClass);
   @GET("zakat.php")
   Call<List<ModelClassPrayer>>getzakat();


    //@GET("prayertime.php")
    //Call<List<ModelClassPrayer>>getData();

   // @GET("getbyposition2.php")
   // Call<List<ModelClassPrayer>>g();
   @GET("getmonthMuharram.php")
   Call<List<ModelClassPrayer>>getMonthMuharram();

    @GET("monthJilhaz.php")
    Call<List<ModelClassPrayer>>getjilhaz();

    @GET("getFajarHadis.php")
    Call<List<ModelClassPrayer>>getFajrHadis();

    @GET("getzuhorHadis.php")
    Call<List<ModelClassPrayer>>getzuhorHadis();

    @GET("getAsorHadis.php")
    Call<List<ModelClassPrayer>>getasorHadis();

    @GET("getMagrivHadis.php")
    Call<List<ModelClassPrayer>>getMagrivHadis();

    @GET("getEsharHadis.php")
    Call<List<ModelClassPrayer>>getEsharHadis();


    @GET("getramadantime.php")
    Call<List<ModelClassPrayer>>getramadantime();

    @GET("getDualist.php")
    Call<List<ModelClassPrayer>>getdualist();

    @POST("get_user_request_prayertime.php")
    Call<List<ModelClassPrayer>>getPrayertimebylocation(@Body ModelClassPrayer modelClassPrayer);

   /* @POST("get_user_request_prayertime.php")
    Call<List<ModelClassPrayer>> getPrayertimebylocation1(@Query("id") int id);*/
}