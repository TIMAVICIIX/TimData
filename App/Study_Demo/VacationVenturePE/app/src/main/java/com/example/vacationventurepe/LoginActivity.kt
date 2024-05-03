package com.example.vacationventurepe


import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.core.app.ActivityOptionsCompat
import com.example.vacationventurepe.basetools.Base
import com.example.vacationventurepe.basetools.BaseActivity
import com.example.vacationventurepe.basetools.RoboActivity.roboStartActivity
import com.example.vacationventurepe.basetools.RoboActivity.roboStartActivityWithFinishChoose

class LoginActivity : BaseActivity() {

    private lateinit var userAccount: EditText
    private lateinit var userPassword: EditText

    private lateinit var loginBtn: Button

    private val disappearViews: MutableList<View> = mutableListOf()

    private lateinit var logoImage: RelativeLayout
    private lateinit var logoImageReal:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login_view)

        initData()

        loginBtn.setOnClickListener {
            doDisappearViews()
            moveLogo()
        }

    }

    private fun initData() {

        userAccount = findViewById(R.id.editText_account_input)
        userPassword = findViewById(R.id.editText_password_input)

        loginBtn = findViewById(R.id.login_btn)

        logoImage = findViewById(R.id.login_view_logo)
        logoImageReal = findViewById(R.id.login_view_logo_image)

        disappearViews.apply {
            add(findViewById(R.id.login_view_disappear_01))
            add(findViewById(R.id.login_view_disappear_02))
            add(findViewById(R.id.login_view_disappear_03))
            add(findViewById(R.id.login_view_disappear_04))
        }
    }

    private fun doDisappearViews() {

        disappearViews.forEach {
            it.animate().alpha(0f).setDuration(300).setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    it.visibility = View.INVISIBLE
                }
            })
        }

    }

    private fun moveLogo() {

        val logoTranY = logoImage.y + 250

        Log.d("LoginActivity", "logoTranY:$logoTranY")

        val scaleXAnime = ObjectAnimator.ofFloat(logoImage, "scaleX", 1f, 1.2f)
        val scaleYAnime = ObjectAnimator.ofFloat(logoImage, "ScaleY", 1f, 1.2f)

        val tranYAnime = ObjectAnimator.ofFloat(logoImage, "translationY", 0f, logoTranY * 5.3f)

        val animatorSet = AnimatorSet()

        animatorSet.play(scaleXAnime).with(scaleYAnime).with(tranYAnime)
        animatorSet.duration = 500

        animatorSet.addListener(object:AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator) {
                runOnUiThread {
                    val shareOption = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this@LoginActivity,
                        logoImageReal,
                        "LogoTrans"
                    )

                    this@LoginActivity.roboStartActivityWithFinishChoose<MainActivity>(
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