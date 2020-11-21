package com.meetsy.cityweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Weather {
    @SerializedName("main")
    private String main;

    @SerializedName("description")
    private String description;

    public Weather(String weatherMain, String description) {
        this.main = weatherMain;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "main='" + main + '\'' +
                "description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(main, weather.main) &&
                Objects.equals(description, weather.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(main, description);
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }
}
