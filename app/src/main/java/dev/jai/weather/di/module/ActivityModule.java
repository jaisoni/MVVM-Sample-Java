package dev.jai.weather.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dev.jai.weather.ui.weather.WeatherDetailsActivity;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector()
    abstract WeatherDetailsActivity bindWeatherDetailsActivity();
}
