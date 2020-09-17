package com.example.sharedpreference2.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sharedpreference2.R
import com.example.sharedpreference2.helpers.SessionManager
import com.example.sharedpreference2.models.User
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    var name = ""
    var email = ""
    var password = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
    }

    private fun init() {
        button_register.setOnClickListener(this)
        text_view_click_here.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.button_register -> {

                name = edit_text_name.text.toString()
                email = edit_text_email.text.toString()
                password = edit_text_password.text.toString()

                var user = User(name, email, password)

                var sessionManager = SessionManager(this)
                sessionManager.register(user)

                startActivity(Intent(this, LoginActivity::class.java))

            }

            R.id.text_view_click_here -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }
}