package com.upc.projects.enzoftware.eventour.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.upc.projects.enzoftware.eventour.R
import kotlinx.android.synthetic.main.activity_rate_event.*
import com.hsalf.smilerating.SmileRating



class RateEventActivity : AppCompatActivity() {

    val tagRateEvent = "RATE SMILE"
    var rate : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_event)

        smile_rating.setOnSmileySelectionListener { smiley, reselected ->
            when (smiley) {
                SmileRating.TERRIBLE -> {
                    Log.i(tagRateEvent, "Terrible")
                    rate = 1
                }
                SmileRating.BAD -> {
                    Log.i(tagRateEvent, "Bad")
                    rate = 2
                }
                SmileRating.OKAY -> {
                    Log.i(tagRateEvent, "Okay")
                    rate = 3
                }
                SmileRating.GOOD -> {
                    Log.i(tagRateEvent, "Good")
                    rate = 4
                }
                SmileRating.GREAT -> {
                    Log.i(tagRateEvent, "Great")
                    rate = 5
                }
            }
        }


        send_opinion.setOnClickListener {
            Toast.makeText(this,"Thanks!", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}
