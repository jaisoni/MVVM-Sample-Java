package dev.jai.weather.binding.adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import dev.jai.weather.utils.ImageFactory;

public class ImageAdapter {

    @BindingAdapter("image_src")
    public static void setImageIconSrc(ImageView view, String code) {
        int res = ImageFactory.getIconRes(code);
        view.setImageResource(res);
    }
}
