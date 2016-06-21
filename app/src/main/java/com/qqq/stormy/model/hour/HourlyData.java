package com.qqq.stormy.model.hour;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.qqq.stormy.model.IconManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HourlyData implements Parcelable{
    @SerializedName("time") private long mTimeInSeconds;
    @SerializedName("summary") private String mSummary;
    @SerializedName("icon") private String mIconString;
    @SerializedName("temperature") private double mTemperature;

    protected HourlyData(Parcel in) {
        mTimeInSeconds = in.readLong();
        mSummary = in.readString();
        mIconString = in.readString();
        mTemperature = in.readDouble();
    }

    public static final Creator<HourlyData> CREATOR = new Creator<HourlyData>() {
        @Override
        public HourlyData createFromParcel(Parcel in) {
            return new HourlyData(in);
        }

        @Override
        public HourlyData[] newArray(int size) {
            return new HourlyData[size];
        }
    };

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

    public String getFormattedTimeInHours() {
        SimpleDateFormat formatter = new SimpleDateFormat("H:mm", Locale.getDefault());
        Date date = new Date(mTimeInSeconds * 1000);
        return formatter.format(date);
    }

    public int getTemperatureInCelsius() {
        return (int) Math.round(5 * (mTemperature - 32) / 9);
    }

    public int getIconId() {
        return IconManager.getIconId(mIconString);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mTimeInSeconds);
        dest.writeString(mSummary);
        dest.writeString(mIconString);
        dest.writeDouble(mTemperature);
    }
}
