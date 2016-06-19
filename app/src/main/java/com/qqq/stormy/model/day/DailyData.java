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
    @SerializedName("temperatureMin") private String mTemperatureMinF;
    @SerializedName("temperatureMax") private String mTemperatureMaxF;

    protected DailyData(Parcel in) {
        mTimeInSeconds = in.readLong();
        mSummary = in.readString();
        mIconString = in.readString();
        mTemperatureMinF = in.readString();
        mTemperatureMaxF = in.readString();
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
        dest.writeString(mTemperatureMinF);
        dest.writeString(mTemperatureMaxF);
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
}
