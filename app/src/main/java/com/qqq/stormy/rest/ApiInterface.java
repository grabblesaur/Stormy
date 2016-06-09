package com.qqq.stormy.rest;

import com.qqq.stormy.model.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by qqq on 09.06.2016.
 * https://api.forecast.io/forecast/APIKEY/LATITUDE,LONGITUDE
 */
public interface ApiInterface {
    @GET("{api_key}/{latitude},{longitude}")
    Call<Forecast> getForecast(@Path("api_key") String apiKey,
                               @Path("latitude") double latitude,
                               @Path("longitude") double longitude);
}
