package com.myapps.ussd

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_main.view.*


class MainFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_main, container, false)
        val fragmentManager = parentFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val viewPager2 = view.viewpager2
        val viewPagerAdapter=ViewPagerAdapter(requireActivity().applicationContext)
        viewPager2.adapter = viewPagerAdapter
        viewPager2.orientation= ViewPager2.ORIENTATION_HORIZONTAL
        viewPager2.setOnClickListener {

        }

        view.indicator.setViewPager(viewPager2)
        view.internet_btn_img.setOnClickListener {

            fragmentTransaction.replace(
                R.id.fragment_container_view,
                InternetFragment()
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        view.message_btn_img.setOnClickListener {

            fragmentTransaction.replace(
                R.id.fragment_container_view,
                MessageFragment()
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        view.minut_btn_img.setOnClickListener {

            fragmentTransaction.replace(
                R.id.fragment_container_view,
                MinutFragment()
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        view.ussd_btn_img.setOnClickListener {

            fragmentTransaction.replace(
                R.id.fragment_container_view,
                UssdFragment()
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        view.tariff_btn_img.setOnClickListener {

            fragmentTransaction.replace(
                R.id.fragment_container_view,
                TarifFragment()
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        view.service_btn_img.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:3456789")
            startActivity(intent)
        }
        view.telegram_channel.setOnClickListener {
            val url = "https://t.me/s/uztelecomuz"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        view.share_btn.setOnClickListener {
            val url = "https://t.me/s/uztelecomuz"
            var sendIntent =  Intent()
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, url);
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "Preview with:"))

        }
        return view

    }



}



