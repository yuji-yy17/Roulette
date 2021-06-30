package com.example.roulette

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class InputAutomaticallyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_automatically)
    }

    fun sendMessage(view: View) {
        // val editText = findViewById<EditText>(R.id.editText)
        // val message = editText.text.toString()
        val message = ""
        val intent = Intent(this, RouletteActivity::class.java).apply {
            putExtra("msg", message)
        }
        startActivity(intent)
    }

}