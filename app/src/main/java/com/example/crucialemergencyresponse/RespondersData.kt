package com.example.crucialemergencyresponse

import com.google.android.gms.maps.model.LatLng

data class MechanicInfo(var name : String, var phone : String, var location : LatLng? = null) {

}

data class TowTruckInfo(var name : String, var phone : String, var location : LatLng? = null) {

}
data class FillingStationInfo(var name : String, var phone : String, var location : LatLng? = null) {

}
data class AmbulanceInfo(var name : String, var phone : String, var location : LatLng? = null) {

}

data class InstructionsInfo(var title : String, var text : String) {

}