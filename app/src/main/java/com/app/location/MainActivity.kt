package com.app.location

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.lang.Math.log

private lateinit  var  fusedLocationClient: FusedLocationProviderClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var getButton : Button = findViewById(R.id.get_button);
        var lat : TextView = findViewById(R.id.lat);
        var longi : TextView = findViewById(R.id.longi);
        var viewModel = ViewModelProviders.of(this).get(ViewModel::class.java);
        var location: LiveData<Model> = viewModel.getInitialLoc();
        location.observe(this, Observer {

            lat.setText(it.getLat());
            longi.setText(it.getLong());

        })


        getButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                viewModel.getLocation(applicationContext );
            }
        });


    }
}