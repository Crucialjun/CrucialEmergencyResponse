package com.example.crucialemergencyresponse

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val disposable = Completable.timer(
            5,
            TimeUnit.SECONDS,
            AndroidSchedulers.mainThread()
        ).subscribe {

            val pref = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            val editor = pref.edit()
            editor.putBoolean("isfirsttime", false)
            editor.apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()


        }
    }


}