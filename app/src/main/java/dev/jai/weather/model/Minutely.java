package dev.jai.weather.model;

import java.util.List;

public class Minutely {
    public String summary;
    public String icon;
    public List<Data> dataList;

    public static class Data {
        public String time;
        public int precipIntensity;
        public int precipProbability;

    }
}
