package com.example.roulette

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class RouletteActivity : AppCompatActivity(), SensorEventListener {

    var sensor_X: Float = 0.0f

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

        val sensorManager: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if (sensor != null) {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI)
        } else {
            val ns = "No Support"
            text.text = ns
        }

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
            if (!spinning) {
                val newDir: Int = 1800 + (360 - sensorToDir(sensor_X))
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

    fun sensorToDir(sensor: Float): Int {
        val num: Float
        if (sensor <= 0) {
            num = - sensor * 18
        } else {
            num = (- sensor + 20) * 18
        }
        return num.toInt()
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

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            sensor_X = event.values[0]
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // do nothing
    }
}