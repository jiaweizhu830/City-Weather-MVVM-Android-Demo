package com.meetsy.cityweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.meetsy.cityweather.model.Weather;
import com.meetsy.cityweather.model.WeatherMain;
import com.meetsy.cityweather.model.WeatherResponse;
import com.meetsy.cityweather.repository.WeatherRepository;
import com.meetsy.cityweather.repository.WeatherViewModelFactory;
import com.meetsy.cityweather.ui.HomeViewModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String API_KEY = "815a6e868f9e8ae5ea1a18695d721375";
    private static final String IMPERIAL_TEMP_UNIT = "imperial";
    private HomeViewModel viewModel;
    private Map<String, String> cityNameToIdMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // map city names to city ids
        cityNameToIdMap = new HashMap<>();
        cityNameToIdMap.put("Los Angeles", "5368361");
        cityNameToIdMap.put("San Francisco", "5391959");


        Spinner spinner = findViewById(R.id.cities_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cities_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        WeatherRepository repository = new WeatherRepository();
        viewModel = new ViewModelProvider(this, new WeatherViewModelFactory(repository))
                .get(HomeViewModel.class);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String cityName = parent.getItemAtPosition(position).toString();

        String cityId = cityNameToIdMap.get(cityName);
        if (cityId == null) {
            clearWeatherInfo();
            return;
        }

        viewModel.setCityId(cityId);
        viewModel.setTempUnit(IMPERIAL_TEMP_UNIT);
        viewModel.setAppid(API_KEY);

        viewModel.getCurrentWeather()
                .observe(
                        this,
                        weatherResponse -> {
                            if (weatherResponse != null) {
                                displayWeatherInfo(weatherResponse);
                                Log.d("MainActivity", weatherResponse.toString());
                            }
                        }
                );
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void displayWeatherInfo(WeatherResponse weatherResponse) {
        TextView textCity = findViewById(R.id.textCity);
        TextView textWeather = findViewById(R.id.textWeather);
        TextView textDescription = findViewById(R.id.textDescription);
        TextView textTemp = findViewById(R.id.textTemperature);
        TextView textFeelsLike = findViewById(R.id.textFeelsLike);
        TextView textTempRange = findViewById(R.id.textTemperatureRange);
        TextView textHumidity = findViewById(R.id.textHumidity);
        TextView textPressure = findViewById(R.id.textPressure);

        String mWeather = "";
        String mDescription = "";
        String mTemp = "";
        String mFeelsLike = "";
        String mTempRange = "";
        String mHumidity = "";
        String mPressure = "";

        String mCity = weatherResponse.getName();
        List<Weather> weatherList =  weatherResponse.getWeather();

        if (weatherList != null && weatherList.size() > 0) {
            Weather weather = weatherList.get(0);
            mWeather = weather.getMain();
            mDescription = weather.getDescription();
        }

        WeatherMain weatherMain = weatherResponse.getMain();
        if (weatherMain != null) {
            mTemp = weatherMain.getTemp();
            mFeelsLike = weatherMain.getFeelsLike();
            mTempRange = weatherMain.getTempMin() + " - " + weatherMain.getTempMax();
            mHumidity = weatherMain.getHumidity();
            mPressure = weatherMain.getPressure();
        }

        textCity.setText(mCity);
        textWeather.setText(mWeather);
        textDescription.setText(mDescription);
        textTemp.setText(mTemp);
        textFeelsLike.setText(mFeelsLike);
        textTempRange.setText(mTempRange);
        textHumidity.setText(mHumidity);
        textPressure.setText(mPressure);
    }

    private void clearWeatherInfo() {
        TextView textCity = findViewById(R.id.textCity);
        TextView textWeather = findViewById(R.id.textWeather);
        TextView textDescription = findViewById(R.id.textDescription);
        TextView textTemp = findViewById(R.id.textTemperature);
        TextView textFeelsLike = findViewById(R.id.textFeelsLike);
        TextView textTempRange = findViewById(R.id.textTemperatureRange);
        TextView textHumidity = findViewById(R.id.textHumidity);
        TextView textPressure = findViewById(R.id.textPressure);

        String mCity = "";
        String mWeather = "";
        String mDescription = "";
        String mTemp = "";
        String mFeelsLike = "";
        String mTempRange = "";
        String mHumidity = "";
        String mPressure = "";

        textCity.setText(mCity);
        textWeather.setText(mWeather);
        textDescription.setText(mDescription);
        textTemp.setText(mTemp);
        textFeelsLike.setText(mFeelsLike);
        textTempRange.setText(mTempRange);
        textHumidity.setText(mHumidity);
        textPressure.setText(mPressure);
    }
}