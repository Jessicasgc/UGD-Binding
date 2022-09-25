package com.example.ugdnyakawan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splash : AppCompatActivity() {
    //private val Splash_Time_Out: Long = 30

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        //Handler().postDelayed({
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@Splash, MainActivity::class.java))
            finish()

        }, 30)
    }
}