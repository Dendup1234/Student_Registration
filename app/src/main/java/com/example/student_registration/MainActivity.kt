package com.example.student_registration

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var fabinfo: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)

        // Toolbar for the menu
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        val submitButton: Button = findViewById(R.id.login_btn)
        val resetButton: Button = findViewById(R.id.reset)
        fabinfo = findViewById(R.id.fab)

        submitButton.setOnClickListener {
            validateUser()
        }

        resetButton.setOnClickListener {
            resetText()
        }

        fabinfo.setOnClickListener {
            Toast.makeText(this, "Student Registration Info: Fill in your details and submit.", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.d("MainActivity", "onCreateOptionsMenu called")
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_save -> {
                Toast.makeText(this, "Save Progress clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_help -> {
                Toast.makeText(this, "Help clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun validateUser() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString()
        if (email == "admin@123" && password == "123") {
            val intent = Intent(this, Loginpage::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Validation Error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun resetText() {
        emailEditText.text.clear()
        passwordEditText.text.clear()
    }
}
