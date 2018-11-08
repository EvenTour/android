package com.upc.projects.enzoftware.eventour.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.upc.projects.enzoftware.eventour.R
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        question_button.setOnClickListener {
            Toast.makeText(this,"Thanks!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}