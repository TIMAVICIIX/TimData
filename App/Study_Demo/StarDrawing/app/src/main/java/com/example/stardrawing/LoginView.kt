package com.example.stardrawing

import android.os.Bundle
import android.widget.ImageButton
import com.example.stardrawing.tool.toasttool.TimToast.toastItShortLength
import androidx.appcompat.app.AppCompatActivity
import com.example.stardrawing.mainview.main.MainViewBus
import com.example.stardrawing.tool.activitytool.TimActivity.activityStart

class LoginView:AppCompatActivity() {

    private lateinit var loginBtn:ImageButton
    private lateinit var skipLoginBtn:ImageButton
    private lateinit var forgetPsBtn:ImageButton
    private lateinit var registerBtn:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_view)
        initVar()

        loginBtn.setOnClickListener {
            "功能未完善，请点击跳过登录".toastItShortLength(this)
        }

        skipLoginBtn.setOnClickListener {
            activityStart<MainViewBus>()
            finish()
        }

        forgetPsBtn.setOnClickListener {
            "功能未完善，请点击跳过登录".toastItShortLength(this)
        }

        registerBtn.setOnClickListener {
            "功能未完善，请点击跳过登录".toastItShortLength(this)
        }

    }

    private fun initVar(){
        loginBtn=findViewById(R.id.LoginBtn)
        skipLoginBtn=findViewById(R.id.Skip_LoginBtn)
        forgetPsBtn=findViewById(R.id.ForgetPsBtn)
        registerBtn=findViewById(R.id.RegisterBtn)
    }

}