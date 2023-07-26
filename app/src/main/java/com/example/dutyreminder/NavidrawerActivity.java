package com.example.dutyreminder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dutyreminder.databinding.NavidrawerBinding;

public class NavidrawerActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private NavidrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = NavidrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar); //toolbar

        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(new Intent(NavidrawerActivity.this, NavidrawerActivity.class));

            }
        });


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        navigationView.setItemIconTintList(null);//for menu icon colour


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_namj_somoy,R.id.nav_Day,R.id.nav_dua, R.id.nav_week, R.id.nav_month,R.id.nav_settings,R.id.nav_ramadan,R.id.nav_jikir,R.id.nav_zakat_cal)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navidrawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}