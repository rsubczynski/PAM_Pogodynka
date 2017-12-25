package com.example.radek.pam_zaliczenie.retrofit;

import com.example.radek.pam_zaliczenie.retrofit.Entity.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("?q=London")
    Call<Example> getWeather();

    @GET("2.5/weather")
    Call<Example> getWeather(@Query("q") String tags, @Query("APPID") String APPID);
}