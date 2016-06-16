package com.qqq.stormy.model;

import com.google.gson.annotations.SerializedName;
import com.qqq.stormy.R;

public class CurrentWeather {
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

    public CurrentWeather(long timeInSeconds, String summary, String icon, double precipProbability, double temperature, double humidity, double windSpeed) {
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
//        int iconId = R.drawable.clear_day;
//        if (mIcon.equals("clear-day")) {
//            iconId = R.drawable.clear_day;
//        }
//        else if (mIcon.equals("clear-night")) {
//            iconId = R.drawable.clear_night;
//        }
//        else if (mIcon.equals("rain")) {
//            iconId = R.drawable.rain;
//        }
//        else if (mIcon.equals("snow")) {
//            iconId = R.drawable.snow;
//        }
//        else if (mIcon.equals("sleet")) {
//            iconId = R.drawable.sleet;
//        }
//        else if (mIcon.equals("wind")) {
//            iconId = R.drawable.wind;
//        }
//        else if (mIcon.equals("fog")) {
//            iconId = R.drawable.fog;
//        }
//        else if (mIcon.equals("cloudy")) {
//            iconId = R.drawable.cloudy;
//        }
//        else if (mIcon.equals("partly-cloudy-day")) {
//            iconId = R.drawable.partly_cloudy;
//        }
//        else if (mIcon.equals("partly-cloudy-night")) {
//            iconId = R.drawable.cloudy_night;
//        }
//        return iconId;
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
