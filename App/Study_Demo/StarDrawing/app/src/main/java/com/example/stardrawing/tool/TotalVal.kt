package com.example.stardrawing.tool

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class TotalVal:Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        const val REPLACE_TO_BOARD_FRAGMENT = 0

        const val REPLACE_TO_PAINTING_FRAGMENT = 1

        const val REPLACE_TO_CENTER_FRAGMENT = 2

        const val REPLACE_TO_COMMUNITY_FRAGMENT = 3

        const val REPLACE_TO_PERSONAL_FRAGMENT = 4
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}