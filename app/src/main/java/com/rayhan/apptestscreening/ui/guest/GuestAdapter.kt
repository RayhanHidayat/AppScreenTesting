package com.rayhan.apptestscreening.ui.guest

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.rayhan.apptestscreening.R

class GuestAdapter(var context: Context, var list: ArrayList<GuideModel>): BaseAdapter() {

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Any = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

    }
}