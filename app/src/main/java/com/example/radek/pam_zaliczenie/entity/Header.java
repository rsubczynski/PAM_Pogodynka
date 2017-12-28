package com.example.radek.pam_zaliczenie.entity;

/**
 * Created by user on 28.12.2017.
 */

public class Header implements CityAndHeaderList {

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    private long timeStamp;

    @Override
    public int getListItemType() {
        return CityAndHeaderList.VIEW_TYPE_HEADER;
    }
}
