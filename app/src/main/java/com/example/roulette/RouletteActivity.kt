package com.example.roulette

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RouletteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette)

        var list: ArrayList<kotlin.String> = arrayListOf()
        list = intent.getStringArrayListExtra("msg") as ArrayList<String>

        var message: String = ""
        for (l in list) {
            message += l + '\n'
        }

        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }

}