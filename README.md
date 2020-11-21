# City Weather MVVM Android Demo

## Description
This demo app allows a user to select a city from a drop-down menu and obtain weather information of that city. <br> <br>
Technology used: <br>
- **Retrofit**: fetch city weather data from OpenWeather API

App Architecture: MVVM <br>
- ViewModel
- Repository
- Model
- Network


## OpenWeather API
Raw JSON data fetched from [OpenWeather API](https://openweathermap.org/current) (bolded fields are kept and displayed to user) <br>
<pre>
{
    "coord": {
        "lon": -122.42,
        "lat": 37.77
    },
    "weather": [{
        "id": 800,
        <b>"main"</b>: "Clear",
        <b>"description"</b>: "clear sky",
        "icon": "01n"
    }],
    "base": "stations",
    "main": {
        <b>"temp"</b>: 284.83,
        <b>"feels_like"</b>: 281.86,
        <b>"temp_min"</b>: 283.15,
        <b>"temp_max"</b>: 285.93,
        <b>"pressure"</b>: 1023,
        <b>"humidity"</b>: 62
    },
    "visibility": 10000,
    "wind": {
        "speed": 2.53,
        "deg": 24
    },
    "clouds": {
        "all": 1
    },
    "dt": 1605934356,
    "sys": {
        "type": 1,
        "id": 5817,
        "country": "US",
        "sunrise": 1605884162,
        "sunset": 1605920115
    },
    "timezone": -28800,
    "id": 5391959,
    <b>"name"</b>: "San Francisco",
    "cod": 200
}
</pre>


OpenWeather API query parameter
- id: "city id"
  - [OpenWeather](https://openweathermap.org/current#cityid) recommends to call API by city ID (from city.list.json.gz) to get unambiguous result.
- appid: "API Key"
- units: "imperial"
  - Temperatures are in Fahrenheit degree
---

## Demo
[App Demo Video](https://github.com/jiaweizhu830/City-Weather-MVVM-Android-Demo/tree/master/videos) <br>
