package com.example.radek.pam_zaliczenie.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by user on 28.12.2017.
 */

public class City implements CityAndHeaderList {

    public City(String cityName, Long timeStamp) {
        this.cityName = cityName;
        this.timeStamp = timeStamp;
    }

    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    private Long timeStamp;

    public String GetDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
        return String.valueOf(calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE) + " day "+ calendar.get(Calendar.DAY_OF_MONTH)+"."+calendar.get(Calendar.MONTH));
    }

    @Override
    public int getListItemType() {
        return CityAndHeaderList.VIEW_TYPE_CITY;
    }
}
