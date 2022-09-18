package com.myapps.ussd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_minut.view.*
import kotlinx.android.synthetic.main.fragment_tarif.view.*

class TarifFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_tarif, container, false)
        val tariff = listOf("Milliy 10", "Milliy 15", "Milliy 40", "Milliy 50","Milliy 70",
            "Milliy 100","Milliy VIP")
        val tariffCode = listOf("*111*1*11*1%23", "*111*1*11*2%23", "*111*1*11*3%23",
            "*111*1*11*4%23","*111*1*11*5%23", "*111*1*11*6%23", "*111*1*11*7%23")
        val tariffPrice = listOf("10 000 so`m", "15 000 so`m", "40 000 so`m", "50 000 so`m",
            "70 000 so`m","100 000 so`m","150 000 so`m")
        val descriptionText = listOf(
            "10 MB\n10 MIN\n10 SMS",
            "500 MB\n100 MIN\n500 SMS",
            "8 GB\nCheksiz\n3000 SMS",
            "12 GB\nCheksiz\n5000 SMS",
            "20 GB\nCheksiz\n5000 SMS",
            "35 GB\nCheksiz\n5000 SMS",
            "Cheksiz\nCheksiz\n5000 SMS"


        )
        val tarifImg= listOf(R.drawable.uzmobile_icon,R.drawable.uzmobile_icon,R.drawable.uzmobile_icon,R.drawable.uzmobile_icon,R.drawable.uzmobile_icon,R.drawable.uzmobile_icon,R.drawable.uzmobile_icon)

        val expandableListView = ExpandableListViewAdapter(
            requireActivity().applicationContext,
            price = tariffPrice,
            title = tariff,
            description = descriptionText,
            code = tariffCode,
            img = tarifImg
        )
        view?.expandable_list_tarif?.setAdapter(expandableListView)
        view.tarif_back.setOnClickListener {

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


}