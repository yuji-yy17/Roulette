package com.example.roulette

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class InputManuallyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_manully)

        val editText: Array<EditText?> = arrayOfNulls<EditText>(7)

        var button_add = findViewById<Button>(R.id.button_add)
        var button_send = findViewById<Button>(R.id.button_send)

        button_add.setOnClickListener{
            // do nothing yet
        }
        button_send.setOnClickListener{
            val intent = Intent(this, RouletteActivity::class.java).apply {
                val list: ArrayList<kotlin.String> = arrayListOf()
                list.add("ラーメン")
                list.add("中華料理")
                list.add("イタリアン")
                putStringArrayListExtra("msg",list)
            }
            startActivity(intent)
        }
    }
}