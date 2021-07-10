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
        val button_automatic = findViewById<Button>(R.id.button_automatic)

        button_manual.setOnClickListener{
            val intent = Intent(this, InputManuallyActivity::class.java)
            startActivity(intent)
        }
        button_automatic.setOnClickListener{
            val intent = Intent(this, InputAutomaticallyActivity::class.java)
            startActivity(intent)
        }
    }
}