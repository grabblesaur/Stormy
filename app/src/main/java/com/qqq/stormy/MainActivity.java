package com.qqq.stormy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qqq.stormy.model.CurrentWeather;
import com.qqq.stormy.model.Forecast;
import com.qqq.stormy.rest.ApiClient;
import com.qqq.stormy.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
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
                CurrentWeather currentWeather = response.body().getCurrentWeather();
                Log.d(TAG, "Current Weather: " + currentWeather.toString());
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }
}













