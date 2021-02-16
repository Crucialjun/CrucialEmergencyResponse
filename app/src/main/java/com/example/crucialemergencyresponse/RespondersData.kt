package com.example.crucialemergencyresponse

import com.google.android.gms.maps.model.LatLng

data class MechanicInfo(var name : String, var phone : String, var location : LatLng? = null) {

}

data class InstructionsInfo(var title : String, var text : String) {

}