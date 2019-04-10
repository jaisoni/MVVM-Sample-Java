package dev.jai.weather.model;

import java.util.List;

public class Daily {
    public String summary;
    public String icon;
    public List<Data> data;

    public static class Data {
        public long time;
        public String summary;
        public String icon;
        public long sunriseTime;
        public long sunsetTime;
        public float moonPhase;
        public float precipIntensity;
        public float precipIntensityMax;
        public long precipIntensityMaxTime;
        public float precipProbability;
        public String precipType;
        public float temperatureHigh;
        public long temperatureHighTime;
        public float temperatureLow;
        public long temperatureLowTime;
        public float apparentTemperatureHigh;
        public long apparentTemperatureHighTime;
        public float apparentTemperatureLow;
        public long apparentTemperatureLowTime;
        public float dewPoint;
        public float humidity;
        public float pressure;
        public float windSpeed;
        public float windGust;
        public long windGustTime;
        public int windBearing;
        public float cloudCover;
        public int uvIndex;
        public long uvIndexTime;
        public float visibility;
        public float ozone;
        public float temperatureMin;
        public long temperatureMinTime;
        public float temperatureMax;
        public long temperatureMaxTime;
        public float apparentTemperatureMin;
        public long apparentTemperatureMinTime;
        public float apparentTemperatureMax;
        public long apparentTemperatureMaxTime;
    }
}
