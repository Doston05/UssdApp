package com.myapps.ussd

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert.ACTION
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tarif.*

class TarifActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarif)
        tarif_name.text=intent.getStringExtra("tarifName")
        (intent.getStringExtra("minuteText")+"MIN").also { minut.text = it }
        (intent.getStringExtra("messageText")+"SMS").also { sms.text = it }
        (intent.getStringExtra("megabyteText")+"MB").also { mb.text = it }
        (intent.getStringExtra("subscriptionFee")+"so`m").also { subscriptionfee.text = it }
        (intent.getStringExtra("subscriptionFee")+"so`m").also { subscription_fee_detail.text = it }
        val tariffCode=intent.getStringExtra("tariffCode")

        tarif_name_detail.text=intent.getStringExtra("tarifName")
        mbViewPager.setImageResource(R.drawable.internet)
        minuteViewPager.setImageResource(R.drawable.minut)
        messageViewPager.setImageResource(R.drawable.message)
        button_tariff.setOnClickListener{
            val intent=Intent(Intent.ACTION_DIAL)
            intent.data= Uri.parse("tel:$tariffCode")
            startActivity(intent)
        }


    }
}