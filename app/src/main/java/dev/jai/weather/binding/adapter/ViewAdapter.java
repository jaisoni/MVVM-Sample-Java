package dev.jai.weather.binding.adapter;

import android.databinding.BindingAdapter;
import android.view.View;

public class ViewAdapter {

    @BindingAdapter("android:visibility")
    public static void setVisibility(View view, boolean isVisible) {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }
}
