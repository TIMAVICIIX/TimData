package com.example.vacationventurepe.basetools

import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setEnterAnimation()
        super.onCreate(savedInstanceState)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finishWithAnimation(this)
            finish()
            return true
        } else {
            return super.onKeyDown(keyCode, event)
        }

    }

    private fun setEnterAnimation() {

        val animationType = intent.extras?.getString("animationType")

        when (animationType) {

            Base.ANIMATION_FADE -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    overrideActivityTransition(
                        OVERRIDE_TRANSITION_OPEN,
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                    )
                }
            }

            Base.ANIMATION_SLIDE -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    overrideActivityTransition(
                        OVERRIDE_TRANSITION_OPEN,
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right
                    )
                }
            }
        }

    }

    fun finishWithAnimation(localActivity:BaseActivity){

        val animationType = localActivity.intent.extras?.getString("animationType")

        when (animationType) {

            Base.ANIMATION_FADE -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    overrideActivityTransition(
                        OVERRIDE_TRANSITION_CLOSE,
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                    )
                }
            }

            Base.ANIMATION_SLIDE -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    overrideActivityTransition(
                        OVERRIDE_TRANSITION_CLOSE,
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right
                    )
                }
            }
        }

        localActivity.finish()

    }

}