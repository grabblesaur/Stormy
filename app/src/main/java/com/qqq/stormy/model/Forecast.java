package com.qqq.stormy.model;

import com.google.gson.annotations.SerializedName;
import com.qqq.stormy.model.day.Day;
import com.qqq.stormy.model.hour.Hour;

public class Forecast {
    @SerializedName("latitude") private double mLatitude;
    @SerializedName("longitude") private double mLongitude;
    @SerializedName("timezone") private String mTimezone;
    @SerializedName("currently") private Current mCurrent;
    @SerializedName("hourly") private Hour mHour;
    @SerializedName("daily") private Day mDay;

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    public Current getCurrent() {
        return mCurrent;
    }

    public void setCurrent(Current current) {
        mCurrent = current;
    }

    public Hour getHour() {
        return mHour;
    }

    public void setHour(Hour hour) {
        mHour = hour;
    }

    public Day getDay() {
        return mDay;
    }

    public void setDay(Day day) {
        mDay = day;
    }
}
