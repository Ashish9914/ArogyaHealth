package com.example.arogya

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class WhoAmI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_who_am_i)

        findViewById<Button>(R.id.button_doctor).setOnClickListener {
            Intent(this,DoctorLogin::class.java).also {
                startActivity(it)
            }
        }
        findViewById<Button>(R.id.button_patient).setOnClickListener {
            Intent(this,PatientLogin::class.java).also {
                startActivity(it)
            }
        }

        /*val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        var screenWidth = displayMetrics.widthPixels / displayMetrics.density
        screenWidth /= 2
        findViewById<Button>(R.id.button_doctor).animate().translationX(-200F).duration = 500
        findViewById<Button>(R.id.button_patient).animate().translationX(200F).duration = 500*/

    }
}