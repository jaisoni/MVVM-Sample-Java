package dev.jai.weather.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dev.jai.weather.app.WeatherApplication;
import dev.jai.weather.di.module.ActivityModule;
import dev.jai.weather.di.module.AppModule;


@Singleton
@Component(modules = {AppModule.class, ActivityModule.class, AndroidInjectionModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(WeatherApplication app);
}
