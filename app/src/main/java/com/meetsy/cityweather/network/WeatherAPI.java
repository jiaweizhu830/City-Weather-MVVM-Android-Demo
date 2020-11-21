package com.meetsy.cityweather.network;

import com.meetsy.cityweather.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    @GET("weather")
    Call<WeatherResponse> getCurrentWeather(@Query("id") String id,
                                            @Query("appid") String appid,
                                            @Query("units") String unit);

}