package com.example.stardrawing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stardrawing.tool.activitytool.TimActivity.activityStart
import kotlin.concurrent.thread

class AppCover : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_cover)

        thread{
            Thread.sleep(3000)
            activityStart<LoginView>()
            finish()
        }
    }
}