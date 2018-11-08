package com.upc.projects.enzoftware.eventour.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.upc.projects.enzoftware.eventour.R
import kotlinx.android.synthetic.main.activity_rate_event.*
import com.hsalf.smilerating.SmileRating



class RateEventActivity : AppCompatActivity() {

    val TAG = "RATE SMILE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_event)

        smile_rating.setOnSmileySelectionListener { smiley, reselected ->
            when (smiley) {
                SmileRating.BAD -> {
                    Log.i(TAG, "Bad")
                }
                SmileRating.GOOD -> {
                    Log.i(TAG, "Good")
                }
                SmileRating.GREAT -> {
                    Log.i(TAG, "Great")
                }
                SmileRating.OKAY -> {
                    Log.i(TAG, "Okay")
                }
                SmileRating.TERRIBLE -> {
                    Log.i(TAG, "Terrible")
                }
            }
        }

    }
}
