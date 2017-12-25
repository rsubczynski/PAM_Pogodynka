package com.example.radek.pam_zaliczenie;

import com.example.radek.pam_zaliczenie.retrofit.Entity.Example;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class WeatherManager {

    private static WeatherManager weatherManager;
    private final List<WeatherResponseListener> responseListenerList = new ArrayList<>();

    private WeatherManager() {
    }

    public static WeatherManager getInstance() {
        if (weatherManager == null) {
            weatherManager = new WeatherManager();
        }
        return weatherManager;
    }

    public void registerWeatherListener(WeatherResponseListener listener) {
        if (!responseListenerList.contains(listener)) {
            responseListenerList.add(listener);
        }
    }

    public void unregisterWeatherListener(WeatherResponseListener listener) {
        if (responseListenerList.contains(listener)) {
            responseListenerList.remove(listener);
        }
    }

    public void getWeather(final WeatherResponseListener listener, String cityName){
        new WeatherProvider().getWeather(cityName, new WeatherResponseListener() {
            @Override
            public void onResponseSuccess(Response<Example> response) {
                if(responseListenerList.contains(listener)){
                     listener.onResponseSuccess(response);
                }
            }

            @Override
            public void onResponseFail() {
                if(responseListenerList.contains(listener)){
                    listener.onResponseFail();
                }
            }
        });
    }

    public interface WeatherResponseListener {
        void onResponseSuccess(Response<Example> response);

        void onResponseFail();
    }
}
