package com.example.radek.pam_zaliczenie;

import android.support.annotation.NonNull;

import com.example.radek.pam_zaliczenie.entity.City;
import com.example.radek.pam_zaliczenie.entity.CityAndHeaderList;
import com.example.radek.pam_zaliczenie.entity.Header;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Util {

    @NonNull
    public static ArrayList<CityAndHeaderList> CityListGenerator() {
        Calendar calendar = Calendar.getInstance();
        long timeStamp = calendar.getTimeInMillis();

        ArrayList<CityAndHeaderList> cityList = new ArrayList<>();

        cityList.add(new City("Warta", timeStamp));
        cityList.add(new City("Warta", timeStamp));
        cityList.add(new City("Warta", timeStamp));
        cityList.add(new City("Warta", timeStamp));
        cityList.add(new City("Warta", timeStamp));
        cityList.add(new City("Warta", timeStamp));
        cityList.add(new City("Warta", timeStamp));
        cityList.add(new City("Warta", timeStamp));
        cityList.add(new City("Warta", timeStamp));
        cityList.add(new City("Warta", timeStamp));
        cityList.add(new City("Warta", timeStamp));
        cityList.add(new City("Warta", timeStamp));
        cityList.add(new City("Warta", timeStamp));

//        cityList.add(new Header());
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 24));
        cityList.add(new City("Lódź", timeStamp + 1000 * 60 * 60 * 24));
        cityList.add(new City("Warszawa", timeStamp + 1000 * 60 * 60 * 24));
        cityList.add(new City("Sieradz", timeStamp + 1000 * 60 * 60 * 24));
        cityList.add(new City("London", timeStamp + 1000 * 60 * 60 * 24));
        cityList.add(new City("Berlin", timeStamp + 1000 * 60 * 60 * 24));
        cityList.add(new City("Meksyk", timeStamp + 1000 * 60 * 60 * 24));
        cityList.add(new City("Moskwa", timeStamp + 1000 * 60 * 60 * 24));
        cityList.add(new City("Bruksela", timeStamp + 1000 * 60 * 60 * 24));
        cityList.add(new City("Londyn", timeStamp + 1000 * 60 * 60 * 24));
        cityList.add(new City("Madryt", timeStamp + 1000 * 60 * 60 * 24));
        cityList.add(new City("Lizbona", timeStamp + 1000 * 60 * 60 * 24));
        cityList.add(new City("Poznań", timeStamp + 1000 * 60 * 60 * 24));

        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 48));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 48));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 48));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 48));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 48));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 48));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 48));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 48));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 48));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 48));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 48));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 48));

        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));
        cityList.add(new City("Warta", timeStamp + 1000 * 60 * 60 * 72));

        return cityList;
    }

    @NonNull
    public static ArrayList<CityAndHeaderList> finalListGenerator() {
        ArrayList<CityAndHeaderList> cityAndHeaderLists = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int tmpDay = -1;

        for (CityAndHeaderList item : CityListGenerator()) {

            if (item.getListItemType() == CityAndHeaderList.VIEW_TYPE_CITY) {
                calendar.setTimeInMillis(((City) item).getTimeStamp());
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                if (day != tmpDay) {
                    tmpDay = day;
                    cityAndHeaderLists.add(new Header(calendar.getTimeInMillis()));
                } else {
                    cityAndHeaderLists.add(item);
                }
            }
        }
        return cityAndHeaderLists;
    }



    public static String toCelsius(Double kelvin) {
        double result = kelvin - 273.0;
        return String.format(Locale.ENGLISH, "%1.2f" + " *C", result);
    }
}
