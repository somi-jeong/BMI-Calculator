package com.example.study_bmi_calculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.study_bmi_calculator.databinding.ActivityResultBinding
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height : $height weight : $weight")

        val bmi = weight / (height / 100.0).pow(2.0)
        val resultText = when {
            bmi >= 35.0 -> "High Obesity"
            bmi >= 30.0 -> "Moderate Obesity"
            bmi >= 25.0 -> "Mild Obesity"
            bmi >= 23.0 -> "Overweight"
            bmi >= 18.5 -> "Normal Weight"
            else -> "Underweight"
        }

        val bmiTextView = findViewById<TextView>(R.id.bmiTextView)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        bmiTextView.text = bmi.toString()
        resultTextView.text = resultText

    }


}