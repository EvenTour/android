package com.upc.projects.enzoftware.eventour.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.upc.projects.enzoftware.eventour.R
import kotlinx.android.synthetic.main.activity_report_event.*

class ReportEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_event)



        report_button.setOnClickListener {
            Toast.makeText(this,"Thanks!", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}
