package com.example.crucialemergencyresponse

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class OnboardingViewpagerAdapter(val context : Context, val onboardingItems : List<OnBoardingItem>) :
    PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layoutScreen = inflater.inflate(R.layout.on_boarding_item_layout,null)

        val slidingImages = layoutScreen.findViewById<ImageView>(R.id.img_viewpager_image_container)
        val title = layoutScreen.findViewById<TextView>(R.id.txt_viepager_title)
        val description = layoutScreen.findViewById<TextView>(R.id.txt_viewpager_description)

        slidingImages.setImageResource(onboardingItems[position].image)
        title.text = onboardingItems[position].title
        description.text = onboardingItems[position].description

        container.addView(layoutScreen)

        return layoutScreen

    }

    override fun getCount(): Int {
        return onboardingItems.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}