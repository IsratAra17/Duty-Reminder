package com.example.dutyreminder.MySharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static MySharedPreferences mysharedPreferance = null;
    private MySharedPreferences(Context context)
    {
        sharedPreferences = context.getSharedPreferences("shared",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();

    }

    public static synchronized MySharedPreferences getPreferences(Context context)
    {

        if(mysharedPreferance==null) {
            mysharedPreferance = new MySharedPreferences(context);
        }

        return mysharedPreferance;
    }
    public void setLogin(String area) //login=key
    {
        editor.putString("login",area);
        editor.apply();
    }

    public String getLogin()
    {
        return sharedPreferences.getString("login","none");
    }



    public void setArea(String area)
    {
        editor.putString("area",area);
        editor.apply();
    }

    public String getArea()
    {
        return sharedPreferences.getString("area","none");
    }



    public void setAreaId(String areaId)
    {
        editor.putString("id",areaId);
        editor.apply();
    }

    public String getAreaId()
    {
        return sharedPreferences.getString("id","none");
    }

//






}



