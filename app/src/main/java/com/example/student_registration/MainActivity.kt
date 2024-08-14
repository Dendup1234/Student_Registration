package com.example.student_registration

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
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var submitButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // For the user validation
        // Finding the user by the id
        firstNameEditText = findViewById(R.id.firstNameEditText)
        lastNameEditText = findViewById(R.id.lastNameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        radioGroup = findViewById(R.id.radioGroup)

        // Find the Spinner by its ID
        val courseSpinner: Spinner = findViewById(R.id.course_spinner)

        submitButton = findViewById(R.id.login_btn)
        resetButton = findViewById(R.id.reset_btn)

        submitButton.setOnClickListener{
            validateUser()
        }
        resetButton.setOnClickListener{
            resetView()

        }

        // Set up the WindowInsets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        // Create an ArrayAdapter using a predefined string-array
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.Course, // Reference to the array resource
            android.R.layout.simple_spinner_item // Layout resource for the dropdown items
        ).apply {
            // Specify the layout to use when the list of choices appears
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Apply the adapter to the Spinner
        courseSpinner.adapter = adapter


    }
    private fun validateUser(){
        val firstname = firstNameEditText.text.toString().trim()
        val lastname = lastNameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        val phonenumber = phoneEditText.text.toString().trim()
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        val selectedCourse = findViewById<Spinner>(R.id.course_spinner).selectedItem.toString()
        val selectedGender = findViewById<RadioButton>(selectedRadioButtonId)?.text.toString()

        if (firstname =="Dendup" && lastname =="Tshering" && email =="dendup091@gmail.com" && password=="bookoflife"){
            Toast.makeText(this,"Validation Successful Selected Course: $selectedCourse",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Selected Course: $selectedCourse " +
                    "Gender: $selectedGender Phonenumber: $phonenumber ",
                Toast.LENGTH_SHORT).show()
        }
    }
    private fun resetView(){
        firstNameEditText.text.clear()
        lastNameEditText.text.clear()
        emailEditText.text.clear()
        passwordEditText.text.clear()
        phoneEditText.text.clear()
        radioGroup.clearCheck()
        findViewById<Spinner>(R.id.course_spinner).setSelection(0)
    }
}