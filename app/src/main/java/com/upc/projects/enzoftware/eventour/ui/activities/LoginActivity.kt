package com.upc.projects.enzoftware.eventour.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.upc.projects.enzoftware.eventour.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            view -> login()
        }
    }

    private fun login(){
        val emailView:TextView = findViewById(R.id.usernameTextView)
        val passwordView:TextView = findViewById(R.id.passwordTextView)
        var email = (emailView.text).toString()
        var password = (passwordView.text).toString()

        if(!email.isEmpty() && !password.isEmpty()){
            mAuth.signInWithEmailAndPassword(email , password).addOnCompleteListener(this@LoginActivity, OnCompleteListener { task ->
                if(task.isSuccessful){
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }
                else{
                    Toast.makeText(this@LoginActivity, "Wrong username or password", Toast.LENGTH_SHORT).show()
                }
            })
        }
        else{
            Toast.makeText(this@LoginActivity, "Fill up all the blank spaces", Toast.LENGTH_SHORT).show()
        }
    }
}