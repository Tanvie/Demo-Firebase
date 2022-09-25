package com.example.blogapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }

    fun gotoReg(view: View) {
        startActivity(Intent(this, RegistrationActivity::class.java))
    }
     fun gotoLogin(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun addUser(view: View) {
        startActivity(Intent(this, AddUserActivity::class.java))
    }
    fun readRecords(view: View) {
        startActivity(Intent(this, ReadRecordsActivity::class.java))
    }
}