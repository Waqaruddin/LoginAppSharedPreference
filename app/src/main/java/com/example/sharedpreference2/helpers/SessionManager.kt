package com.example.sharedpreference2.helpers

import android.content.Context
import com.example.sharedpreference2.models.User

class SessionManager(var mContext:Context){
    private val FILE_NAME = "my_pref"
    private val KEY_NAME = "name"
    private val KEY_EMAIL = "EMAIL"
    private val KEY_PASSWORD = "password"
    private val KEY_IS_LOGGED_IN = "isLoggedIn"

    var sharePreferences = mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    var editor = sharePreferences.edit()

    fun register(user:User){
        editor.putString(KEY_NAME, user.name)
        editor.putString(KEY_EMAIL, user.email)
        editor.putString(KEY_PASSWORD, user.password)
        editor.putBoolean(KEY_IS_LOGGED_IN, true)
        editor.commit()

    }

    fun login(user:User):Boolean{
        var saveEmail:String? = sharePreferences.getString(KEY_EMAIL, null)
        var savePassword:String? = sharePreferences.getString(KEY_PASSWORD, null)
        return saveEmail.equals(user.email) && savePassword.equals(user.password)

    }

    fun getUserName():String?{
        return sharePreferences.getString(KEY_NAME, null)
    }

    fun getUser(): User {
        var name = sharePreferences.getString(KEY_NAME, null)
        var email = sharePreferences.getString(KEY_EMAIL, null)
        var password = sharePreferences.getString(KEY_PASSWORD, null)
        return User(name, email, password)
    }

    fun isLoggedIn():Boolean{
        return sharePreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }
    fun logout(){
        //for specific key
        //editor.remove(KEY_NAME)

        //remove all keys
        editor.clear()
        editor.commit()

    }
}