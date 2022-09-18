package com.myapps.ussd

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_internet.view.*
import kotlinx.android.synthetic.main.fragment_message.*
import kotlinx.android.synthetic.main.fragment_message.view.*


class MessageFragment : Fragment() {
    var tempBackground=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view= inflater.inflate(R.layout.fragment_message, container, false)

        val smsPaket = listOf("10 SMS", "50 SMS", "200 SMS", "500 SMS")
        val smsCode = listOf("*111*1*1*1%23", "*111*1*1*2%23", "*111*1*1*3%23", "*111*1*1*4%23")
        val smsPrice = listOf("420 so`m", "1680 so`m", "5200 so`m", "9500 so`m")
        val messageImg= listOf(R.drawable.message,R.drawable.message,R.drawable.message,R.drawable.message)
        val descriptionText = listOf(
            "SMS paketlarning amal qilish muddati ulanish kunidan boshlab 30 kun. Amal qilish " +
                    "hududi O`zbekiston",
            "SMS paketlarning amal qilish muddati ulanish kunidan boshlab 30 kun. Amal qilish " +
                    "hududi O`zbekiston",
            "SMS paketlarning amal qilish muddati ulanish kunidan boshlab 30 kun. Amal qilish " +
                    "hududi O`zbekiston",
            "SMS paketlarning amal qilish muddati ulanish kunidan boshlab 30 kun. Amal qilish " +
                    "hududi O`zbekiston",

            )
        val expandableListView = ExpandableListViewAdapter(
            requireActivity().applicationContext,
            price = smsPrice,
            title = smsPaket,
            description = descriptionText,
            code = smsCode,
            img = messageImg
        )
        view?.expandable_list_message?.setAdapter(expandableListView)



        view.check_message.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:*100*2%23")
            startActivity(intent)
        }


        view.monthly_message.setOnClickListener{
            initMontly()
        }
        view.daily_message.setOnClickListener{
            initDaily()
        }
        view.global_montly_message.setOnClickListener{
            initGlobal()}
        view.message_back.setOnClickListener{
            val fragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(
                R.id.fragment_container_view,
                MainFragment()
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        return view
    }
    fun initMontly() {
        replaceBackground(1)
        tempBackground=1
        val smsPaket = listOf("10 SMS", "50 SMS", "200 SMS", "500 SMS")
        val smsCode = listOf("*111*1*1*1%23", "*111*1*1*2%23", "*111*1*1*3%23", "*111*1*1*4%23")
        val smsPrice = listOf("420 so`m", "1680 so`m", "5200 so`m", "9500 so`m")
        val descriptionText = listOf(
            "SMS paketlarning amal qilish muddati ulanish kunidan boshlab 30 kun. Amal qilish " +
                    "hududi O`zbekiston",
            "SMS paketlarning amal qilish muddati ulanish kunidan boshlab 30 kun. Amal qilish " +
                    "hududi O`zbekiston",
            "SMS paketlarning amal qilish muddati ulanish kunidan boshlab 30 kun. Amal qilish " +
                    "hududi O`zbekiston",
            "SMS paketlarning amal qilish muddati ulanish kunidan boshlab 30 kun. Amal qilish " +
                    "hududi O`zbekiston",

        )
        val messageImg= listOf(R.drawable.message,R.drawable.message,R.drawable.message,R.drawable.message)


        val expandableListView = ExpandableListViewAdapter(
            requireActivity().applicationContext,
            price = smsPrice,
            title = smsPaket,
            description = descriptionText,
            code = smsCode,
            img = messageImg
        )
        view?.expandable_list_message?.setAdapter(expandableListView)


    }
    fun initGlobal() {
        replaceBackground(2)
        tempBackground=2
        val smsPaket = listOf("10 SMS", "20 SMS", "30 SMS","40 SMS","50 SMS" )
        val smsCode = listOf("*111*2*2*1%23", "*111*2*2*2%23", "*111*2*2*3%23","*111*2*2*4%23","*111*2*2*5%23")
        val smsPrice = listOf("9900 so`m", "18 000 so`m", "24 800 so`m","29 700 so`m","33 000 so`m")
        val descriptionText = listOf(
            "Xalqaro SMS-paketlar xizmati abonentlarga arzon narxlarda xalqaro SMS-xabar" +
                    " jo`natish imkonini beradi.Amal Qilish muddati 30kun. ",
            "Xalqaro SMS-paketlar xizmati abonentlarga arzon narxlarda xalqaro SMS-xabar" +
                    " jo`natish imkonini beradi.Amal Qilish muddati 30kun. ",
            "Xalqaro SMS-paketlar xizmati abonentlarga arzon narxlarda xalqaro SMS-xabar" +
                    " jo`natish imkonini beradi.Amal Qilish muddati 30kun. ",
            "Xalqaro SMS-paketlar xizmati abonentlarga arzon narxlarda xalqaro SMS-xabar" +
                    " jo`natish imkonini beradi.Amal Qilish muddati 30kun. ",
            "Xalqaro SMS-paketlar xizmati abonentlarga arzon narxlarda xalqaro SMS-xabar" +
                    " jo`natish imkonini beradi.Amal Qilish muddati 30kun. "
        )
        val messageImg= listOf(R.drawable.message,R.drawable.message,R.drawable.message,R.drawable.message,R.drawable.message)

        val expandableListView = ExpandableListViewAdapter(
            requireActivity().applicationContext,
            price = smsPrice,
            title = smsPaket,
            description = descriptionText,
            code = smsCode,
            img = messageImg
        )
        view?.expandable_list_message?.setAdapter(expandableListView)


    }

    fun initDaily() {
        replaceBackground(0)
        val smsPaket = listOf("50 SMS", "100 SMS" )
        val smsCode = listOf("*111*1*19*1*1%23", "*111*1*19*2*1%23")
        val smsPrice = listOf("420 so`m", "840 so`m")
        val descriptionText = listOf(
            "Faollashtirilgan vaqtdan boshlab 24 soatlik SMS paket. Paket qoldigì keyingi kunga o`tmaydi",
            "Faollashtirilgan vaqtdan boshlab 24 soatlik SMS paket. Paket qoldigì keyingi kunga o`tmaydi",

        )
        val messageImg= listOf(R.drawable.message,R.drawable.message,R.drawable.message,R.drawable.message)

        val expandableListView = ExpandableListViewAdapter(
            requireActivity().applicationContext,
            price = smsPrice,
            title = smsPaket,
            description = descriptionText,
            code = smsCode,
            img = messageImg
        )
        view?.expandable_list_message?.setAdapter(expandableListView)


    }
    @SuppressLint("ResourceAsColor")
    fun replaceBackground(position:Int){
        when (position){
            0->{
                view?.daily_message?.setBackgroundResource(R.drawable.selected_item_back)

                view?.monthly_message?.setBackgroundResource(R.drawable.button_back_stroke)
                view?.global_montly_message?.setBackgroundResource(R.drawable.button_back_stroke)

            }
            1->{
                view?.monthly_message?.setBackgroundResource(R.drawable.selected_item_back)

                view?.global_montly_message?.setBackgroundResource(R.drawable.button_back_stroke)
                view?.daily_message?.setBackgroundResource(R.drawable.button_back_stroke)
            }
            2->{
                view?.global_montly_message?.setBackgroundResource(R.drawable.selected_item_back)

                view?.daily_message?.setBackgroundResource(R.drawable.button_back_stroke)
                view?.monthly_message?.setBackgroundResource(R.drawable.button_back_stroke)
            }

        }

    }

}