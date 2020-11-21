package com.meetsy.cityweather.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.meetsy.cityweather.ui.HomeViewModel;

public class WeatherViewModelFactory implements ViewModelProvider.Factory {

    private final WeatherRepository repository;

    public WeatherViewModelFactory(WeatherRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(repository);
        } else {
            throw new IllegalStateException("This is an unknown ViewModel");
        }
    }
}
