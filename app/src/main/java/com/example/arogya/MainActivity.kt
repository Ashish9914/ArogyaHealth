package com.example.arogya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this)
            .load(R.drawable.arogya_gif)
            .into(findViewById(R.id.logo_gif))

        Handler().postDelayed(Runnable {

            val i = Intent(this, WhoAmI::class.java)
            startActivity(i)
            finish()
        }, 3000)

    }
}