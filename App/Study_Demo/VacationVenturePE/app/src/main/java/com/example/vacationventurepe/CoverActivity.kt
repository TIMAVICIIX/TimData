package com.example.vacationventurepe

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import com.example.vacationventurepe.basetools.Base
import com.example.vacationventurepe.basetools.BaseActivity
import com.example.vacationventurepe.basetools.RoboActivity.roboStartActivity
import java.util.Timer
import java.util.TimerTask

class CoverActivity : BaseActivity() {

    private lateinit var logoImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_cover)

        logoImage = findViewById(R.id.cover_logo)

        val animationTask = object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    setLogoAnime()
                }

            }
        }

        val finishTask = object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val shareOption = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this@CoverActivity,
                        logoImage,
                        "LogoTrans")

                    this@CoverActivity.roboStartActivity<LoginActivity>(
                        listOf(
                            Pair(
                                "animationType",
                                Base.ANIMATION_FADE
                            )
                        ),shareOption.toBundle(),Base.START_TYPE_FINISH
                    )
                }
            }
        }

        Timer().schedule(animationTask, 1800)
        Timer().schedule(finishTask, 2310)


    }

    fun setLogoAnime() {

        val logoTranY = logoImage.y

        val scaleXAnime = ObjectAnimator.ofFloat(logoImage, "scaleX", 1f, 0.8f)
        val scaleYAnime = ObjectAnimator.ofFloat(logoImage, "scaleY", 1f, 0.8f)

        val tranYAnime = ObjectAnimator.ofFloat(logoImage, "translationY", 0f, -logoTranY * 0.96f)

        val animatorSet = AnimatorSet()

        animatorSet.play(scaleYAnime).with(scaleXAnime).with(tranYAnime)
        animatorSet.duration = 500

        animatorSet.start()

    }

}