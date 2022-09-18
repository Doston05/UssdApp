package com.myapps.ussd

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ViewPagerAdapter (private val context: Context) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {
   private var tariffNameList= arrayOf("Milliy 10","Milliy 15","Milliy 40","Milliy 50","Milliy 70","Milliy 100","Milliy VIP")

   private var messageList= arrayOf("10","500","3000","5000","5000","5000","5000")
   private var minuteList= arrayOf("10","500","1000","3000","5000","5000","5000")
   private var megabyteList= arrayOf("10","500","8000","12 000","20 000","35 000","100 000")
   private var subscriptionFeeList= arrayOf("10000","15000","40000","50000","70000","100000","150000")
    val tariffCode = listOf("*111*1*11*1%23", "*111*1*11*2%23", "*111*1*11*3%23",
        "*111*1*11*4%23","*111*1*11*5%23", "*111*1*11*6%23", "*111*1*11*7%23")



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.viewpager_holder, parent, false)
        return ViewHolder(view)
    }


    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tarifName.text=tariffNameList[position]
        (messageList[position]+"SMS").also { holder.message.text = it }
        (minuteList[position]+"MIN").also { holder.minutes.text = it }
        (megabyteList[position]+"MB").also { holder.megabyte.text = it }
        (subscriptionFeeList[position]+"So`m").also { holder.subscriptionFee.text = it }
        holder.internet.setImageResource(R.drawable.internet)
        holder.minuteImg.setImageResource(R.drawable.minut)
        holder.messageImg.setImageResource(R.drawable.message)
        holder.itemView.setOnClickListener {
            val intent = Intent(context,TarifActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("tarifName", tariffNameList[position])
            intent.putExtra("messageText", messageList[position])
            intent.putExtra("minuteText", minuteList[position])
            intent.putExtra("megabyteText", megabyteList[position])
            intent.putExtra("subscriptionFee", subscriptionFeeList[position])
            intent.putExtra("tariffCode",tariffCode[position])

            context.startActivity(intent)
        }





       

    }

    override fun getItemCount(): Int {
        return messageList.size
    }




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tarifName:TextView
        var minutes:TextView
        var message:TextView
        var megabyte:TextView
        var subscriptionFee:TextView
        var internet:ImageView
        var messageImg:ImageView
        var minuteImg:ImageView

        init {
            tarifName=itemView.findViewById(R.id.tariff_name)
            minutes=itemView.findViewById(R.id.minutes)
            message=itemView.findViewById(R.id.message)
            megabyte=itemView.findViewById(R.id.megabyte)
            subscriptionFee=itemView.findViewById(R.id.subscription_fee)
            internet=itemView.findViewById(R.id.internet_view)
            messageImg=itemView.findViewById(R.id.message_pager)
            minuteImg=itemView.findViewById(R.id.minute_pager)

        }
    }


}