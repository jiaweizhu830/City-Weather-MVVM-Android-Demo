package com.meetsy.cityweather.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.meetsy.cityweather.model.WeatherResponse;
import com.meetsy.cityweather.network.RetrofitClient;
import com.meetsy.cityweather.network.WeatherAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {
    private final WeatherAPI weatherAPI;

    public WeatherRepository() {
        weatherAPI = RetrofitClient.newInstance().create(WeatherAPI.class);
    }

    public LiveData<WeatherResponse> getCurrentWeather(String id, String appid, String unit) {
        MutableLiveData<WeatherResponse> currentWeatherLiveData = new MutableLiveData<>();

        weatherAPI.getCurrentWeather(id, appid, unit).enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        if (response.isSuccessful()) {
                            currentWeatherLiveData.setValue(response.body());
                        } else {
                            currentWeatherLiveData.setValue(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        currentWeatherLiveData.setValue(null);
                    }
                });

        return currentWeatherLiveData;
    }
}
