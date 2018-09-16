package com.upc.projects.enzoftware.eventour.ui.adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater



class ViewPagerAdapter(val layouts : ArrayList<Int>, val context: Context) : PagerAdapter(){
    lateinit var layoutInflater: LayoutInflater

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(layouts[position], container, false)
        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
      return view == `object`
    }

    override fun getCount(): Int = layouts.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}