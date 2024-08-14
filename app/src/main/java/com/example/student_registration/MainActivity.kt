package com.example.student_registration

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var  emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_loginpage)
        // Password and the email verification done here
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        val submitButton: Button = findViewById(R.id.login_btn)
        val resetButton: Button = findViewById(R.id.reset)

        submitButton.setOnClickListener{
            validateUser()
        }
        resetButton.setOnClickListener{
            resetText()
        }
    }

    fun validateUser(){
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString()
        if (email == "admin@123" && password =="123"){
            val loginButton = findViewById<Button>(R.id.login_btn)
            loginButton.setOnClickListener{
                val Intent = Intent(this,Loginpage::class.java)
                startActivity(Intent)
            }

        }
        else{
            Toast.makeText(this, "Validation Error",
                Toast.LENGTH_SHORT).show()
        }
    }
    fun resetText(){
        emailEditText.text.clear()
        passwordEditText.text.clear()
    }


}