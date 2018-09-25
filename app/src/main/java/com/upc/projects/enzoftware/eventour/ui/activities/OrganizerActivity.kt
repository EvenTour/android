package com.upc.projects.enzoftware.eventour.ui.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.upc.projects.enzoftware.eventour.R
import com.upc.projects.enzoftware.eventour.model.Organizer

import kotlinx.android.synthetic.main.activity_organizer.*
import kotlinx.android.synthetic.main.content_organizer.*

class OrganizerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organizer)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent?: return
        val organizer = Organizer.from(intent.extras)
        with(OrganizerDetailImage){
            setDefaultImageResId(R.mipmap.ic_launcher)
            setErrorImageResId(R.mipmap.ic_launcher)
            setImageUrl(organizer.urlImage)
        }

        val contact = "Contact: ${organizer.contactUrl}"
        val field = "Field: ${organizer.field}"
        val event = "Event organized: ${organizer.event_id} "
        OrganizerDetailName.text = organizer.name
        OrganizerDetailField.text = field
        OrganizerDetailContact.text = contact
        OrganizerDetailEvent.text = event

    }

}
