package com.example.student_registration

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Display : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_display)
        val firstname = intent.getStringExtra("First_Name")
        val lastname = intent.getStringExtra("Last_Name")
        val email = intent.getStringExtra("Email")
        val phone = intent.getStringExtra("Phone")
        val gender = intent.getStringExtra("Gender")
        val course = intent.getStringExtra("Course")

        findViewById<TextView>(R.id.firstNameTextView).text = "First Name: $firstname"
        findViewById<TextView>(R.id.lastNameTextView).text = "Last Name: $lastname"
        findViewById<TextView>(R.id.emailTextView).text = "Email: $email"
        findViewById<TextView>(R.id.phoneTextView).text = "Phone Number: $phone"
        findViewById<TextView>(R.id.genderTextView).text = "Gender: $gender"
        findViewById<TextView>(R.id.courseTextView).text = "Course: $course"
    }
}