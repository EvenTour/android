package com.upc.projects.enzoftware.eventour.ui.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.upc.projects.enzoftware.eventour.R
import com.upc.projects.enzoftware.eventour.model.Event

import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.content_event.*

class EventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent?: return
        val event = Event.from(intent.extras)
        with(EventDetailImage){
            setDefaultImageResId(R.mipmap.ic_launcher)
            setErrorImageResId(R.mipmap.ic_launcher)
            setImageUrl(event.urlImage)
        }

        val start = "Start date: ${event.startDate}"
        val end = "End date: ${event.endDate}"
        val duration = "Duration of the event: ${event.duration} days"
        supportActionBar?.title = event.event_name
        EventDetailStart.text = start
        EventDetailEnd.text = end
        EventDetailDuration.text = duration

    }

}
