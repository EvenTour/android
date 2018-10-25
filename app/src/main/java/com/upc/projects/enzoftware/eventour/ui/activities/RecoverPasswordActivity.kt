package com.upc.projects.enzoftware.eventour.ui.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.upc.projects.enzoftware.eventour.R
import kotlinx.android.synthetic.main.activity_recover_password.*

class RecoverPasswordActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_password)

        mAuth = FirebaseAuth.getInstance()

        recoverPassButton.setOnClickListener {
            recoverPassword()
        }

    }

    fun recoverPassword(){
        val emailView = findViewById<EditText>(R.id.emailRecoverPass)
        val email = (emailView.text).toString()

        mAuth.sendPasswordResetEmail(email).addOnCompleteListener{task ->
            if(task.isSuccessful){
                Toast.makeText(this@RecoverPasswordActivity, "Recover email sent to $email", Toast.LENGTH_SHORT)
                startActivity(Intent(this@RecoverPasswordActivity, LoginActivity::class.java))
            }
        }
    }
}
