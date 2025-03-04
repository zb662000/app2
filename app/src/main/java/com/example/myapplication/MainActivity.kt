package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.editTextName)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Declare UI elements
        val editTextName: EditText = findViewById(R.id.editTextName)
        val btnGenerate: Button = findViewById(R.id.btnGenerate)
        val tvResult: TextView = findViewById(R.id.tvResult)

        // Set the click listener on the button
        btnGenerate.setOnClickListener {
            // Get the user's name from the EditText
            val userName = editTextName.text.toString()

            // Check if the name field is not empty
            if (userName.isNotEmpty()) {
                // Generate a random number between 1 and 100
                val randomNumber = Random.nextInt(1, 101)

                // Display the result message
                tvResult.text = "Hi $userName, this is the random number you just generated: $randomNumber"
            } else {
                // Show a toast message if the name is empty
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
