package dev.jai.weather.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;

import dev.jai.weather.R;
import dev.jai.weather.ui.weather.WeatherDetailsActivity;

public class PermissionHandler {
    private static final int REQUEST_SETTINGS = 444;

    // permission request code for location
    public static final int REQUEST_BOTH_LOCATION_PERMISSION = 331;
    public static final int REQUEST_COARSE_LOCATION = 332;
    public static final int REQUEST_FINE_LOCATION = 333;


    public static boolean hasCoarseLocationPermission(Context context) {
        return checkPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION);
    }

    private static boolean checkPermission(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestPermissions(Activity activity, int permissionId, String message, String permission) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
            showSettingsSnackbar(activity, message);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{permission}, permissionId);
        }
    }

    private static void showSettingsSnackbar(Activity activity, String message) {
        if(activity!=null){
            View view = activity.findViewById(android.R.id.content);
            Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction(activity.getString(R.string.settings), v -> {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                    intent.setData(Uri.parse("package:" + activity.getPackageName()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                    activity.startActivityForResult(intent, REQUEST_SETTINGS);
                })
            .setActionTextColor(ContextCompat.getColor(activity, R.color.colorPrimary))
                    .show();
        }
    }
}
