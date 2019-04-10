package dev.jai.weather.model;

import com.google.gson.annotations.SerializedName;

public class Flags {
    public String [] sources;
    @SerializedName("nearest-station")
    public String nearestStation;
    public String units;

}
