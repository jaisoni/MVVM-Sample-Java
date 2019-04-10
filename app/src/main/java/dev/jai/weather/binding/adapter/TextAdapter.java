package dev.jai.weather.binding.adapter;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TextAdapter {
    @BindingAdapter("app:text")
    public static void setText(TextView textView, long timeInMillis) {
        textView.setText(new Date(timeInMillis * 1000L).toString());
    }

    @BindingAdapter({"app:date", "app:format"})
    public static void setText(TextView textView, long timeInMillis, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        textView.setText(format.format(new Date(timeInMillis * 1000L)));
    }
}
