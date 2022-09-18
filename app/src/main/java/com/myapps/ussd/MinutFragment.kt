package com.myapps.ussd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_minut.view.*

class MinutFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.fragment_minut, container, false)
        val minutePaket = listOf("100 daqiqa", "300 daqiqa", "600 daqiqa", "1200 daqiqa")
        val minuteCode = listOf("*111*1*3*1%23", "*111*1*3*2%23", "*111*1*3*3%23", "*111*1*3*4%23#")
        val minutePrice = listOf("4000 so`m", "10 000 so`m", "16 000 so`m", "24 000 so`m")
        val descriptionText = listOf(
            "<<Qo`ng`ìroqlar uchun paketlar>> xizmati abonentlarga O`zbekiston bo`ylab zarur" +
                    " bo`lgan sonli qo`ng`ìroqlarcuchun daqiqa-paketiga ulanish imkonini beradi ",
            "<<Qo`ng`ìroqlar uchun paketlar>> xizmati abonentlarga O`zbekiston bo`ylab zarur" +
                    " bo`lgan sonli qo`ng`ìroqlarcuchun daqiqa-paketiga ulanish imkonini beradi ",
            "<<Qo`ng`ìroqlar uchun paketlar>> xizmati abonentlarga O`zbekiston bo`ylab zarur" +
                    " bo`lgan sonli qo`ng`ìroqlarcuchun daqiqa-paketiga ulanish imkonini beradi ",
            "<<Qo`ng`ìroqlar uchun paketlar>> xizmati abonentlarga O`zbekiston bo`ylab zarur" +
                    " bo`lgan sonli qo`ng`ìroqlarcuchun daqiqa-paketiga ulanish imkonini beradi "

            )
        val minuteImg= listOf(R.drawable.minut,R.drawable.minut,R.drawable.minut,R.drawable.minut)

        val expandableListView = ExpandableListViewAdapter(
            requireActivity().applicationContext,
            price = minutePrice,
            title = minutePaket,
            description = descriptionText,
            code = minuteCode,
            img = minuteImg
        )
        view?.expandable_list_minut?.setAdapter(expandableListView)
       view.minut_back.setOnClickListener {

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