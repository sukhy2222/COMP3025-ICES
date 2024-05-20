package com.example.ice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetTextView = findViewById<TextView>(R.id.greetingTextView)

        Log.i("onCreate", "Saying Hello")

        val clickMeButton = findViewById<Button>(R.id.clickMeButton)
        val clickMeButton2 = findViewById<Button>(R.id.clickMeButton2)
        Log.i("MainActivity", "Buttons added")

        clickMeButton.setOnClickListener { greetTextView.text = if(greetTextView.text == "Hello, World!") "Good Bye,World!" else "Hello, World!"}
        clickMeButton2.setOnClickListener { greetTextView.text = if(greetTextView.text == "Hello, World!") "Good Bye,World!" else "Hello, WorId!"}
    }
}
