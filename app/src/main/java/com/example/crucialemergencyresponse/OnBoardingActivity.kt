package com.example.crucialemergencyresponse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crucialemergencyresponse.databinding.ActivityMainBinding
import com.example.crucialemergencyresponse.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //attach the viewBinding
        viewBinding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        viewBinding.
    }
}