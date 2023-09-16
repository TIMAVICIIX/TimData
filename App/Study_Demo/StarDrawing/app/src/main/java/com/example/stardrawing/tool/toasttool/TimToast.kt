@file:Suppress("DEPRECATION")

package com.example.stardrawing.tool.toasttool

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.stardrawing.tool.toasttool.TimToast.toastItLongLength
import javax.net.ssl.ManagerFactoryParameters

object TimToast {

    public fun String.toastItShortLength(context: Context?){
        Toast.makeText(context,this, Toast.LENGTH_SHORT).show()
    }

    public fun String.toastItLongLength(context: Context){
        Toast.makeText(context, this, Toast.LENGTH_LONG).show()
    }

    public fun String.toastItLongLengthRobo(context: Context){
        val tempToast=Toast.makeText(context, this, Toast.LENGTH_LONG)

        val tempLayout:LinearLayout=tempToast.view as LinearLayout

        val tv:TextView=tempLayout.getChildAt(0) as TextView

        tv.textSize=10f
        tv.setTextColor(Color.BLACK)
        tempToast.setGravity(Gravity.TOP,0,20)

        tempToast.show()
    }

}