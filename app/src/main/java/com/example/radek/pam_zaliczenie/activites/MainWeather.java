package com.example.radek.pam_zaliczenie.activites;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.radek.pam_zaliczenie.R;
import com.example.radek.pam_zaliczenie.Util;
import com.example.radek.pam_zaliczenie.WeatherManager;
import com.example.radek.pam_zaliczenie.retrofit.Entity.Example;

import retrofit2.Response;

import static com.example.radek.pam_zaliczenie.activites.MainActivity.KEY_CITY_NAME;

public class MainWeather extends AppCompatActivity implements WeatherManager.WeatherResponseListener {

    private TextView tvCityName;
    private TextView tvCityTemp;
    private TextView tvMaxTemp;
    private TextView tvMinTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_weather);
        initView();
    }

    private void initView() {
        tvCityName = findViewById(R.id.tvCityName);
        tvCityTemp = findViewById(R.id.tvCityTemp);
        tvMinTemp = findViewById(R.id.tvCityMinTemp);
        tvMaxTemp = findViewById(R.id.tvCityMaxTemp);
    }

    @Override
    protected void onResume() {
        super.onResume();
        WeatherManager.getInstance().registerWeatherListener(this);
        WeatherManager.getInstance().getWeather(this, getIntent().getStringExtra(KEY_CITY_NAME));
    }

    @Override
    protected void onPause() {
        super.onPause();
        WeatherManager.getInstance().unregisterWeatherListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponseSuccess(Response<Example> response) {
        tvCityName.setText(getString(R.string.cityMaxTemp) +response.body().getName());
        tvCityTemp.setText((getString(R.string.cityTemp) +Util.toCelsius(response.body().getMain().getTemp())));
        tvMinTemp.setText(getString(R.string.cityMinTemp)+ Util.toCelsius(response.body().getMain().getTempMin()));
        tvMaxTemp.setText(getString(R.string.cityMaxTemp) + Util.toCelsius(response.body().getMain().getTempMax()));

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponseFail() {
        tvCityName.setText(getString(R.string.cityName)+getString(R.string.cityFail));
        tvCityTemp.setText((getString(R.string.cityTemp)+getString(R.string.cityFail)));
        tvMinTemp.setText(getString(R.string.cityMinTemp)+getString(R.string.cityFail));
        tvMaxTemp.setText(getString(R.string.cityMaxTemp)+getString(R.string.cityFail));
    }
}
