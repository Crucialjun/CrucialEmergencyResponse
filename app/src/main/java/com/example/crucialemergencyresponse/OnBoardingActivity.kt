package com.example.crucialemergencyresponse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crucialemergencyresponse.databinding.ActivityMainBinding
import com.example.crucialemergencyresponse.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityOnBoardingBinding

    var onBoardingItems : MutableList<OnBoardingItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //attach the viewBinding
        viewBinding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)




        setOnBoardingItems()

    }

    private fun setOnBoardingItems(){
        val missionStatement =
            " Our Mission as Crucial Emergency Response is giving business individuals opportunities with strength,energy and poise"
        val visionStatement =
            " Our Mission as Crucial Emergency Response is to bring out the strength and authority in business individuals by giving them opportunity "
        val onboardingMechanics = OnBoardingItem()
        val onboardingTowtrucks = OnBoardingItem()
        val onboardingFuelstation = OnBoardingItem()
        val onboardingAmbulances = OnBoardingItem()


        onboardingMechanics.title = "Mechanics Available"
        onboardingMechanics.description = "A large number of mchanics available at your service wherever you might be in the country"
        onboardingMechanics.image = R.drawable.ic_mechanics_illustration

        onboardingTowtrucks.title = "Mechanics Available"
        onboardingTowtrucks.description = "A large number of mchanics available at your service wherever you might be in the country"
        onboardingTowtrucks.image = R.drawable.ic_tow_truck

        onboardingFuelstation.title = "Mechanics Available"
        onboardingFuelstation.description = "A large number of mchanics available at your service wherever you might be in the country"
        onboardingFuelstation.image = R.drawable.ic_fuel_stations

        onboardingAmbulances.title = "Mechanics Available"
        onboardingAmbulances.description = "A large number of mchanics available at your service wherever you might be in the country"
        onboardingAmbulances.image = R.drawable.ic_ambulance

        onBoardingItems.add(onboardingMechanics)
        onBoardingItems.add(onboardingTowtrucks)
        onBoardingItems.add(onboardingFuelstation)
        onBoardingItems.add(onboardingAmbulances)







    }

}