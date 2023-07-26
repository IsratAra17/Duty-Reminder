package com.example.dutyreminder.Spalsh;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dutyreminder.MainActivity;
import com.example.dutyreminder.MySharedPreferences.MySharedPreferences;
import com.example.dutyreminder.NavidrawerActivity;
import com.example.dutyreminder.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;


public class SpalshActivity extends AppCompatActivity {
    MySharedPreferences sharedPreference;
    int SPLASH_DISPLAY_LENGTH=2000;
    String fcmToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);


        sharedPreference= MySharedPreferences.getPreferences(this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (!sharedPreference.getAreaId().equals("none")) {
//location select er pore
                    Intent mainIntent = new Intent(SpalshActivity.this, NavidrawerActivity.class);
                    startActivity(mainIntent);
                    finish();

                } else {
                    //location na diley

                    Intent intent = new Intent(SpalshActivity.this, LocationActivity.class);
                    startActivity(intent);
                    Fcmtoken();
                    finish();

                }
            }
        },SPLASH_DISPLAY_LENGTH);
    }






    public void Fcmtoken()
    {
        // for sending notification to all
        FirebaseMessaging.getInstance().subscribeToTopic("all");



        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (task.isSuccessful()) {
                            fcmToken = Objects.requireNonNull(task.getResult()).getToken();

                        }

                    }
                });

    }
}
