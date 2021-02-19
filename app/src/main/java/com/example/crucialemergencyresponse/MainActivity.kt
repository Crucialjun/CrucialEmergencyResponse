package com.example.crucialemergencyresponse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.navigation.navArgs
import com.example.crucialemergencyresponse.databinding.ActivityMainBinding
import com.example.crucialemergencyresponse.databinding.FragmentLoginBinding

private val MainActivity.intent: Intent
    get() = Intent(this, InstructionsActivity::class.java)

class MainActivity : AppCompatActivity() {

    private val args : MainActivityArgs by navArgs()

    lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Make the Activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.txtDashboardUsername.text = args.username

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