package com.example.radek.pam_zaliczenie;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Locale;

public class Util {

    @NonNull
    public static ArrayList<String> CityListGenerator() {
        ArrayList<String> cityList = new ArrayList<>();
        cityList.add("Warta");
        cityList.add("Lódź");
        cityList.add("Warszawa");
        cityList.add("Sieradz");
        cityList.add("London");
        cityList.add("Berlin");
        cityList.add("Kalisz");
        cityList.add("Kraków");
        cityList.add("Meksyk");
        cityList.add("Moskwa");
        cityList.add("Bruksela");
        cityList.add("Londyn");
        cityList.add("Madryt");
        cityList.add("Lizbona");
        cityList.add("Poznań");

        return cityList;
    }

    public static String toCelsius(Double kelvin) {
        double result = kelvin - 273.0;
        return String.format(Locale.ENGLISH,"%1.2f" + " *C" , result);
    }
}
