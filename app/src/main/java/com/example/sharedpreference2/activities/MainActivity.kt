package com.example.sharedpreference2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.se.omapi.Session
import com.example.sharedpreference2.R
import com.example.sharedpreference2.helpers.SessionManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        var sessionManager = SessionManager(this)
        if(sessionManager.isLoggedIn()){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        button_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        button_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))

        }
    }
}