package com.example.stardrawing.tool.activitytool

import android.app.Activity
import android.content.Intent
import kotlin.concurrent.thread
object TimActivity {

    fun <T> Activity.activityStartWithPut(startClass:T, block:()->Unit){
        thread {
            val intent= Intent(this,startClass!!::class.java)
            block()
            startActivity(intent)
        }
    }

    inline fun <reified T> Activity.activityStart(){

        thread {
            val intent= Intent(this,T::class.java)
            startActivity(intent)
        }
    }

}