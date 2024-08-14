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



class Loginpage : AppCompatActivity() {
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var submitButton: Button
    private lateinit var resetButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // For the user validation
        // Finding the user by the id
        firstNameEditText = findViewById(R.id.firstNameEditText)
        lastNameEditText = findViewById(R.id.lastNameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        radioGroup = findViewById(R.id.radioGroup)

        // Find the Spinner by its ID
        val courseSpinner: Spinner = findViewById(R.id.course_spinner)

        submitButton = findViewById(R.id.login_btn)
        resetButton = findViewById(R.id.reset_btn)
        cancelButton = findViewById(R.id.Cancel_btn)

        submitButton.setOnClickListener{
            val firstname = firstNameEditText.text.toString().trim()
            val lastname = lastNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            val selectedCourse = courseSpinner.selectedItem.toString()
            when{
                firstname.isEmpty() ->{
                    Toast.makeText(this,"First Name is Required",Toast.LENGTH_SHORT).show()
                }
                email.isEmpty() -> {
                    Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show()
                }
                phone.isEmpty() -> {
                    Toast.makeText(this, "Phone number is required", Toast.LENGTH_SHORT).show()
                }
                selectedRadioButtonId == -1 -> {
                    Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                    val gender = selectedRadioButton.text.toString()
                    // If all fields are valid, proceed with the next action (e.g., submit the data)
                   val intent = Intent(this, Validation::class.java).apply {
                       putExtra("First_Name",firstname)
                       putExtra("Last_Name",lastname)
                       putExtra("Email",email)
                       putExtra("Phone", phone)
                       putExtra("Gender",gender)
                       putExtra("Course",selectedCourse)
                   }
                    startActivity(intent)

                    // Optionally, navigate to another activity or perform any further actions
                }
            }


        }
        resetButton.setOnClickListener{
            resetView()

        }
        cancelButton.setOnClickListener{
            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)
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
    private fun resetView(){
        firstNameEditText.text.clear()
        lastNameEditText.text.clear()
        emailEditText.text.clear()
        phoneEditText.text.clear()
        radioGroup.clearCheck()
        findViewById<Spinner>(R.id.course_spinner).setSelection(0)
    }
}