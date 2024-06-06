package com.example.getuserlocationinandroidjc

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.xml.sax.Locator

class LocationViewModel:ViewModel() {
    private val _location = mutableStateOf<LocationData?>(null)

    val location : State<LocationData?> = _location

    fun updateLocation(newLocation: LocationData){
        _location.value = newLocation
    }

}