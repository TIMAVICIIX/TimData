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
import com.example.vacationventurepe.basetools.RoboActivity.roboStartActivityWithFinishChoose
import java.util.Timer
import java.util.TimerTask
import kotlin.random.Random

class CoverActivity : BaseActivity() {

    private lateinit var logoImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_cover)

        logoImage = findViewById(R.id.cover_logo)

        val animationTask = object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (Random.nextBoolean())
                        setMainAnime()
                    else
                        setLogoAnime()

                }

            }
        }
        Timer().schedule(animationTask, 1800)

    }

    fun setLogoAnime() {

        val logoTranY = logoImage.y

        val scaleXAnime = ObjectAnimator.ofFloat(logoImage, "scaleX", 1f, 0.8f)
        val scaleYAnime = ObjectAnimator.ofFloat(logoImage, "scaleY", 1f, 0.8f)

        val tranYAnime = ObjectAnimator.ofFloat(logoImage, "translationY", 0f, -logoTranY * 0.96f)

        val animatorSet = AnimatorSet()

        animatorSet.play(scaleYAnime).with(scaleXAnime).with(tranYAnime)
        animatorSet.duration = 500

        animatorSet.addListener(object:AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                runOnUiThread {
                    val shareOption = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this@CoverActivity,
                        logoImage,
                        "LogoTrans"
                    )

                    this@CoverActivity.roboStartActivityWithFinishChoose<LoginActivity>(
                        listOf(
                            Pair(
                                "animationType",
                                Base.ANIMATION_FADE
                            )
                        ), shareOption.toBundle(), Base.START_TYPE_FINISH
                    )
                }
            }
        })

        animatorSet.start()



    }

    fun setMainAnime() {

        val logoTranY = logoImage.y

        val scaleXAnime = ObjectAnimator.ofFloat(logoImage, "scaleX", 1f, 0.85f)
        val scaleYAnime = ObjectAnimator.ofFloat(logoImage, "ScaleY", 1f, 0.85f)

        val tranYAnime = ObjectAnimator.ofFloat(logoImage, "translationY", 0f, logoTranY * 0.95f)

        val animatorSet = AnimatorSet()

        animatorSet.play(scaleXAnime).with(scaleYAnime).with(tranYAnime)
        animatorSet.duration = 500

        animatorSet.addListener(object:AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                runOnUiThread {
                    val shareOption = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this@CoverActivity,
                        logoImage,
                        "LogoTrans"
                    )

                    this@CoverActivity.roboStartActivityWithFinishChoose<MainActivity>(
                        listOf(
                            Pair(
                                "animationType",
                                Base.ANIMATION_FADE
                            )
                        ), shareOption.toBundle(), Base.START_TYPE_FINISH
                    )
                }
            }
        })

        animatorSet.start()
    }

}