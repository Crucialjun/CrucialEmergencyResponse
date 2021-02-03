package com.example.crucialemergencyresponse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.navigation.navArgs
import com.example.crucialemergencyresponse.databinding.ActivityMainBinding
import com.example.crucialemergencyresponse.databinding.FragmentLoginBinding

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

        binding.cardviewMechanics.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                TODO("Not yet implemented")
            }

        })


    }
}