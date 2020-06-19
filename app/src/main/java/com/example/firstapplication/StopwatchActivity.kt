package com.example.firstapplication

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class StopwatchActivity : AppCompatActivity() {

    private lateinit var anchor: ImageView
    private lateinit var animation: Animation
    private lateinit var startNow: Button
    private lateinit var stop: Button
    private lateinit var resume: Button
    private lateinit var timer: Chronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)

        anchor = findViewById(R.id.hand)
        animation = AnimationUtils.loadAnimation(this, R.anim.rotation)
        startNow = findViewById(R.id.startNow)
        stop = findViewById(R.id.stop)
        resume = findViewById(R.id.resume)
        timer = findViewById(R.id.timer)

        stop.alpha = 0.0f
        resume.alpha = 0.0f
    }

    fun animateAnchor(view: View) {
        anchor.startAnimation(animation)
        stop.animate().alpha(1.0f).translationY(200f).setDuration(300).start()
        startNow.animate().alpha(0.0f).translationY(200f).setDuration(300).start()
        resume.animate().alpha(0.0f).translationY(200f).setDuration(300).start()

        timer.base = SystemClock.elapsedRealtime()
        timer.start()

        Log.d("cer", "start")
    }

    fun stop(view: View) {
        anchor.clearAnimation()
        startNow.animate().alpha(1.0f).translationY(-0f).setDuration(300).start()
        resume.animate().alpha(1.0f).translationY(-200f).setDuration(300).start()
        timer.stop()
        Log.d("cer", "stop")
    }

    fun resume(view: View) {
        anchor.startAnimation(animation)
        timer.start()
        startNow.animate().alpha(0.0f).translationY(200f).setDuration(300).start()
        stop.animate().alpha(1.0f).translationY(200f).setDuration(300).start()
        resume.animate().alpha(0.0f).translationY(200f).setDuration(300).start()
        Log.d("cer", "resume")
    }
}