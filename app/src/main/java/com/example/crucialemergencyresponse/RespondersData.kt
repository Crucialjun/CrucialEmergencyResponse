package com.example.crucialemergencyresponse

import com.google.android.gms.maps.model.LatLng

data class MechanicInfo(val name : String, val phone : String, val location : LatLng) {

}

data class InstructionsInfo(val title : String, val text : String) {

}