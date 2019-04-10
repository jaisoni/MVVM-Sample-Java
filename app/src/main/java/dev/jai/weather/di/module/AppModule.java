package dev.jai.weather.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.jai.weather.di.ApplicationContext;
import dev.jai.weather.network.client.RetrofitClient;
import dev.jai.weather.network.repo.WeatherDetailsRepository;
import dev.jai.weather.network.service.WeatherApiService;


@Module(includes = {ViewModelModule.class})
public class AppModule {
    @Provides
    @Singleton
    @ApplicationContext
    public Context provideContext(Application application) {
        return application;
    }


    @Provides
    @Singleton
    public RetrofitClient provideRetrofitClient() {
        return new RetrofitClient();
    }

    @Provides
    @Singleton
    public WeatherApiService provideWeatherApiService(RetrofitClient retrofitClient) {
        return retrofitClient.getRetrofit().create(WeatherApiService.class);
    }

    @Provides
    @Singleton
    public WeatherDetailsRepository provideWeatherDetailsRepository() {
        return new WeatherDetailsRepository(provideRetrofitClient());
    }
}
