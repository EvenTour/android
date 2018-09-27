package com.upc.projects.enzoftware.eventour.ui.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.upc.projects.enzoftware.eventour.R
import com.upc.projects.enzoftware.eventour.ui.fragments.EventFragment
import com.upc.projects.enzoftware.eventour.ui.fragments.FavoriteFragment
import com.upc.projects.enzoftware.eventour.ui.fragments.ProfileFragment
import com.upc.projects.enzoftware.eventour.ui.fragments.OrganizerFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            return@OnNavigationItemSelectedListener navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_event

        toolbar.title = resources.getString(R.string.app_name)
    }

    private fun fragmentFor(item: MenuItem):Fragment{
        when(item.itemId){
            R.id.navigation_event ->{
                return EventFragment()
            }
            R.id.navigation_favorites ->{
                return FavoriteFragment()
            }
            R.id.navigation_profile ->{
                return ProfileFragment()
            }
            R.id.navigation_organizers -> {
                return OrganizerFragment()
            }
        }
        return EventFragment()
    }


    private fun navigateTo(item : MenuItem):Boolean{
        item.isChecked = true
        return supportFragmentManager
                .beginTransaction()
                .replace(R.id.contentMain,fragmentFor(item))
                .commit() > 0
    }
}
