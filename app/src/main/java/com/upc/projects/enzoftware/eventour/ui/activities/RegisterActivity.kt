package com.upc.projects.enzoftware.eventour.ui.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.upc.projects.enzoftware.eventour.R

import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth
    lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl(getString(R.string.database_reference))

        registerButton.setOnClickListener{
           register()
        }

        alreadyRegistered.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
    }

    private fun register(){
        val nameTextView:TextView = findViewById(R.id.nameRegisterTextView)
        val emailTextView:TextView = findViewById(R.id.emailRegisterTextView)
        val passTextView:TextView = findViewById(R.id.passRegisterTextView)
        val name = (nameTextView.text).toString()
        val email = (emailTextView.text).toString()
        val password = (passTextView.text).toString()

        if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this@RegisterActivity){ task ->
                if(task.isSuccessful) {
                    startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                    val user = mAuth.currentUser
                    val uid = user!!.uid
                    mDatabase.child("users").child(uid).child("name").setValue(name)
                    mDatabase.child("users").child(uid).child("email").setValue(email)
                    mDatabase.child("users").child(uid).child("password").setValue(password)
                }
                else{
                    when(task.exception.toString()) {
                        getString(R.string.weak_password) -> {
                            Toast.makeText(this@RegisterActivity, "Password must contain at least 6 characters", Toast.LENGTH_SHORT).show()
                        }
                        getString(R.string.already_registered) -> {
                            Toast.makeText(this@RegisterActivity, "That email adress is already related with an account", Toast.LENGTH_SHORT).show()
                        }
                        getString(R.string.invalid_email) -> {
                            Toast.makeText(this@RegisterActivity, "Insert a valid email address", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            Toast.makeText(this@RegisterActivity, "Something went wrong. Please try later", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }else{
            Toast.makeText(this@RegisterActivity, "Complete all the fields requested", Toast.LENGTH_SHORT).show()
        }
    }

}
