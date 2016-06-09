package com.qqq.stormy.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by qqq on 09.06.2016.
 */
public class Forecast {
    @SerializedName("latitude")
    private double mLatitude;
    @SerializedName("longitude")
    private double mLongitude;
    @SerializedName("timezone")
    private String mTimezone;
    @SerializedName("currently")
    private CurrentWeather mCurrentWeather;

    public Forecast(double latitude, double longitude, String timezone, CurrentWeather currentWeather) {
        mLatitude = latitude;
        mLongitude = longitude;
        mTimezone = timezone;
        mCurrentWeather = currentWeather;
    }

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

    public CurrentWeather getCurrentWeather() {
        return mCurrentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        mCurrentWeather = currentWeather;
    }
}
