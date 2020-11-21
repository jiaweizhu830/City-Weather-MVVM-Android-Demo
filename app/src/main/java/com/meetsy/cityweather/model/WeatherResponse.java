package com.meetsy.cityweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class WeatherResponse {
    @SerializedName("main")
    private WeatherMain main;

    @SerializedName("weather")
    private List<Weather> weather;

    @SerializedName("name")
    private String name;

    public WeatherResponse(WeatherMain main, List<Weather> weather, String name) {
        this.main = main;
        this.weather = weather;
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "main=" + main +
                ", weather=" + weather +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherResponse that = (WeatherResponse) o;
        return Objects.equals(main, that.main) &&
                Objects.equals(weather, that.weather) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(main, weather, name);
    }

    public WeatherMain getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getName() {
        return name;
    }
}
