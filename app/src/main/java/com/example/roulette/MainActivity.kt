package com.example.roulette

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_manual = findViewById<Button>(R.id.button_manual)

        button_manual.setOnClickListener{
            val intent = Intent(this, InputManuallyActivity::class.java)
            startActivity(intent)
        }
    }
}