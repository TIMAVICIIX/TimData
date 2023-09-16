package com.example.stardrawing.base

import androidx.appcompat.app.AppCompatActivity
import com.example.stardrawing.tool.toasttool.TimToast.toastItShortLength
import kotlin.system.exitProcess

open class BaseActivity:AppCompatActivity() {

    var firstTime:Long=0

    fun exitDouble(timeDelay:Long,tempString:String?){

        if(System.currentTimeMillis() - firstTime >= timeDelay){
            tempString?.toastItShortLength(this)
            firstTime=System.currentTimeMillis()
        }else{
            finish()
        }

    }

}