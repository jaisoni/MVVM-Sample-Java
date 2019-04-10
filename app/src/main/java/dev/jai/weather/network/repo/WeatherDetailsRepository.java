package dev.jai.weather.network.repo;


import javax.inject.Inject;

import dev.jai.weather.BuildConfig;
import dev.jai.weather.model.Weather;
import dev.jai.weather.network.client.RetrofitClient;
import dev.jai.weather.network.service.WeatherApiService;
import io.reactivex.Observable;

public class WeatherDetailsRepository {
    @Inject
    WeatherApiService apiService;

    @Inject
    public WeatherDetailsRepository(RetrofitClient client) {
        apiService = client.getRetrofit().create(WeatherApiService.class);
    }

    public Observable<Weather> getWeatherInfo(double lat, double lng) {
        return apiService.getWeatherInfo(BuildConfig.API_KEY, lat, lng);
    }
}
