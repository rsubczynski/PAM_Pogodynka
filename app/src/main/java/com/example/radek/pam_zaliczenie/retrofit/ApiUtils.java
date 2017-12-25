package com.example.radek.pam_zaliczenie.retrofit;

public class ApiUtils {
    public static final String BASE_URL = "http://api.openweathermap.org/data/";

    public static WeatherService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(WeatherService.class);
    }
}
