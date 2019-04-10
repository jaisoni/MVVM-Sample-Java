package dev.jai.weather.model;

import java.util.List;

public class Weather {
    public double latitude;
    public double longitude;
    public String timezone;
    public Currently currently;
    public Minutely minutely;
    public Hourly hourly;
    public Daily daily;
    public List<Alert> alerts;
    public Flags flags;
    public float offset;

    @Override
    public String toString() {
        return "Weather{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", timezone='" + timezone + '\'' +
                ", currently=" + currently +
                ", minutely=" + minutely +
                ", hourly=" + hourly +
                ", daily=" + daily +
                ", alerts=" + alerts +
                ", flags=" + flags +
                ", offset=" + offset +
                '}';
    }
}
