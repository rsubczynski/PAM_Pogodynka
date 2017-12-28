package com.example.radek.pam_zaliczenie.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.radek.pam_zaliczenie.Util;
import com.example.radek.pam_zaliczenie.adapters.HeaderItemDecoration;
import com.example.radek.pam_zaliczenie.adapters.MyRecyclerViewAdapter;
import com.example.radek.pam_zaliczenie.R;
import com.example.radek.pam_zaliczenie.entity.CityAndHeaderList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    public final static String KEY_CITY_NAME = "cityName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<CityAndHeaderList> cityList = Util.CityListGenerator();

        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, cityList);
        recyclerView.setAdapter(myRecyclerViewAdapter);
        recyclerView.addItemDecoration(new HeaderItemDecoration(recyclerView, myRecyclerViewAdapter));

    }

    @Override
    public void onItemClick(String cityName) {
        Intent intent = new Intent(this, MainWeather.class);
        intent.putExtra(KEY_CITY_NAME, cityName);
        startActivity(intent);
    }
}
