package com.qqq.stormy.model;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CurrentWeather {
    @SerializedName("time")
    private long mTimeInSeconds;
    @SerializedName("summary")
    private String mSummary;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("precipProbability")
    private int mPrecipProbability;
    @SerializedName("temperature")
    private double mTemperature;
    @SerializedName("humidity")
    private double mHumidity;
    @SerializedName("windSpeed")
    private double mWindSpeed;

    private IconManager mIconManager = new IconManager();

    public CurrentWeather(long timeInSeconds, String summary, String icon, int precipProbability, double temperature, double humidity, double windSpeed, IconManager iconManager) {
        mTimeInSeconds = timeInSeconds;
        mSummary = summary;
        mIcon = icon;
        mPrecipProbability = precipProbability;
        mTemperature = temperature;
        mHumidity = humidity;
        mWindSpeed = windSpeed;
        mIconManager = iconManager;
    }

    public double getTemperatureInCelsius() {
        return (mTemperature - 32) * 5 / 9;
    }

    public int getIconId() {
        // clear-day, clear-night, rain, snow, sleet, wind, fog, cloudy, partly-cloudy-day, or partly-cloudy-night
        return mIconManager.getIconId(mIcon);
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

    @Deprecated
    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public int getPrecipProbability() {
        return mPrecipProbability;
    }

    public void setPrecipProbability(int precipProbability) {
        mPrecipProbability = precipProbability;
    }

    /**
     * @return temperature in Fahrenheit
     */
    public double getTemperatureInFahrenheit() {
        return mTemperature;
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(double humidity) {
        mHumidity = humidity;
    }

    public double getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        mWindSpeed = windSpeed;
    }

    public IconManager getIconManager() {
        return mIconManager;
    }

    public void setIconManager(IconManager iconManager) {
        mIconManager = iconManager;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "mTimeInSeconds=" + mTimeInSeconds +
                ", mSummary='" + mSummary + '\'' +
                ", mIcon='" + mIcon + '\'' +
                ", mPrecipProbability=" + mPrecipProbability +
                ", mTemperature=" + mTemperature +
                ", mHumidity=" + mHumidity +
                ", mWindSpeed=" + mWindSpeed +
                ", mIconManager=" + mIconManager +
                '}';
    }
}


























//    public String getFormattingTime() {
//        SimpleDateFormat formatter = new SimpleDateFormat("k:mm");
//        formatter.setTimeZone(TimeZone.getTimeZone(mForecast.getTimezone()));
//        String timeString = formatter.format(new Date(mTimeInSeconds * 1000));
//
//        return timeString;
//    }
