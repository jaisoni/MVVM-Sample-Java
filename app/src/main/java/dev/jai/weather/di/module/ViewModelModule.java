package dev.jai.weather.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;


import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dev.jai.weather.di.ViewModelFactory;
import dev.jai.weather.di.ViewModelKey;
import dev.jai.weather.ui.weather.WeatherDetailViewModel;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(WeatherDetailViewModel.class)
    abstract ViewModel bindWeatherDetailViewModel(WeatherDetailViewModel weatherDetailViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
