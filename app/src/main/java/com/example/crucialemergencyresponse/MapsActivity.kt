package com.example.crucialemergencyresponse

import android.Manifest
import android.content.pm.PackageManager
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    lateinit var locationRequest: LocationRequest
    lateinit var locationCallback: LocationCallback
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    var mapLoad = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapLoad = intent.getIntExtra(MAP_LOAD,0)

        mapFragment.getMapAsync(this)
    }

    private fun init() {
        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.fastestInterval = 3000
        locationRequest.interval = 5000
        locationRequest.smallestDisplacement = 10f

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                super.onLocationResult(locationResult)

                val newPos = LatLng(locationResult!!.lastLocation.latitude
                    ,locationResult.lastLocation.longitude)

                setMarkers(newPos)

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newPos,18f))


            }
        }

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
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
        fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper())

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        init()

        Dexter.withContext(this)
            .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            .withListener(object : PermissionListener {

                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                    mMap.isMyLocationEnabled = true
                    mMap.uiSettings.isMyLocationButtonEnabled = true
                    mMap.setOnMyLocationButtonClickListener {
                        if (ActivityCompat.checkSelfPermission(
                                this@MapsActivity,
                                Manifest.permission.ACCESS_FINE_LOCATION
                            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                                this@MapsActivity,
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
                            return@setOnMyLocationButtonClickListener  false
                        }
                        fusedLocationProviderClient.lastLocation.addOnFailureListener {

                        }.addOnSuccessListener {
                            val userLatlng = LatLng(it.latitude, it.longitude)

                            setMarkers(userLatlng)



                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userLatlng, 18f))
                        }

                        true

                    }



                }

                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                    TODO("Not yet implemented")
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: PermissionRequest?,
                    p1: PermissionToken?
                ) {
                    TODO("Not yet implemented")
                }
            }).check()



        try{
            val success = googleMap
                .setMapStyle(
                    MapStyleOptions
                    .loadRawResourceStyle(this,R.raw.uber_maps_style))
            if(!success){
                Log.e("ERROR", "Style parsing Error" )
            }
        }catch (e: Resources.NotFoundException){
            Log.e("Error", e.message.toString())
        }

    }

    private fun setMarkers(newPos: LatLng) {
        val markeOption = MarkerOptions()

        mMap.clear()

        when(mapLoad){
            MECHANICS_ID -> {
                val mechanics = DataManager.mechanics
                for (mechanic in mechanics) {
                    mechanic.location = Utils.getRadomLocation(newPos.latitude, newPos.longitude)
                    markeOption.position(mechanic.location!!).title(mechanic.name).icon(
                        BitmapDescriptorFactory.fromBitmap(
                            Utils.getBitmapFromVectorDrawable(
                                this,
                                R.drawable.ic_mechanics_illustration
                            )
                        )
                    )
                    mMap.addMarker(markeOption).showInfoWindow()

                }
            }
            TOW_TRUCKS_ID -> {
                val towTrucks = DataManager.towTrucks
                for (towTruck in towTrucks) {
                    towTruck.location = Utils.getRadomLocation(newPos.latitude, newPos.longitude)
                    markeOption.position(towTruck.location!!).title(towTruck.name).icon(
                        BitmapDescriptorFactory.fromBitmap(
                            Utils.getBitmapFromVectorDrawable(
                                this,
                                R.drawable.ic_tow_truck
                            )
                        )
                    )
                    mMap.addMarker(markeOption).showInfoWindow()

                }
            }
            FUEL_STATIONS_ID -> {
                val fuelStations = DataManager.fillingStations
                for (fuelStation in fuelStations) {
                    fuelStation.location = Utils.getRadomLocation(newPos.latitude, newPos.longitude)
                    markeOption.position(fuelStation.location!!).title(fuelStation.name).icon(
                        BitmapDescriptorFactory.fromBitmap(
                            Utils.getBitmapFromVectorDrawable(
                                this,
                                R.drawable.ic_fuel_stations
                            )
                        )
                    )
                    mMap.addMarker(markeOption).showInfoWindow()

                }
            }
            AMBULANCES_ID -> {
                val ambulances = DataManager.ambulances
                for (ambulance in ambulances) {
                    ambulance.location = Utils.getRadomLocation(newPos.latitude, newPos.longitude)
                    markeOption.position(ambulance.location!!).title(ambulance.name).icon(
                        BitmapDescriptorFactory.fromBitmap(
                            Utils.getBitmapFromVectorDrawable(
                                this,
                                R.drawable.ic_ambulance
                            )
                        )
                    )
                    mMap.addMarker(markeOption).showInfoWindow()

                }
            }
        }

    }

    override fun onDestroy() {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback)

        super.onDestroy()
    }
}