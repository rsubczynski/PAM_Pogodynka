package com.example.radek.pam_zaliczenie;

import android.annotation.SuppressLint;

import com.example.radek.pam_zaliczenie.retrofit.ApiUtils;
import com.example.radek.pam_zaliczenie.retrofit.Entity.Example;
import com.example.radek.pam_zaliczenie.retrofit.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherProvider {

    final static String API_KEY = "c96dd99914a39dff911a34eeaf233dff";

    void getWeather(String CityName, final WeatherManager.WeatherResponseListener listener){

        WeatherService mService = ApiUtils.getSOService();
        mService.getWeather(CityName, API_KEY).enqueue(new Callback<Example>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                if (response.isSuccessful()) {
                        listener.onResponseSuccess(response);

                } else {
                    int statusCode = response.code();
                    listener.onResponseFail();
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t){
                listener.onResponseFail();
            }
        });
    }
}
