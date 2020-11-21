package com.meetsy.cityweather.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.meetsy.cityweather.model.WeatherResponse;
import com.meetsy.cityweather.repository.WeatherRepository;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> idInput = new MutableLiveData<>();
    private final MutableLiveData<String> appidInput = new MutableLiveData<>();
    private final MutableLiveData<String> tempUnitInput = new MutableLiveData<>();
    private final WeatherRepository repository;

    public HomeViewModel(WeatherRepository repository) {
        this.repository = repository;
    }

    public void setCityId(String id) {
        idInput.setValue(id);
    }

    public void setAppid(String appid) {
        appidInput.setValue(appid);
    }

    public void setTempUnit(String tempUnit) {
        tempUnitInput.setValue(tempUnit);
    }

    public LiveData<WeatherResponse> getCurrentWeather() {
        return repository.getCurrentWeather(idInput.getValue(), appidInput.getValue(), tempUnitInput.getValue());
    }
}
