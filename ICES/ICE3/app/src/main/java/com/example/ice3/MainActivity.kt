package com.example.ice3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        val buttonIds = listOf(
            R.id.clear, R.id.percent, R.id.backspace, R.id.divide,
            R.id.seven, R.id.eight, R.id.nine, R.id.multiply,
            R.id.four, R.id.five, R.id.six, R.id.minus,
            R.id.one, R.id.two, R.id.three, R.id.plus,
            R.id.plus_minus, R.id.zero, R.id.decimal, R.id.equals
        )

        buttonIds.forEach { id ->
            val button: Button = findViewById(id)
            button.setOnClickListener {
                val tag = it.tag.toString()
                resultTextView.text = tag
            }
        }
    }
}