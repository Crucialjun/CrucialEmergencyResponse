package com.example.crucialemergencyresponse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {
    private val _mechanics: MutableLiveData<Int> = MutableLiveData()
    val mechanics: LiveData<Int> get() = _mechanics

    private val _towTrucks: MutableLiveData<Int> = MutableLiveData()
    val towTrucks: LiveData<Int> get() = _towTrucks

    private val _fuelStations: MutableLiveData<Int> = MutableLiveData()
    val fuelstations: LiveData<Int> get() = _fuelStations

    private val _ambulances: MutableLiveData<Int> = MutableLiveData()
    val ambulances: LiveData<Int> get() = _ambulances

    init {
        _mechanics.value = DataManager.mechanics.size
        _towTrucks.value = DataManager.towTrucks.size
        _fuelStations.value = DataManager.fillingStations.size
        _ambulances.value = DataManager.ambulances.size
    }

}