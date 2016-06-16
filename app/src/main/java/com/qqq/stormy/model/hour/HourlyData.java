package com.qqq.stormy.model.hour;

import com.google.gson.annotations.SerializedName;

/**
 * Created by qqq on 16.06.2016.
 */
public class HourlyData {
    @SerializedName("time") private long mTimeInSeconds;
    @SerializedName("summary") private String mSummary;
    @SerializedName("icon") private String mIconString;
    @SerializedName("temperature") private double mTemperature;

    public long getTimeInSeconds() {
        return mTimeInSeconds;
    }

    public void setTimeInSeconds(long timeInSeconds) {
        mTimeInSeconds = timeInSeconds;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public String getIconString() {
        return mIconString;
    }

    public void setIconString(String iconString) {
        mIconString = iconString;
    }

    public double getTemperature() {
        return mTemperature;
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }
}
