package com.goodexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var bottomFragment: Fragment
    private lateinit var centerFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    private fun init() {

        bottomFragment = supportFragmentManager.findFragmentById(R.id.bottomFragment)!!
        centerFragment = supportFragmentManager.findFragmentById(R.id.centerFragment)!!

        bottomFragment=BottomGuide()
        centerFragment=Center()

    }

}