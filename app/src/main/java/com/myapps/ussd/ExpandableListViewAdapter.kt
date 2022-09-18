package com.myapps.ussd

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.title_layout.view.*


class ExpandableListViewAdapter(val context: Context,val title:List<String>,val price:List<String>,val description:List<String>,val code:List<String>,val img:List<Int>):BaseExpandableListAdapter(),ExpandableListView.OnChildClickListener {
    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
    return true
    }

    override fun getGroup(position: Int): Any {
        return title[position]
    }
    override fun getGroupCount(): Int {
        return title.size
    }
    @SuppressLint("InflateParams")
    override fun getGroupView(p0: Int, isExpanded: Boolean, p2: View?, p3: ViewGroup?): View {
        var convertView=p2

        if (convertView ==null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.title_layout, null)
        }
            val textTitle=convertView!!.findViewById<TextView>(R.id.title_text)
            val imageTitle= convertView.findViewById<ImageView>(R.id.title_image)
        val descriptionTitle= convertView.findViewById<TextView>(R.id.title_description)
        textTitle.text=title[p0]
        descriptionTitle.text=description[p0]
        imageTitle.setImageResource(img[p0])
        if (isExpanded){
            convertView.expandIcon.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
        }
        else{
            convertView.expandIcon.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)

        }
        return convertView


    }


    override fun getChildrenCount(p0: Int): Int {
       return 1
    }


    override fun getChild(p0: Int, p1: Int): Any {
        return description [p0][p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
return false
    }


    @SuppressLint("InflateParams")
    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var convertView=p3
        if (convertView ==null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.expandable_child, null)
        }
        val childText=convertView!!.findViewById<TextView>(R.id.title_full_description)
        childText.text=description[p0]
        val priceTitle= convertView.findViewById<TextView>(R.id.price_title)
        priceTitle.text=price[p0]
        val buttonConnect= convertView.findViewById<Button>(R.id.connect)
        buttonConnect.setOnClickListener {

                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:${code[p0]}")
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }

        return convertView
    }

    override fun onChildClick(
        p0: ExpandableListView?,
        p1: View?,
        p2: Int,
        p3: Int,
        p4: Long
    ): Boolean {
        TODO("Not yet implemented")
    }


}