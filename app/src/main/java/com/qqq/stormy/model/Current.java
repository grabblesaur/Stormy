package com.qqq.stormy.model;

import com.google.gson.annotations.SerializedName;
import com.qqq.stormy.R;

public class Current {
    @SerializedName("time")
    private long mTimeInSeconds;
    @SerializedName("summary")
    private String mSummary;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("precipProbability")
    private double mPrecipProbability;
    @SerializedName("temperature")
    private double mTemperature;
    @SerializedName("humidity")
    private double mHumidity;
    @SerializedName("windSpeed")
    private double mWindSpeed;
    private IconManager mIconManager;

    public Current(long timeInSeconds, String summary, String icon, double precipProbability, double temperature, double humidity, double windSpeed) {
        mTimeInSeconds = timeInSeconds;
        mSummary = summary;
        mIcon = icon;
        mPrecipProbability = precipProbability;
        mTemperature = temperature;
        mHumidity = humidity;
        mWindSpeed = windSpeed;
    }

    public int getTemperatureInCelsius() {
        return (int) ((mTemperature - 32) * 5 / 9);
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

    public double getPrecipProbability() {
        return mPrecipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
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

    @Override
    public String toString() {
        return "Current{" +
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
