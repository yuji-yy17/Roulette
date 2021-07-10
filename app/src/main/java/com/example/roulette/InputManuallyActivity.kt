package com.example.roulette

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get

class InputManuallyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_manully)

        val button_add = findViewById<Button>(R.id.button_add)
        val button_send = findViewById<Button>(R.id.button_send)
        val item_ll = findViewById<LinearLayout>(R.id.linearLayout)
        var count = 0
        val listET: ArrayList<EditText> = arrayListOf()

        button_add.setOnClickListener{
            if (count < 7) {
                val item = EditText(this)
                listET.add(item)
                item_ll.addView(item)
                count ++
            }
        }

        button_send.setOnClickListener{
            val intent = Intent(this, RouletteActivity::class.java).apply {
                val list: ArrayList<String> = arrayListOf()
                for (l in listET) {
                    list.add(l.text.toString())
                }
                putStringArrayListExtra("msg",list)
            }
            startActivity(intent)
        }
    }
}