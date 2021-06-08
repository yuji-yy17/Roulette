package com.example.roulette

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toManual(view: View) {
        val intent = Intent(this, InputManuallyActivity::class.java)
        startActivity(intent)
    }

    fun toAutomatic(view: View) {
        val intent = Intent(this, InputAutomaticallyActivity::class.java)
        startActivity(intent)
    }

}