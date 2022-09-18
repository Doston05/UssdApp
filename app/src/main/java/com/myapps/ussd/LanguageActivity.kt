package com.myapps.ussd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_language.*

class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        uzbek_btn.setOnClickListener {
            startActivity(Intent(this@LanguageActivity, MainActivity::class.java))
        }
    }
}