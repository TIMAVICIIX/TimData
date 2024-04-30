package com.example.vacationventurepe


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.vacationventurepe.basetools.BaseActivity

class LoginActivity : BaseActivity() {

    private lateinit var userAccount: EditText
    private lateinit var userPassword: EditText

    private lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login_view)

        initData()

        loginBtn.setOnClickListener {
            //TODO
        }

    }

    private fun initData() {

        userAccount = findViewById(R.id.editText_account_input)
        userPassword = findViewById(R.id.editText_password_input)

        loginBtn = findViewById(R.id.login_btn)

    }


}