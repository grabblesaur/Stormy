package com.qqq.stormy.model.day;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.qqq.stormy.model.IconManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by qqq on 16.06.2016.
 */
public class DailyData implements Parcelable{
    @SerializedName("time") private long mTimeInSeconds;
    @SerializedName("summary") private String mSummary;
    @SerializedName("icon") private String mIconString;
    @SerializedName("temperatureMin") private double mTemperatureMinF;
    @SerializedName("temperatureMax") private double mTemperatureMaxF;

    protected DailyData(Parcel in) {
        mTimeInSeconds = in.readLong();
        mSummary = in.readString();
        mIconString = in.readString();
        mTemperatureMinF = in.readDouble();
        mTemperatureMaxF = in.readDouble();
    }

    public static final Creator<DailyData> CREATOR = new Creator<DailyData>() {
        @Override
        public DailyData createFromParcel(Parcel in) {
            return new DailyData(in);
        }

        @Override
        public DailyData[] newArray(int size) {
            return new DailyData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mTimeInSeconds);
        dest.writeString(mSummary);
        dest.writeString(mIconString);
        dest.writeDouble(mTemperatureMinF);
        dest.writeDouble(mTemperatureMaxF);
    }

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

    public double getTemperatureMinF() {
        return mTemperatureMinF;
    }

    public void setTemperatureMinF(double temperatureMinF) {
        mTemperatureMinF = temperatureMinF;
    }

    public double getTemperatureMaxF() {
        return mTemperatureMaxF;
    }

    public void setTemperatureMaxF(double temperatureMaxF) {
        mTemperatureMaxF = temperatureMaxF;
    }

    public int getIconId() {
        return IconManager.getIconId(mIconString);
    }

    public String getDayOfTheWeek() {
        TimeZone tz = TimeZone.getDefault();

        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        formatter.setTimeZone(tz);
        Date dateTime = new Date(mTimeInSeconds * 1000);

        return formatter.format(dateTime);
    }

    public int getTemperatureMaxInCelsius() {
        return (int) Math.round(5 * (mTemperatureMaxF - 32) / 9);
    }

    public int getTemperatureMinInCelsius() {
        return (int) Math.round(5 * (mTemperatureMinF - 32) / 9);
    }
}
