package dev.jai.weather.ui.weather;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import dev.jai.weather.R;
import dev.jai.weather.databinding.ActivityWeatherDetailsBinding;
import dev.jai.weather.ui.base.BaseActivity;
import dev.jai.weather.utils.PermissionHandler;

import static dev.jai.weather.utils.PermissionHandler.REQUEST_COARSE_LOCATION;

public class WeatherDetailsActivity extends BaseActivity<ActivityWeatherDetailsBinding, WeatherDetailViewModel> {
    private final int REQUEST_CODE_LOCATION_PICKER = 4003;
    private FusedLocationProviderClient fusedLocationClient;
    private Geocoder mGeoCoder;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_weather_details;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = provideViewModel(this, WeatherDetailViewModel.class);
        mBinding.setVm(mViewModel);
        setSupportActionBar(mBinding.toolbar);
        init();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE_LOCATION_PICKER) {

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_COARSE_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastKnownLocation();
            } else {
                Toast.makeText(this, getString(R.string.toast_location_permision_denied),
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    private void init() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mGeoCoder = new Geocoder(this, Locale.getDefault());
        enableLocation();
    }

    private void enableLocation() {
        if (!PermissionHandler.hasCoarseLocationPermission(this)) {
            PermissionHandler.requestPermissions(this, REQUEST_COARSE_LOCATION,
                    getString(R.string.permission_msg_location),
                    Manifest.permission.ACCESS_COARSE_LOCATION);
        } else {
            getLastKnownLocation();
        }
    }

    private void getLastKnownLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        updateWeatherInfo(location);
                        try {
                            List<Address> address = mGeoCoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                            Log.e("WeatherDetailsActivity","getLastKnownLocation| address "+address);
                            if(!address.isEmpty()){
                                mViewModel.setLocation(address.get(0).getLocality());
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void updateWeatherInfo(Location location) {
        mViewModel.setmLat(location.getLatitude());
        mViewModel.setmLng(location.getLongitude());
        mViewModel.updateWeatherInfo();
    }

}
