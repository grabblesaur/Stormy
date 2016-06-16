package com.qqq.stormy.model.day;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Day {
    @SerializedName("summary") private String mSummary;
    @SerializedName("icon") private String mIconString;
    @SerializedName("data") private List<DailyData> mDailyDataList;

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

    public List<DailyData> getDailyDataList() {
        return mDailyDataList;
    }

    public void setDailyDataList(List<DailyData> dailyDataList) {
        mDailyDataList = dailyDataList;
    }
}
