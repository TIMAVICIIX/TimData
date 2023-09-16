package com.example.stardrawing.tool.activitytool

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager

@Suppress("DEPRECATION")
class StatusBar(activity: Activity) {

    private val activity: Activity

    init {
        this.activity = activity
    }

    fun setColor(tempColor: Int) {
        if (Build.VERSION.SDK_INT >= 21) {
            val view = activity.window.decorView

            view.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE

            activity.window.statusBarColor = activity.resources.getColor(tempColor)
        }
    }

    fun hideTitle() {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

    fun hideAll() {
        if ((Build.VERSION.SDK_INT > 11) && (Build.VERSION.SDK_INT < 19)) {
            val v = activity.window.decorView
            v.systemUiVisibility = View.GONE
        } else if (Build.VERSION.SDK_INT >= 19) {
            val decor = activity.window.decorView
            decor.systemUiVisibility =  View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
             View.SYSTEM_UI_FLAG_FULLSCREEN or
             View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
             View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
             View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }

    fun setTextColor(isDarkBackground: Boolean) {
        val decor = activity.window.decorView
        if (isDarkBackground) {
            decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        } else {
            decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

}