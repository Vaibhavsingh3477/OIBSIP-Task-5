package com.example.stopwatch_basic

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnStart:Button
    private lateinit var btnPause: Button
    private lateinit var btnReset:Button
    private lateinit var chronometer: Chronometer
    private var pauseAt:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btnStart)
        btnPause = findViewById(R.id.btnPause)
        btnReset = findViewById(R.id.btnReset)
        chronometer = findViewById(R.id.chronometer)

        btnStart.setOnClickListener {

            chronometer.base = SystemClock.elapsedRealtime()-pauseAt
            chronometer.start()
        }
        btnPause.setOnClickListener {
            pauseAt = SystemClock.elapsedRealtime()-chronometer.base
            chronometer.stop()
        }
        btnReset.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime() as Long
        }
    }
}
