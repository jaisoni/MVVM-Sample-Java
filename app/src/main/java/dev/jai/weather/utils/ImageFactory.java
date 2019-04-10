package dev.jai.weather.utils;

import dev.jai.weather.R;

public class ImageFactory {
    public static int getIconRes(String state) {
        if (state == null) {
            return R.drawable.ic_clear_day;
        }
        switch (state) {
            case "clear-day":
                return R.drawable.ic_clear_day;
            case "clear-night":
                return R.drawable.ic_clear_night;
            case "rain":
                return R.drawable.ic_rain;
            case "snow":
                return R.drawable.ic_snowy;
            case "sleet":
                return R.drawable.ic_sleet;
            case "wind":
                return R.drawable.ic_wi_windy;
            case "fog":
                return R.drawable.ic_fog;
            case "cloudy":
                return R.drawable.ic_cloudy;
            case "partly-cloudy-day":
                return R.drawable.ic_cloudy_day;
            case "partly-cloudy-night":
                return R.drawable.ic_cloudy_night;
            case "hail":
                return R.drawable.ic_hail;
            case "thunderstorm":
                return R.drawable.ic_thunderstrom;
            case "tornado":
                return R.drawable.ic_tornado;
            default:
                return R.drawable.ic_clear_day;
        }
    }


}
