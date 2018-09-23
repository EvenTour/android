package com.upc.projects.enzoftware.eventour.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.upc.projects.enzoftware.eventour.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    lateinit var downToUp : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        downToUp = AnimationUtils.loadAnimation(this, R.anim.down_to_up)
        icon_splash.animation = downToUp
        val handler = Handler()

        handler.postDelayed({
            startActivity(Intent(this,OnBoardingActivity::class.java))
            finish()
        }, 1500)
    }
}
