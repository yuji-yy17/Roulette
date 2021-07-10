package com.example.roulette

import android.media.Image
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class RouletteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette)

        val roulette: ImageView = findViewById(R.id.imageView1)
        val button_spin: Button = findViewById(R.id.button_spin)

        var lastDir: Int = 0
        var spinning: Boolean = false

        val text: TextView = findViewById(R.id.textView)
        val list: ArrayList<String>
        list = intent.getStringArrayListExtra("msg") as ArrayList<String>

        when (list.size) {
            1 -> roulette.setImageResource(R.drawable.pie1)
            2 -> roulette.setImageResource(R.drawable.pie2)
            3 -> roulette.setImageResource(R.drawable.pie3)
            4 -> roulette.setImageResource(R.drawable.pie4)
            5 -> roulette.setImageResource(R.drawable.pie5)
            6 -> roulette.setImageResource(R.drawable.pie6)
            7 -> roulette.setImageResource(R.drawable.pie7)
        }

        roulette.setOnClickListener {
            // 現在の回転角を取得してその結果になるようにルーレットを回す
        }

        button_spin.setOnClickListener {
            if (!spinning) {
                val newDir: Int = 1800 + Random.nextInt(360)
                val pivotX: Float = roulette.width.toFloat() / 2
                val pivotY: Float = roulette.height.toFloat() / 2

                val rotate = RotateAnimation(lastDir.toFloat(), newDir.toFloat(), pivotX, pivotY)
                rotate.duration = 3000
                rotate.fillAfter = true
                rotate.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {
                        spinning = true
                    }
                    override fun onAnimationEnd(animation: Animation) {
                        println(newDir - 1800)
                        text.text = list.get(calcDir(list.size, newDir - 1800))
                        spinning = false
                    }
                    override fun onAnimationRepeat(animation: Animation) {

                    }
                })
                lastDir = newDir - 1800
                roulette.startAnimation(rotate)
            }
        }
    }

    fun calcDir(num: Int, dir: Int): Int {
        var count = 0
        var direction = 360 - dir
        while (true) {
            if ((direction - 360 / num) > 0) {
                direction -= 360 / num
                count++
            } else {
                break
            }
        }
        return count
    }
}