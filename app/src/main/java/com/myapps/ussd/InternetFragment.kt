package com.myapps.ussd

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_internet.view.*
import kotlinx.android.synthetic.main.fragment_message.view.*

class InternetFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_internet, container, false)
        val internetTraffic = listOf("100 MB", "300 MB", "600 MB")
        val trafficCode = listOf("*121*1*3*1%23", "*121*1*3*2%23", "*121*1*3*3%23")
        val trafficPrice = listOf("3000 so`m", "6000 so`m", "9000 so`m")
        val descriptionText = listOf(
            "Internet to`plam faollashtirilgan vaqtdan boshlab 24 soat davomida amal qiladi." +
                    " Qolgan traffic keyingi kunga o`tmaydi",
            "Internet to`plam faollashtirilgan vaqtdan boshlab 24 soat davomida amal qiladi." +
                    " Qolgan traffic keyingi kunga o`tmaydi",
            "Internet to`plam faollashtirilgan vaqtdan boshlab 24 soat davomida amal qiladi." +
                    " Qolgan traffic keyingi kunga o`tmaydi"

        )
        val internetImg= listOf(R.drawable.internet,R.drawable.internet,R.drawable.internet)

        val expandableListView = ExpandableListViewAdapter(
            requireActivity().applicationContext,
            price = trafficPrice,
            title = internetTraffic,
            description = descriptionText,
            code = trafficCode,
            img = internetImg
        )
        view?.expandable_list_internet?.setAdapter(expandableListView)

        view.monthly_internet.setOnClickListener {
            initMontly()


        }
        view.nightly_unlim.setOnClickListener {
            initUnlim()
        }


        view.daily_internet.setOnClickListener {
            initDaily()
        }
        view.internet_back.setOnClickListener{
            val fragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(
                R.id.fragment_container_view,
                MainFragment()
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

            view.check_internet.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:*107%23")
                startActivity(intent)



            }




            return view
        }
        private fun initMontly() {
            replaceBackground(1)
            val internetTraffic = listOf("1 GB", "1.5 GB", "3 GB", "5 GB", "8 GB","12 GB","16 GB",
                "20 GB","30 GB","50 GB","75 GB")
            val trafficCode = listOf("*111*1*9*1%23", "*111*1*9*2%23", "*111*1*9*3%23",
                "*111*1*9*4%23", "**111*1*9*5%23","*111*1*9*6%23", "*111*1*9*6%23",
                "*111*1*9*7%23", "*111*1*9*8%23", "*111*1*9*9%23","*111*1*9*10%23")
            val trafficPrice = listOf("9000 so`m", "14 000 so`m", "18 000 so`m", "25 000 so`m",
                "35 000 so`m","50 000 so`m","60 000 so`m","65 000 so`m","75 000 so`m","85 000 so`m"
                ,"110 000 so`m")
            val descriptionText = listOf(
                "To`plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan traffic " +
                        "keyingi oyga o`tmaydi.",
                "To`plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan traffic " +
                        "keyingi oyga o`tmaydi.",
                "To`plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan traffic " +
                        "keyingi oyga o`tmaydi.",
                "To`plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan traffic " +
                        "keyingi oyga o`tmaydi.",
                "To`plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan traffic " +
                        "keyingi oyga o`tmaydi.",
                "To`plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan traffic " +
                        "keyingi oyga o`tmaydi.",
                "To`plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan traffic " +
                        "keyingi oyga o`tmaydi.",
                "To`plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan traffic " +
                        "keyingi oyga o`tmaydi.",
                "To`plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan traffic " +
                        "keyingi oyga o`tmaydi.",
                "To`plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan traffic " +
                        "keyingi oyga o`tmaydi.",
                "To`plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan traffic " +
                        "keyingi oyga o`tmaydi.",
                )
            val internetImg= listOf(
                R.drawable.internet,R.drawable.internet,R.drawable.internet,
                R.drawable.internet,R.drawable.internet,R.drawable.internet,R.drawable.internet,
            R.drawable.internet,R.drawable.internet,R.drawable.internet,R.drawable.internet)

            val expandableListView = ExpandableListViewAdapter(
                requireActivity().applicationContext,
                price = trafficPrice,
                title = internetTraffic,
                description = descriptionText,
                code = trafficCode,
                img = internetImg
            )
            view?.expandable_list_internet?.setAdapter(expandableListView)


        }
    private fun initUnlim() {
        replaceBackground(2)
        val internetTraffic = listOf("Tun", "7 tun", "30 tun")
        val trafficCode = listOf("*111*1*18*1%23", "*111*1*18*3%23", "*111*1*18*2%23")
        val trafficPrice = listOf("6300 so`m", "31 500 so`m", "99 000 so`m")
        val descriptionText = listOf(
            "Internet to`plamning amal qilish muddati soat 01:00dan saot 7:59gacha. Agar" +
                    " foydalanilgan trafik 12000 MB dan oshsa Internet tezligi 64Kb/sekundgacha " +
                    "pasayadi. ",
            "Internet to`plamning amal qilish muddati soat 01:00dan saot 7:59gacha. Agar" +
                    " foydalanilgan trafik 12000 MB dan oshsa Internet tezligi 64Kb/sekundgacha " +
                    "pasayadi. ",
            "Internet to`plamning amal qilish muddati soat 01:00dan saot 7:59gacha. Agar" +
                    " foydalanilgan trafik 12000 MB dan oshsa Internet tezligi 64Kb/sekundgacha" +
                    " pasayadi. "
            )
        val internetImg= listOf(R.drawable.internet,R.drawable.internet,R.drawable.internet)

        val expandableListView = ExpandableListViewAdapter(
            requireActivity().applicationContext,
            price = trafficPrice,
            title = internetTraffic,
            description = descriptionText,
            code = trafficCode,
            img = internetImg
        )
        view?.expandable_list_internet?.setAdapter(expandableListView)


    }
    private fun initDaily() {
        replaceBackground(0)
        val internetTraffic = listOf("100 MB", "300 MB", "600 MB")
        val trafficCode = listOf("*121*1*3*1%23", "*121*1*3*2%23", "*121*1*3*3%23")
        val trafficPrice = listOf("3000 so`m", "6000 so`m", "9000 so`m")
        val descriptionText = listOf(
            "Internet to`plam faollashtirilgan vaqtdan boshlab 24 soat davomida amal qiladi." +
                    " Qolgan traffic keyingi kunga o`tmaydi",
            "Internet to`plam faollashtirilgan vaqtdan boshlab 24 soat davomida amal qiladi." +
                    " Qolgan traffic keyingi kunga o`tmaydi",
            "Internet to`plam faollashtirilgan vaqtdan boshlab 24 soat davomida amal qiladi." +
                    " Qolgan traffic keyingi kunga o`tmaydi"

        )
        val internetImg= listOf(R.drawable.internet,R.drawable.internet,R.drawable.internet)

        val expandableListView = ExpandableListViewAdapter(
            requireActivity().applicationContext,
            price = trafficPrice,
            title = internetTraffic,
            description = descriptionText,
            code = trafficCode,
            img = internetImg
        )
        view?.expandable_list_internet?.setAdapter(expandableListView)


    }
    @SuppressLint("ResourceAsColor")
    fun replaceBackground(position:Int){
        when (position){
            0->{
                view?.daily_internet?.setBackgroundResource(R.drawable.selected_item_back)

                view?.monthly_internet?.setBackgroundResource(R.drawable.button_back_stroke)
                view?.nightly_unlim?.setBackgroundResource(R.drawable.button_back_stroke)

            }
            1->{
                view?.monthly_internet?.setBackgroundResource(R.drawable.selected_item_back)

                view?.nightly_unlim?.setBackgroundResource(R.drawable.button_back_stroke)
                view?.daily_internet?.setBackgroundResource(R.drawable.button_back_stroke)
            }
            2->{
                view?.nightly_unlim?.setBackgroundResource(R.drawable.selected_item_back)

                view?.daily_internet?.setBackgroundResource(R.drawable.button_back_stroke)
                view?.monthly_internet?.setBackgroundResource(R.drawable.button_back_stroke)
            }

        }

    }



}

