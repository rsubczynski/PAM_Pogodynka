package com.example.radek.pam_zaliczenie.entity;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by user on 28.12.2017.
 */

public class Header implements CityAndHeaderList {

    public Header(long timeInMillis) {
        timeStamp = timeInMillis;
    }

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

    public String GetDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
        return String.valueOf(calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE) + " day "+ calendar.get(Calendar.DAY_OF_MONTH)+"."+calendar.get(Calendar.MONTH));
    }
}
