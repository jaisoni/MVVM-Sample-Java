package dev.jai.weather.model;

import java.util.List;

public class Hourly {
    public String summary;
    public String icon;
    public List<Data> data;

    public static class Data {
        public String time;
        public String summary;
        public String icon;
        public int precipIntensity;
        public int precipProbability;
        public float temperature;
        public float apparentTemperature;
        public float dewPoint;
        public float humidity;
        public float pressure;
        public float windSpeed;
        public float windGust;
        public int windBearing;
        public float cloudCover;
        public int uvIndex;
        public float visibility;
        public float ozone;

    }
}
