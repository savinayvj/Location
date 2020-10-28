package com.app.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class ViewModel : ViewModel() {
    private val currlocation = Model("0","0");
    private var locationLiveData = MutableLiveData<Model>();

    open fun getInitialLoc():MutableLiveData<Model>{
        locationLiveData.value=currlocation;
        return locationLiveData;
    }


    open fun getLocation(con:Context){
        var  fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(con);
        if (ActivityCompat.checkSelfPermission(
                con,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                con,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->

                if (location != null) {
                    currlocation.setLat(location.latitude.toString());
                    currlocation.setLong(location.longitude.toString());
                };
                locationLiveData.value = currlocation;
            }

    }

}