package com.myapps.ussd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
         Handler().postDelayed( Runnable(){

                /* Create an Intent that will start the Menu-Activity. */
                var mainIntent =  Intent(this, LanguageActivity::class.java);
                startActivity(mainIntent)

        }, 2000);
    }
    }
