package com.upc.projects.enzoftware.eventour.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.upc.projects.enzoftware.eventour.R
import kotlinx.android.synthetic.main.activity_login.*
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.GoogleAuthProvider


class LoginActivity : AppCompatActivity() {

    lateinit var mAuth:FirebaseAuth
    lateinit var mGoogleSignInClient:GoogleSignInClient
    lateinit var gso:GoogleSignInOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        loginButton.setOnClickListener {
            login()
        }

        /*googleLogin.setOnClickListener {
            signInGoogle()
        }

        facebookLogin.setOnClickListener {

        }*/

        registerTextView.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }

    private fun login(){
        val emailView:TextView = findViewById(R.id.usernameTextView)
        val passwordView:TextView = findViewById(R.id.passwordTextView)
        val email = (emailView.text).toString()
        val password = (passwordView.text).toString()

        if(!email.isEmpty() && !password.isEmpty()){
            mAuth.signInWithEmailAndPassword(email , password).addOnCompleteListener(this@LoginActivity) { task ->
                if(task.isSuccessful){
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }
                else{
                    Toast.makeText(this@LoginActivity, "Wrong username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else{
            Toast.makeText(this@LoginActivity, "Fill up all the blank spaces", Toast.LENGTH_SHORT).show()
        }
    }

    /*private fun signInGoogle(){
        val signInIntent = mGoogleSignInClient.getSignInIntent()
        startActivityForResult(signInIntent, 1)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account)
            } catch (e: ApiException) {
                Toast.makeText(this@LoginActivity, "Google sign in failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(account:GoogleSignInAccount){
        val credential =  GoogleAuthProvider.getCredential(account.idToken, null)
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this@LoginActivity) { task ->
                    if(task.isSuccessful){
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this@LoginActivity, "Wrong username or password", Toast.LENGTH_SHORT).show()
                    }
                }
    }*/
}