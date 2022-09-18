package com.myapps.ussd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_minut.view.*
import kotlinx.android.synthetic.main.fragment_ussd.view.*


class UssdFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_ussd, container, false)
        val MinutPaket = listOf("100 daqiqa", "300 daqiqa", "600 daqiqa", "1200 daqiqa")
        val MinutCode = listOf("*107#", "*107#", "*107#", "*107#")
        val MinutPrice = listOf("4000 so`m", "10 000 so`m", "16 000 so`m", "24 000 so`m")
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
        val tarifImg= listOf(R.drawable.minut,R.drawable.minut,R.drawable.minut,R.drawable.minut)

        val expandableListView = ExpandableListViewAdapter(
            requireActivity().applicationContext,
            price = MinutPrice,
            title = MinutPaket,
            description = descriptionText,
            code = MinutCode,
            img = tarifImg
        )
        view?.expandable_list_ussd?.setAdapter(expandableListView)
        view.ussd_back.setOnClickListener {

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