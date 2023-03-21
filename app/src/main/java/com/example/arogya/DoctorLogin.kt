package com.example.arogya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide

class DoctorLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_login)

        Glide.with(this)
            .load(R.drawable.arogya_gif)
            .into(findViewById(R.id.iv_logo))

    }
}