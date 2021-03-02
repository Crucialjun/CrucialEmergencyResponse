package com.example.crucialemergencyresponse

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navArgs
import com.example.crucialemergencyresponse.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {



    lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Make the Activity full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        binding = ActivityMainBinding.inflate(layoutInflater)

        val viewModel: DashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        binding.apply {
            this.lifecycleOwner = this@MainActivity
            this.viewModel = viewModel
        }
        setContentView(binding.root)


        binding.txtDashboardUsername.text = "UserName"

        binding.cardviewMechanics.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra(MAP_LOAD, MECHANICS_ID)
            startActivity(intent)
        }

        binding.cardviewTowtrucks.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra(MAP_LOAD, TOW_TRUCKS_ID)
            startActivity(intent)
        }

        binding.cardViewFuelStations.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra(MAP_LOAD, FUEL_STATIONS_ID)
            startActivity(intent)
        }
        binding.cardViewAmbulances.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra(MAP_LOAD, AMBULANCES_ID)
            startActivity(intent)
        }

        binding.cardviewInstructions.setOnClickListener{
            val intent = Intent(this, InstructionsActivity::class.java)
            startActivity(intent)
        }



    }
}