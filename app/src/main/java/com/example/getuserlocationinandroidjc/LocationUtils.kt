package com.example.getuserlocationinandroidjc

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


// this class is responsible for checking whether user has granted permission or not
class LocationUtils(private val context: Context) {

    private val _location = MutableLiveData<Location?>()
    val location: LiveData<Location?> = _location

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    fun hasPermissionGranted(context: Context): Boolean {
        return ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    fun updateLocation() {
        if (hasPermissionGranted(context)) {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                _location.value = location
            }
        }
    }
}