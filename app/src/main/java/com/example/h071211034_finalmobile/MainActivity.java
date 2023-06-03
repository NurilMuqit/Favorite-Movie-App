package com.example.h071211034_finalmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    MovieFragment movieFragment = new MovieFragment();
    TvSeriesFragment tvSeriesFragment = new TvSeriesFragment();
    FavoriteFragment favoriteFragment = new FavoriteFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,movieFragment).commit();

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.movie:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,movieFragment).commit();
                        return true;
                    case R.id.tv_series:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,tvSeriesFragment).commit();
                        return true;
                    case R.id.favorite:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,favoriteFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}