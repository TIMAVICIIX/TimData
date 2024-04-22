package com.example.testrecyclerview

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(){

    private lateinit var titleTextView: TextView
    private lateinit var contentTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity_layout)

        titleTextView = findViewById(R.id.info_title)
        contentTextView = findViewById(R.id.info_textview)

        val infoBundle = intent.getBundleExtra("info")

        infoBundle?.let {
            titleTextView.text=it.getString("title")
            titleTextView.textSize=32f
            contentTextView.text=it.getString("content")
            contentTextView.textSize=32f
        }

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if(keyCode==KeyEvent.KEYCODE_BACK){
            finish()
        }

        return super.onKeyDown(keyCode, event)
    }

}