package com.qqq.stormy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.qqq.stormy.model.CurrentWeather;
import com.qqq.stormy.model.Forecast;
import com.qqq.stormy.rest.ApiClient;
import com.qqq.stormy.rest.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mTemperature;
    private TextView mCurrentTime;
    private TextView mTimeZone;
    private ImageView mIconWeather;
    private TextView mHumidity;
    private TextView mRainPrecip;
    private TextView mSummary;

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String API_KEY = "1bf4f4aad98d960c574ae8bd43502f1b";
        double latitude = 51.8092;
        double longitude = 107.6628;

        ApiInterface apiService = ApiClient
                .getClient()
                .create(ApiInterface.class);
        Call<Forecast> call = apiService.getForecast(API_KEY, latitude, longitude);
        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                Forecast forecast = response.body();
                CurrentWeather currentWeather = response.body().getCurrentWeather();
                settingUpLayout(currentWeather, forecast);
                Log.d(TAG, "Current Weather: " + currentWeather.toString());
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }

    private void settingUpLayout(CurrentWeather currentWeather, Forecast forecast) {
        mTemperature = (TextView) findViewById(R.id.temperatureTextView);
        mTemperature.setText(String.valueOf(currentWeather.getTemperatureInCelsius()));

        mCurrentTime = (TextView) findViewById(R.id.timeTextView);
        mCurrentTime.setText(getFormattedTime(currentWeather.getTimeInSeconds(), forecast));

        mTimeZone = (TextView) findViewById(R.id.timezoneTextView);
        mTimeZone.setText(forecast.getTimezone());

        mIconWeather = (ImageView) findViewById(R.id.iconWeatherImageView);
        mIconWeather.setImageResource(currentWeather.getIconId());

        mHumidity = (TextView) findViewById(R.id.humidity);
        mHumidity.setText(String.valueOf(currentWeather.getHumidity()));

        mRainPrecip = (TextView) findViewById(R.id.rain);
        mRainPrecip.setText(String.valueOf(currentWeather.getPrecipProbability()));

        mSummary = (TextView) findViewById(R.id.summary);
        mSummary.setText(currentWeather.getSummary());
    }

    private String getFormattedTime(long timeInSeconds, Forecast forecast) {
        SimpleDateFormat formatter = new SimpleDateFormat("k:mm");
        formatter.setTimeZone(TimeZone.getTimeZone(forecast.getTimezone()));
        return formatter.format(new Date(timeInSeconds * 1000));
    }
}













