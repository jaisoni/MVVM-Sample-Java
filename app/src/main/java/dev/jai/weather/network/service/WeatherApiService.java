package dev.jai.weather.network.service;

import dev.jai.weather.model.Weather;
import dev.jai.weather.network.ApiConstant;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherApiService {

    @GET(ApiConstant.END_POINT_FORECAST)
    public Observable<Weather> getWeatherInfo(
            @Path("apikey") String apiKey, @Path("lat") double lat, @Path("lng") double lng);
}
