package com.qqq.stormy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.qqq.stormy.R;
import com.qqq.stormy.model.Current;
import com.qqq.stormy.model.Forecast;
import com.qqq.stormy.rest.ApiClient;
import com.qqq.stormy.rest.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.temperatureTextView) TextView mTemperature;
    @BindView(R.id.timeTextView) TextView mCurrentTime;
    @BindView(R.id.timezoneTextView) TextView mTimeZone;
    @BindView(R.id.iconWeatherImageView) ImageView mIconWeather;
    @BindView(R.id.humidity) TextView mHumidity;
    @BindView(R.id.rain) TextView mRainPrecip;
    @BindView(R.id.summary) TextView mSummary;
    @BindView(R.id.refreshButton) ImageView mRefreshImageView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataFromForecastAPI();
    }

    private void getDataFromForecastAPI() {
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
                Current current = response.body().getCurrent();
                Log.d(TAG, "Current Weather: " + current.toString());
                settingUpLayout(current, forecast);
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void settingUpLayout(Current current, Forecast forecast) {
        ButterKnife.bind(this);

        mTemperature.setText(String.valueOf(current.getTemperatureInCelsius()));
        mCurrentTime.setText(getFormattedTime(current.getTimeInSeconds(), forecast));
        mTimeZone.setText(forecast.getTimezone());
        mIconWeather.setImageResource(current.getIconId());
        mHumidity.setText(String.valueOf(current.getHumidity()));
        mRainPrecip.setText(String.valueOf(current.getPrecipProbability()));
        mSummary.setText(current.getSummary());


        // adding progress bar on RefreshImageView
        mProgressBar.setVisibility(View.INVISIBLE);
        mRefreshImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                getDataFromForecastAPI();
            }
        });
    }

    private String getFormattedTime(long timeInSeconds, Forecast forecast) {
        SimpleDateFormat formatter = new SimpleDateFormat("k:mm");
        formatter.setTimeZone(TimeZone.getTimeZone(forecast.getTimezone()));
        return formatter.format(new Date(timeInSeconds * 1000));
    }
}













