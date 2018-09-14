package com.upc.projects.enzoftware.eventour.ui.adapters

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

class ViewPagerAdapter : PagerAdapter(){
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return super.instantiateItem(container, position)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }
}