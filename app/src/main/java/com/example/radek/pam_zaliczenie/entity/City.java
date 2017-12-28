package com.example.radek.pam_zaliczenie.entity;

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

    @Override
    public int getListItemType() {
        return CityAndHeaderList.VIEW_TYPE_CITY;
    }
}
