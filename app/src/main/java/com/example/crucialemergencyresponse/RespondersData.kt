package com.example.crucialemergencyresponse

import com.google.android.gms.maps.model.LatLng

data class MechanicInfo(var name : String, var phone : String, var location : LatLng? = null,var id : Int=0) {

}

data class TowTruckInfo(var name : String, var phone : String, var location : LatLng? = null,var id : Int=0) {

}
data class FillingStationInfo(var name : String, var phone : String, var location : LatLng? = null,var id : Int =0) {

}
data class AmbulanceInfo(var name : String, var phone : String, var location : LatLng? = null,var id : Int =0 ) {

}

data class InstructionsInfo(var title : String, var text : String) {

}