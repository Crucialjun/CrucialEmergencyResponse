package com.example.crucialemergencyresponse

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.google.android.gms.maps.model.LatLng
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random

object Utils {

    fun getRadomLocation(latitude : Double, longitude : Double, radius : Int = 200) : LatLng{
        val random = Random

        val radiusInDegrees = radius / 111000f

        val u = random.nextDouble()
        val v = random.nextDouble()
        val w = radiusInDegrees * sqrt(u)
        val t = 2 * Math.PI * v
        val x = w * cos(t)
        val y = w * sin(t)

        val new_x = x / cos(Math.toRadians(latitude))

        val newLongitude = new_x + longitude
        val newLatitude = y + latitude

        return LatLng(newLatitude,newLongitude)
    }


    fun getBitmapFromVectorDrawable(context: Context,drawable : Int) : Bitmap {
        val drawable = ContextCompat.getDrawable(context,drawable)

        val bitmap = Bitmap.createBitmap(
            drawable!!.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )

        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        return Bitmap.createScaledBitmap(bitmap, 100, 100, false)
    }

    @BindingAdapter("availability")
    @JvmStatic
    fun availability(view: TextView, numberAvailable: Int) {
        val availableText = "$numberAvailable Available"

        view.text = availableText
    }
}