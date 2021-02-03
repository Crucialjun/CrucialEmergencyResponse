package com.example.crucialemergencyresponse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.viewpager.widget.ViewPager
import com.example.crucialemergencyresponse.databinding.ActivityMainBinding
import com.example.crucialemergencyresponse.databinding.ActivityOnBoardingBinding
import com.google.android.material.tabs.TabLayout

class OnBoardingActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityOnBoardingBinding

    var onBoardingItems : MutableList<OnBoardingItem> = ArrayList()
    private lateinit var onboardingGetStartedButtonAnimation: Animation
    var position = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //attach the viewBinding
        viewBinding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        //initialize button animation
        onboardingGetStartedButtonAnimation =
            AnimationUtils.loadAnimation(applicationContext,R.anim.button_bounce)


        //Add items to the onboarding screens
        setOnBoardingItems()

        viewBinding.viewpagerOnboarding.apply {
            adapter = OnboardingViewpagerAdapter(context,onBoardingItems)
        }

        //setup indicators to show the current page
        setupOnboardingIndicators(viewBinding.viewpagerOnboarding)




        viewBinding.layoutOnboardingIndicator.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab?.position == onBoardingItems.size -1){
                    loadLastScreen()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }


        })

        //Skip the onboarding screen on Skip button pressed
        viewBinding.btnOnboardingSkip.setOnClickListener {
            openNextScreen()
        }

        viewBinding.btnOnboardingGetStarted.setOnClickListener { openNextScreen() }

        viewBinding.btnOnboardingNext.setOnClickListener {
            position = viewBinding.viewpagerOnboarding.currentItem

            if (position < onBoardingItems.size) {
                position++
                viewBinding.viewpagerOnboarding.currentItem = position
            }

            if (position == onBoardingItems.size - 1) {
                loadLastScreen()
            }
        }

        viewBinding.btnOnboardingPrevious.setOnClickListener {
            position = viewBinding.viewpagerOnboarding.currentItem

            if (position < onBoardingItems.size) {
                position--
                viewBinding.viewpagerOnboarding.currentItem = position
            }
        }


    }

    private fun openNextScreen() {
        val intent = Intent(this@OnBoardingActivity, LoginSignupActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun loadLastScreen() {
        viewBinding.btnOnboardingGetStarted.visibility = View.VISIBLE
        viewBinding.btnOnboardingGetStarted.animation = onboardingGetStartedButtonAnimation
        viewBinding.btnOnboardingSkip.visibility = View.GONE
        viewBinding.btnOnboardingPrevious.visibility = View.GONE
        viewBinding.btnOnboardingNext.visibility = View.GONE
    }

    private fun setupOnboardingIndicators(viewpagerOnboarding: ViewPager) {
        viewBinding.layoutOnboardingIndicator.setupWithViewPager(viewpagerOnboarding)
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


        onboardingMechanics.title = getString(R.string.onboarding_mechanic_title)
        onboardingMechanics.description = getString(R.string.onboarding_mechanic_description)
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