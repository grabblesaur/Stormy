package com.qqq.stormy.model.day;

import com.google.gson.annotations.SerializedName;

/**
 * Created by qqq on 16.06.2016.
 */
public class DailyData {
    @SerializedName("time") private long mTimeInSeconds;
    @SerializedName("summary") private String mSummary;
    @SerializedName("icon") private String mIconString;
    @SerializedName("temperatureMin") private String mTemperatureMinF;
    @SerializedName("temperatureMax") private String mTemperatureMaxF;

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

    public String getTemperatureMinF() {
        return mTemperatureMinF;
    }

    public void setTemperatureMinF(String temperatureMinF) {
        mTemperatureMinF = temperatureMinF;
    }

    public String getTemperatureMaxF() {
        return mTemperatureMaxF;
    }

    public void setTemperatureMaxF(String temperatureMaxF) {
        mTemperatureMaxF = temperatureMaxF;
    }
}
