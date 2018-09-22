package com.upc.projects.enzoftware.eventour.ui.activities

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import com.upc.projects.enzoftware.eventour.R
import com.upc.projects.enzoftware.eventour.preferences.PreferencesManager
import com.upc.projects.enzoftware.eventour.ui.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_on_boarding.*


class OnBoardingActivity : AppCompatActivity() {

    private lateinit var myViewPagerAdapter: ViewPagerAdapter
    private lateinit var dots: Array<TextView?>
    private var layouts: ArrayList<Int> = ArrayList()
    private lateinit var prefManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefManager = PreferencesManager(this)
        if(!prefManager.isFirstTimeLaunch()){
            launchHomeScreen()
            finish()
        }

        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        setContentView(R.layout.activity_on_boarding)

        layouts.apply {
            add(R.layout.welcome_side_intro)
            add(R.layout.welcome_side_calendar)
            add(R.layout.welcome_side_placeholder)
            add(R.layout.welcome_side_invitation)
        }


        addBottomDots(0)

        changeStatusBarColor()

        myViewPagerAdapter = ViewPagerAdapter(layouts,this)
        view_pager.adapter = myViewPagerAdapter
        view_pager.addOnPageChangeListener(viewPagerPageChangeListener)

        btn_skip.setOnClickListener {
            launchHomeScreen()
        }

        btn_next.setOnClickListener {
            val current = getItem(+1)
            if(current < layouts.size){
                view_pager.currentItem = current
            }else{
                launchHomeScreen()
            }
        }


    }

    private val viewPagerPageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageSelected(position: Int) {
            addBottomDots(position)

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.size - 1) {
                // last page. make button text to GOT IT
                btn_next.text = getString(R.string.start)
                btn_skip.visibility = View.GONE
            } else {
                // still pages are left
                btn_next.text = getString(R.string.next)
                btn_skip.visibility = View.VISIBLE
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {

        }

        override fun onPageScrollStateChanged(arg0: Int) {

        }
    }


    private fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls(layouts.size)

        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)

        layoutDots.removeAllViews()
        for (i in 0 until dots.size) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#8226;")
            dots[i]!!.textSize = 35F
            dots[i]!!.setTextColor(colorsInactive[currentPage])
            layoutDots.addView(dots[i])
        }

        if (dots.isNotEmpty()){
            dots[currentPage]!!.setTextColor(colorsActive[currentPage])
        }
    }

    private fun getItem(i: Int): Int {
        return view_pager.currentItem + i
    }

    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false)
        startActivity(Intent(this@OnBoardingActivity, MainActivity::class.java))
        finish()
    }
}
