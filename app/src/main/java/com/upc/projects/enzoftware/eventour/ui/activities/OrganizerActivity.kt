package com.upc.projects.enzoftware.eventour.ui.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.upc.projects.enzoftware.eventour.R
import com.upc.projects.enzoftware.eventour.model.Organizer

import kotlinx.android.synthetic.main.activity_organizer.*
import kotlinx.android.synthetic.main.content_organizer.*
import android.widget.Toast
import android.content.ActivityNotFoundException
import android.util.Log


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

        val field = "Field: ${organizer.field}"
        val event = "Event organized: ${organizer.event_id} "
        OrganizerDetailName.text = organizer.name
        OrganizerDetailField.text = field
        OrganizerDetailContact.setOnClickListener {
            openWebPage(organizer.contactUrl!!)
        }
        OrganizerDetailEvent.text = event

    }

    fun openWebPage(url: String) {
        try {
            val webpage = Uri.parse(url)
            val myIntent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(myIntent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "No application can handle this request. Please install a web browser or check your URL.", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }

    }

}
