package com.qqq.stormy.model.hour;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hour {
    @SerializedName("summary") private String mSummary;
    @SerializedName("icon") private String mIconString;
    @SerializedName("data") private List<HourlyData> mHourlyDataList;

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

    public List<HourlyData> getHourlyDataList() {
        return mHourlyDataList;
    }

    public void setHourlyDataList(List<HourlyData> hourlyDataList) {
        mHourlyDataList = hourlyDataList;
    }
}
