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
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }

    private fun init() {
        button_login.setOnClickListener(this)
        text_view_click_here.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button_login -> {
                var email = edit_text_email.text.toString()
                var password = edit_text_password.text.toString()

                var user = User(null, email, password)

                var sessionManager = SessionManager(this)

                if (sessionManager.login(user)) {

                    startActivity(Intent(this, HomeActivity::class.java))
                } else {
                    Toast.makeText(
                        applicationContext,
                        "invalid username or password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            R.id.text_view_click_here -> {
                startActivity(Intent(this, RegisterActivity::class.java))
            }
        }
    }
}