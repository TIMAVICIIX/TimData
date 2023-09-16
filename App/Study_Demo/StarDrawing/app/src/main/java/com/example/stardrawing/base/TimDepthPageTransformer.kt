package com.example.stardrawing.base

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

class TimDepthPageTransformer : ViewPager.PageTransformer {

    private val MIN_SCALE = 0.75f

    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width

        if (position < -1) {
            page.alpha = 0f
        } else if (position <= 0) {
            page.alpha = 1f
            page.translationX = 0f
            page.scaleX = 1f
            page.scaleY = 1f
        } else if (position <= 1) {
            page.alpha = 1 - position
            page.translationX = pageWidth * -position

            val scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - abs(position))
            page.scaleX = scaleFactor
            page.scaleY = scaleFactor
        } else {
            page.alpha = 0f
        }
    }

}