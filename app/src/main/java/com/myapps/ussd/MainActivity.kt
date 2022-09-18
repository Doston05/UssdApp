package com.myapps.ussd

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation_menu.background=null
        bottom_navigation_menu.menu.getItem(2).isEnabled=false
        val bottomNavigationMenu=bottom_navigation_menu
        home_button.setOnClickListener {
            val fragment = MainFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view, fragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }
        bottomNavigationMenu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.balans -> {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:*107%23")
                    startActivity(intent)
                }
                R.id.operator -> {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:1099")
                    startActivity(intent)
                }
                R.id.yangiliklar -> {
                    val url = "https://uztelecom.uz/uz/yangiliklar"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }
                R.id.sozlamalar -> {
                    val url = "https://uztelecom.uz/uz/yangiliklar/aksiyalar"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }
            }
            true
        }



    }



}
