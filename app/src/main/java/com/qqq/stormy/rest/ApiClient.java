package com.qqq.stormy.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//    private static String API_KEY = "1bf4f4aad98d960c574ae8bd43502f1b";
//    private static String latitude = String.valueOf(51.8092);
//    private static String longitude = String.valueOf(107.6628);
//
//    public static final String BASE_URL = String.format("https://api.forecast.io/forecast/%s/%s,%s",
//            API_KEY, latitude, longitude);
    public static final String BASE_URL = "https://api.forecast.io/forecast/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

