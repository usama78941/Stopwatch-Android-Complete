package com.example.firstapplication

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

     private lateinit var animation: Animation
     private lateinit var btgOne: Animation
     private lateinit var btgTwo: Animation
     private lateinit var imageView: ImageView
     private lateinit var textView: TextView
     private lateinit var subTextView: TextView
     private lateinit var getStarted: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animation = AnimationUtils.loadAnimation(this, R.anim.alpha_to_go)
        btgOne = AnimationUtils.loadAnimation(this, R.anim.btg_one)
        btgTwo = AnimationUtils.loadAnimation(this, R.anim.btg_two)



        Log.d("certain", "Ran Smoothly")

        imageView = findViewById(R.id.illustration)
        Log.d("certain", "here")
        textView = findViewById(R.id.textView)
        subTextView = findViewById(R.id.subTextView)
        getStarted = findViewById(R.id.getStarted)

        imageView.startAnimation(animation)
        textView.startAnimation(btgOne)
        subTextView.startAnimation(btgOne)
        getStarted.startAnimation(btgTwo)
    }

    fun getStarted(view: View) {
        val intent = Intent(this, StopwatchActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
    }
}