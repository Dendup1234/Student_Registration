package com.example.student_registration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Validation : AppCompatActivity() {
    private lateinit var confirmButton : Button
    private lateinit var cancelButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_validation)
        confirmButton = findViewById(R.id.confirm)
        cancelButton = findViewById(R.id.cancel)

        val firstname = intent.getStringExtra("First_Name")
        val lastname = intent.getStringExtra("Last_Name")
        val email = intent.getStringExtra("Email")
        val phone = intent.getStringExtra("Phone")
        val gender = intent.getStringExtra("Gender")
        val course = intent.getStringExtra("Course")

        confirmButton.setOnClickListener{

            val intent = Intent(this, Display::class.java).apply {
                putExtra("First_Name",firstname)
                putExtra("Last_Name",lastname)
                putExtra("Email",email)
                putExtra("Phone", phone)
                putExtra("Gender",gender)
                putExtra("Course",course)
            }
            startActivity(intent)

        }
        cancelButton.setOnClickListener {
            val intent = Intent(this, Loginpage::class.java)
            startActivity(intent)
        }
    }
}