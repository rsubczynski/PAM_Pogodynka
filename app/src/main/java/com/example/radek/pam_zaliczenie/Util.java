package com.example.radek.pam_zaliczenie;

import android.support.annotation.NonNull;

import com.example.radek.pam_zaliczenie.entity.City;
import com.example.radek.pam_zaliczenie.entity.CityAndHeaderList;

import java.util.ArrayList;
import java.util.Locale;

public class Util {

    @NonNull
    public static ArrayList<CityAndHeaderList> CityListGenerator() {
        ArrayList<CityAndHeaderList> cityList = new ArrayList<>();
        cityList.add(new City("Warta",0L));
        cityList.add(new City("Lódź",0L));
        cityList.add(new City("Warszawa",0L));
        cityList.add(new City("Sieradz",0L));
        cityList.add(new City("London",0L));
        cityList.add(new City("Berlin",0L));
        cityList.add(new City("Meksyk",0L));
        cityList.add(new City("Moskwa",0L));
        cityList.add(new City("Bruksela",0L));
        cityList.add(new City("Londyn",0L));
        cityList.add(new City("Madryt",0L));
        cityList.add(new City("Lizbona",0L));
        cityList.add(new City("Poznań",0L));

        return cityList;
    }

    public static String toCelsius(Double kelvin) {
        double result = kelvin - 273.0;
        return String.format(Locale.ENGLISH,"%1.2f" + " *C" , result);
    }
}
