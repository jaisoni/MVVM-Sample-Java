package dev.jai.weather.ui.weather;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import javax.inject.Inject;

import dev.jai.weather.model.Weather;
import dev.jai.weather.network.repo.WeatherDetailsRepository;
import dev.jai.weather.ui.base.BaseViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

public class WeatherDetailViewModel extends BaseViewModel {
    private final ObservableField<Weather> weather = new ObservableField<>();
    private final ObservableField<String> location = new ObservableField<>();
    private final ObservableBoolean showProgress = new ObservableBoolean(false);
    private WeatherDetailsRepository weatherDetailsRepository;
    private WeatherDetailsAdapter adapter;

    private double mLat = 0.0;
    private double mLng = 0.0;

    @Inject
    public WeatherDetailViewModel(WeatherDetailsRepository weatherDetailsRepository) {
        this.weatherDetailsRepository = weatherDetailsRepository;
        adapter = new WeatherDetailsAdapter();
    }

    public double getmLat() {
        return mLat;
    }

    public void setmLat(double mLat) {
        this.mLat = mLat;
    }

    public double getmLng() {
        return mLng;
    }

    public void setmLng(double mLng) {
        this.mLng = mLng;
    }

    public void updateWeatherInfo() {
        showProgress.set(true);
        notifyChange();
        compositeDisposable.add(weatherDetailsRepository.getWeatherInfo(mLat, mLng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onWeatherInfoUpdateSuccess, this::handleError));
    }

    public void onWeatherInfoUpdateSuccess(Weather weather) {
        showProgress.set(false);
        this.weather.set(weather);
        this.adapter.addItems(weather.daily.data);
        notifyChange();
    }

    public void handleError(Throwable throwable) {
        showProgress.set(false);
        throwable.printStackTrace();
    }

    public void setLocation(String location) {
        this.location.set(location);
        notifyChange();
    }

    public String getLocation() {
        return location.get();
    }

    public Weather getWeather() {
        return weather.get();
    }

    public boolean getShowProgress() {
        return showProgress.get();
    }

    public WeatherDetailsAdapter getAdapter() {
        return adapter;
    }
}
