package com.meetsy.cityweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class WeatherMain {
    @SerializedName("temp")
    private String temp;

    @SerializedName("feels_like")
    private String feelsLike;

    @SerializedName("temp_min")
    private String tempMin;

    @SerializedName("temp_max")
    private String tempMax;

    @SerializedName("pressure")
    private String pressure;

    @SerializedName("humidity")
    private String humidity;

    public WeatherMain(String temp, String feelsLike, String tempMin, String tempMax, String pressure, String humidity) {
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                ", temp=" + temp +
                ", feelsLike=" + feelsLike +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherMain that = (WeatherMain) o;
        return Objects.equals(temp, that.temp) &&
                Objects.equals(feelsLike, that.feelsLike) &&
                Objects.equals(tempMin, that.tempMin) &&
                Objects.equals(tempMax, that.tempMax) &&
                Objects.equals(pressure, that.pressure) &&
                Objects.equals(humidity, that.humidity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temp, feelsLike, tempMin, tempMax, pressure, humidity);
    }

    public String getTemp() {
        return temp;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public String getTempMin() {
        return tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }
}
